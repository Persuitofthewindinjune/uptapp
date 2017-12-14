package com.example.uiwidgettest;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class UIinterface extends AppCompatActivity implements View.OnClickListener {

//    EditText UIname = (EditText)findViewById(R.id.registername);
//   TextView UItextname = (TextView) findViewById(R.id.user_name);

    TextView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uiinterface);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        String username = load();
        user = (TextView)findViewById(R.id.user_name);
        if(!TextUtils.isEmpty(username)){
            user.setText(username);
            Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {

    }

    public String load(){
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder user_name = new StringBuilder();
        try{
            in = openFileInput("user_information");
            reader = new BufferedReader(new InputStreamReader(in));
            String line ="";
            while ((line = reader.readLine()) != null){user_name.append(line);}
        }   catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(reader != null){
                try {
                reader.close();
            }
            catch (IOException e){e.printStackTrace();}
            }
        }
      return user_name.toString();
    }
}