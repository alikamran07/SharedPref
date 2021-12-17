package com.example.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt1,edt2;
    Button btnSubmit,clearbtn,sharebtn;
    SharedPreferences sharedPreferences;

    private static final String sharePreferName= "mypref";
    private static final String Key_Name= "name";
    private static final String Key_Email= "email";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1= findViewById(R.id.edt1);
        edt2= findViewById(R.id.edt2);
        btnSubmit=findViewById(R.id.btn);
        clearbtn=findViewById(R.id.btnClear);
        sharebtn=findViewById(R.id.btnShare);

        sharedPreferences= getSharedPreferences("sharePreferName",MODE_PRIVATE);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString(Key_Name,edt1.getText().toString());
                editor.putString(Key_Email,edt2.getText().toString());
                editor.apply();
                Intent intent= new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Login Succeed", Toast.LENGTH_SHORT).show();
            }
        });
        clearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText("");
                edt2.setText("");
            }
        });
        sharebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, "Just go ");
                intent.setType("text/plain");
               // startActivity(intent);

                if(intent.resolveActivity(getPackageManager())!=null)
                {
                    startActivity(intent);
                }
            }
        });
    }

}