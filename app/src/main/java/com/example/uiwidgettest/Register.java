package com.example.uiwidgettest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.TouchUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Register extends AppCompatActivity implements View.OnClickListener{

    EditText user;
    EditText phone;
    EditText password;
    Button register;
    Spinner sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
        Button button = (Button) findViewById(R.id.back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this,UIWidgetTest.class);
                startActivity(intent);
            }
        });
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
       // setContentView(R.layout.activity_register);
        user = (EditText)findViewById(R.id.registername);
        phone = (EditText)findViewById(R.id.registerphone);
        password = (EditText)findViewById(R.id.secret);
        sex = (Spinner)findViewById(R.id.sex);
        register = (Button)findViewById(R.id.registersucceed);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.registersucceed:
                String username = user.getText().toString();
                String userpassword = password.getText().toString().trim();
                String userphone =phone.getText().toString();
                View usersex = sex.getEmptyView();
                if(username.isEmpty()||userpassword.isEmpty())
                {
                    Toast.makeText(this,"密码或账号不能为空",Toast.LENGTH_SHORT).show();
                }else if(userphone.isEmpty())
                {Toast.makeText(this,"号码不能为空",Toast.LENGTH_LONG).show();}
                else {
                    String intput_Text = user.getText().toString() ;
                    save(intput_Text);
                    Intent intent = new Intent(Register.this,UIinterface.class);
                    startActivity(intent);
                }
        }
        public void save(String intputText) {
            FileOutputStream out = null;
            BufferedWriter write = null;
            try{
                out = openFileOutput("user_information", Context.MODE_PRIVATE);
                write = new BufferedWriter(new OutputStreamWriter(out));
                write.write(intputText);}
          catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (write != null) {write.close();}
                }   catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

//}
