package com.example.catagories;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CatagoriesAdapter extends RecyclerView.Adapter<CatagoriesAdapter.myviewHolder> {

    ArrayList<CatagoriesModel> list;
    Context mcontext;

    public CatagoriesAdapter(ArrayList<CatagoriesModel> list, Context mcontext) {
        this.list = list;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public myviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custome_catagories_view,parent,false);
        return new myviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());

        String cimg=list.get(position).getImg();

        Glide.with(mcontext).load(cimg).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myviewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;

        public myviewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.imageview_id);
            name=itemView.findViewById(R.id.catagoreis_name);

        }
    }
}
