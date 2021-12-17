package com.example.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TextView tv,tvname,tvemail;
    Button logout;

    SharedPreferences sharedPreferences;

    private static final String sharePreferName= "mypref";
    private static final String Key_Name= "name";
    private static final String Key_Email= "email";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv= findViewById(R.id.tv);
        tvname= findViewById(R.id.tv_Name);
        tvemail=findViewById(R.id.tv_Email);
        logout= findViewById(R.id.logout);

        sharedPreferences= getSharedPreferences("sharePreferName",MODE_PRIVATE);
        String names= sharedPreferences.getString(Key_Name, null);
        String emails= sharedPreferences.getString(Key_Email, null);
        if(tvname !=null || tvemail !=null)
        {
            tvname.setText("Name:- "+names);
            tvemail.setText("Email:- "+emails);
        }
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.clear();
                editor.commit();
                finish();
                Toast.makeText(MainActivity2.this, "Logout Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}