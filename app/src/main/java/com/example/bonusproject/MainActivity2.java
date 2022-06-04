package com.example.bonusproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    Button b2, b3;
    EditText et1, et2;
    DataModel usermodel;
    DBHandler myDB;

    private View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.button2:
                    goToActiviy1();
                    break;
                case R.id.button3:
                    AddUser();
                    break;
            }
        }
    };

    private void AddUser() {
        myDB = new DBHandler(this);
        usermodel = new DataModel(1, et1.getText().toString(), et2.getText().toString());
        myDB.insertUser(usermodel);
        et1.setText("");
        et2.setText("");
        Toast toast = Toast.makeText(this,"Data telah disimpan",Toast.LENGTH_LONG);
        toast.show();
    }


    private void goToActiviy1(){
        Intent i = new Intent(this, MainActivity .class);
        startActivity(i);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b2.setOnClickListener(click);
        b3.setOnClickListener(click);

        et1 = findViewById(R.id.etNama);
        et2 = findViewById(R.id.etPassword);
    }
}