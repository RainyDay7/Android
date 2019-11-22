package com.example.game_mao2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class RoundActivity extends AppCompatActivity {
    private Intent i1, i2, i3, i4, i5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);

        Button btn1 = (Button)findViewById(R.id.btn_q1);
        Button btn2 = (Button)findViewById(R.id.btn_q2);
        Button btn3 = (Button)findViewById(R.id.btn_q3);
        Button btn4 = (Button)findViewById(R.id.btn_q4);
        Button btn5 = (Button)findViewById(R.id.btn_q5);

        View.OnClickListener mylistener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_q1: i1 = new Intent(); i1.putExtra("round", 1);i1.setClass(RoundActivity.this, Question1Activity.class);startActivity(i1);break;
                    case R.id.btn_q2: i2 = new Intent(); i2.putExtra("round", 2);i2.setClass(RoundActivity.this, Question2Activity.class);startActivity(i2);break;
                    case R.id.btn_q3: i3 = new Intent(); i3.putExtra("round", 3);i3.setClass(RoundActivity.this, Question3Activity.class);startActivity(i3);break;
                    case R.id.btn_q4: i4 = new Intent(); i4.putExtra("round", 4);i4.setClass(RoundActivity.this, Question4Activity.class);startActivity(i4);break;
                    case R.id.btn_q5: i5 = new Intent(); i5.putExtra("round", 5);i5.setClass(RoundActivity.this, Question5Activity.class);startActivity(i5);break;
                }
            }
        };
        btn1.setOnClickListener(mylistener);
        btn2.setOnClickListener(mylistener);
        btn3.setOnClickListener(mylistener);
        btn4.setOnClickListener(mylistener);
        btn5.setOnClickListener(mylistener);
    }
}
