package com.example.bonusproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListAdaptor extends BaseAdapter {
    Context c;
    ArrayList id;
    List<DataModel> myData;
    LayoutInflater inflater;

    public ListAdaptor (Context c, List myData){
        this.c = c;
        this.myData = myData;
        inflater = LayoutInflater.from(c);

    }

    @Override
    public int getCount() {
        return myData.size();
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

        tvid.setText(String.valueOf(myData.get(i)));
        return view;
    }
}
