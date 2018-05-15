package com.dailogexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartHolder> {

    private Context context;
    private ArrayList<Item> items;
    private LayoutInflater layoutInflater;

    public CartAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public CartHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_cart, parent, false);
        return new CartHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class CartHolder extends RecyclerView.ViewHolder {


        public CartHolder(View itemView) {
            super(itemView);
        }


    }

}
