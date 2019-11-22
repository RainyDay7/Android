package com.example.game_mao2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ShareActionProvider;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText etName;
    private EditText etPwd;
    private CheckBox cbRemember;
    private Button btLogin;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pref = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isRemembered = pref.getBoolean("remembered", false);
        etName = (EditText)findViewById(R.id.text_name);
        etPwd = (EditText)findViewById(R.id.text_password);
        cbRemember = (CheckBox)findViewById(R.id.cbRemember);
        if(isRemembered){
            etName.setText(pref.getString("username",""));
            etPwd.setText(pref.getString("password", ""));
            cbRemember.setChecked(true);
        }
        Button btn_login = (Button)findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CheckLog()){//登录信息正确，判断是否保存当前登录信息
                    if(cbRemember.isChecked()){//保存登录信息
                        String id = etName.getText().toString();
                        String pwd = etPwd.getText().toString();
                        editor = pref.edit();
                        editor.putString("username", id);
                        editor.putString("password", pwd);
                        editor.putBoolean("remembered", true);
                        Toast.makeText(LoginActivity.this, "登录信息已保存！", Toast.LENGTH_LONG).show();
                    }
                    else {
                        editor.clear();//清除SharedPreferences数据
                    }
                    editor.apply();
                    Toast.makeText(LoginActivity.this, "登录成功！",Toast.LENGTH_SHORT ).show();
                    Intent intent = new Intent();
                    intent.setClass(LoginActivity.this, WelcomeActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LoginActivity.this, "用户名或密码错误!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean CheckLog() {//判断用户名和密码是否正确
        String id= etName.getText().toString();
        String pwd = etPwd.getText().toString();
        //用户名是admin ，密码是123
        if (id.equals("admin")&&pwd.equals("admin")){
            return true;
        }
        return false;
    }
}
