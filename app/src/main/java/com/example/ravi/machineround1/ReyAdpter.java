package com.example.ravi.machineround1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ravi on 17/11/17.
 */

public class ReyAdpter extends RecyclerView.Adapter<ReyAdpter.DataViwholder> {




    ArrayList<Data> marrylist;
    Context context;

    public ReyAdpter(ArrayList<Data> marrylist, Context context) {
        this.marrylist = marrylist;
        this.context = context;
    }

    @Override
    public DataViwholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rey_layout,null,false);


        return new DataViwholder(view);
    }

    @Override
    public void onBindViewHolder(DataViwholder holder, int position) {

        Data data = marrylist.get(position);

        Picasso.with(context).load(data.getGroupImg()).into(holder.imageView);
        holder.textView.setText(data.getGroupname());

    }

    @Override
    public int getItemCount() {
        return marrylist.size();
    }

    class DataViwholder extends RecyclerView.ViewHolder
    {

        ImageView imageView ;
        TextView textView;
        public DataViwholder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.grpImg);
            textView =itemView.findViewById(R.id.grpname);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Data data = marrylist.get(getAdapterPosition());
                    Intent intent = new Intent(context,Main2Activity.class);
                    intent.putExtra("Re",data);
                    context.startActivity(intent);
                }
            });


        }
    }
}
