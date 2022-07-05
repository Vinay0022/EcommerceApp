package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.NewRelease;

import java.util.ArrayList;
import java.util.List;

public class NewReleaseAdapterRecyclerAdapter extends RecyclerView.Adapter<NewReleaseAdapterRecyclerAdapter.NewReleaseViewHolder> {
    public Context context;
    public ArrayList<NewRelease> newReleaseList;
    private RecyclerView.ViewHolder holder;
    private int position;

    public NewReleaseAdapterRecyclerAdapter(Context context, ArrayList<NewRelease> newReleaseList){
this.context = context;
this.newReleaseList = newReleaseList;
    }
    @NonNull
    @Override
    public NewReleaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.new_release_recylcer_items,parent,false);
        NewReleaseViewHolder Holder= new NewReleaseViewHolder(view);
        return Holder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewReleaseViewHolder holder, int position) {
        holder.price.setText(newReleaseList.get(position).getPrice());
        holder.gender.setText(newReleaseList.get(position).getGender());
        holder.itemName.setText(newReleaseList.get(position).getName());
          holder.itemImage.setImageResource(newReleaseList.get(position).getImageurl());
    }



    @Override
    public int getItemCount() {
        return newReleaseList.size();
    }

    public class NewReleaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
ImageView itemImage;
TextView price,gender,itemName;
LinearLayout linearLayout_new_release;
        public NewReleaseViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout_new_release = itemView.findViewById(R.id.new_release);
          itemImage = itemView.findViewById(R.id.imageView);
         price = itemView.findViewById(R.id.price);
         gender = itemView.findViewById(R.id.gender);
         itemName = itemView.findViewById(R.id.shows_name);

        }

        @Override
        public void onClick(View view) {

        }
    }
}
