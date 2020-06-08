package com.example.muiapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList titlesData;
    int imagesData[];
    Context context;

    public MyAdapter(Context ct, ArrayList titles, int images[]){
        context = ct;
        titlesData = titles;
        imagesData = images;
    }


    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, final int position) {
        holder.title.setText(titlesData.get(position).toString());
        holder.image.setImageResource(imagesData[position]);

        holder.row_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked on: " + titlesData.get(position).toString(), Toast.LENGTH_SHORT).show();
                titlesData.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return titlesData.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

       private TextView title;
       private ImageView image;
       private ConstraintLayout row_layout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.text_title);
            image = itemView.findViewById(R.id.img_view);
            row_layout = itemView.findViewById(R.id.const_row_layout);
        }

    }


}
