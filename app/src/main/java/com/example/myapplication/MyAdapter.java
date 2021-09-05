package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;

    ArrayList<Product> productArrayList;

    public MyAdapter(Context context, ArrayList<Product> productArrayList) {
        this.context = context;
        this.productArrayList = productArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Product product = productArrayList.get(position);
        holder.Product.setText(product.Product);
        holder.SerialNumber.setText(product.SerialNumber);
        holder.Block.setText(product.Block);
        holder.Fullname.setText(product.Fullname);

    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Product, SerialNumber, Block, Fullname;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Product = itemView.findViewById(R.id.tv_product);
            SerialNumber = itemView.findViewById(R.id.tv_serialNumber);
            Block = itemView.findViewById(R.id.tv_block);
            Fullname = itemView.findViewById(R.id.tv_fullName);
        }
    }

}
