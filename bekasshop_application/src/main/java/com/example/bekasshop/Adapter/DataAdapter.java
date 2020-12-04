package com.example.bekasshop.Adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.bekasshop.Activity.OrderActivity;
import com.example.bekasshop.Model.Product;
import com.example.bekasshop.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> implements Filterable {
    private ArrayList<Product> mArrayList;
    private ArrayList<Product> mFilteredList;

    public DataAdapter(ArrayList<Product> arrayList) {
        mArrayList = arrayList;
        mFilteredList = arrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.tv_name.setText(mFilteredList.get(i).getName());
        viewHolder.tv_version.setText("Rp. " + mFilteredList.get(i).getPrice());
        Picasso.get()
                .load("http://192.168.1.5/bekasshopAPI/Image/"+mFilteredList.get(i).getImage())
                .into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return mFilteredList.size();
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();

                if (charString.isEmpty()) {

                    mFilteredList = mArrayList;
                } else {

                    ArrayList<Product> filteredList = new ArrayList<>();

                    for (Product androidVersion : mArrayList) {

                        if (androidVersion.getName().toLowerCase().contains(charString) || androidVersion.getName().contains(charString)) {

                            filteredList.add(androidVersion);
                        }
                    }

                    mFilteredList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredList = (ArrayList<Product>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tv_name,tv_version;
        ImageView imageView;

        public ViewHolder(View view) {
            super(view);

            tv_name = (TextView)view.findViewById(R.id.tv_name);
            tv_version = (TextView)view.findViewById(R.id.tv_version);
            imageView = itemView.findViewById(R.id.img_sampul);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Product result = mFilteredList.get(position);

            Context context = view.getContext();
            Intent intent = new Intent(context, OrderActivity.class);

            intent.putExtra("itemId", mFilteredList.get(position).getId());
            intent.putExtra("itemName", mFilteredList.get(position).getName());
            intent.putExtra ("itemImage", mFilteredList.get(position).getImage());
            intent.putExtra("itemDesc", mFilteredList.get(position).getDescription());
            intent.putExtra("itemPrice", mFilteredList.get(position).getPrice());

            context.startActivity(intent);
        }
    }

}