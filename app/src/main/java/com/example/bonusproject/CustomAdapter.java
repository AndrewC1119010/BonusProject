package com.example.bonusproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {
    Context c;
    ArrayList id,name,pass;
    List<DataModel> myData;
    LayoutInflater inflater;

    public CustomAdapter(Context c, ArrayList id, ArrayList name, ArrayList pass){
        this.c = c;
        this.id = id;
        this.name = name;
        this.pass = pass;
        inflater = LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return id.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.my_lvelement, null);
        TextView tvid = (TextView) view.findViewById(R.id.textView3);
        TextView tvnama = (TextView) view.findViewById(R.id.textView4);
        TextView tvpass = (TextView) view.findViewById(R.id.textView5);

        tvid.setText(String.valueOf(id.get(i)));
        tvnama.setText(String.valueOf(name.get(i)));
        tvpass.setText(String.valueOf(pass.get(i)));

        return view;
    }

}
