package com.example.bonusproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button b1;
    ListView myLv;
    List<DataModel> myData;
    ArrayList<String> id, name, pass;
    DBHandler myDB;

    private final View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button:
                    goToActivity2();
                    break;
            }
        }
    };

    private void goToActivity2() {
        Intent i = new Intent(this, MainActivity2.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.button);
        b1.setOnClickListener(click);

        id = new ArrayList<>();
        name = new ArrayList<>();
        pass = new ArrayList<>();

        myDB = new DBHandler(this);

        //getalldata();
        List<ArrayList> data = myDB.getlistALL();

        myLv = (ListView) findViewById(R.id.listView);

        ListAdaptor lAdaptor = new ListAdaptor(getApplicationContext(), data);
        myLv.setAdapter(lAdaptor);

//        CustomAdapter cAdapter = new CustomAdapter(getApplicationContext(), id, name, pass);
//        myLv.setAdapter(cAdapter);
    }

    private void getalldata() {
        Cursor c = myDB.getAll();
        while (c.moveToNext()) {
            id.add(c.getString(0));
            name.add(c.getString(1));
            pass.add(c.getString(2));
        }
        Log.d("getdata", "Sucsess");
    }
}