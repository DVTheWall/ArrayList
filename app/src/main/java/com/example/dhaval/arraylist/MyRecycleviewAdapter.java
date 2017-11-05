package com.example.dhaval.arraylist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Dhaval on 22-Apr-17.
 */

public class MyRecycleviewAdapter extends RecyclerView.Adapter<MyRecycleviewAdapter.CustomViewHolder> {

    Context context;
    ArrayList<Bean> list = null;

    public MyRecycleviewAdapter(Context context, ArrayList<Bean> list) {
        this.context = context;
        this.list = list; // All List are present in list
    }

    //
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_iem, parent, false);
        CustomViewHolder holder = new CustomViewHolder(v); ///convert the android view to our customview for particular one item
        return holder;// return our customview holder

    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

        Bean obj = list.get(position); // return  Bean class..

        // set text
        holder.tv_name.setText(obj.getName());
        holder.tv_address.setText(obj.getAddress());
        holder.tv_id.setText(String.valueOf(obj.getId()));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tv_name, tv_address, tv_id;

        public CustomViewHolder(final View itemView) { // this Constructor is used for create particular  one item....
            super(itemView);

            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_address = (TextView) itemView.findViewById(R.id.tv_address);
            tv_id = (TextView) itemView.findViewById(R.id.tv_id);

            tv_name.setOnClickListener(this);
            tv_address.setOnClickListener(this);
            tv_id.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            int position = getAdapterPosition();

            switch (v.getId()) {
                case R.id.tv_name:
                    Toast.makeText(context, tv_name.getText() + " " + position, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.tv_address:
                    Toast.makeText(context, tv_address.getText() + " " + position, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.tv_id:
                    Toast.makeText(context, tv_id.getText() + " " + position, Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    }
}
