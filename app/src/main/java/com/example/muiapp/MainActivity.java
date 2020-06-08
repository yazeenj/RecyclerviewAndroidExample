package com.example.muiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mylist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mylist = findViewById(R.id.list_mylist);

        ArrayList<String> titles = new ArrayList<>();
        titles.add("Yazeen");
        titles.add("Johan");
        titles.add("Ec");
        titles.add("Testing");

        int images[] = new int[]{android.R.drawable.ic_dialog_email,
                android.R.drawable.ic_dialog_info,
                android.R.drawable.ic_dialog_alert,
                android.R.drawable.ic_dialog_map};

        MyAdapter adp = new MyAdapter(this,titles,images);
        mylist.setAdapter(adp);
        mylist.setLayoutManager(new LinearLayoutManager(this));

    }

}
