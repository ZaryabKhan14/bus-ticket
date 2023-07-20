package com.example.busticket;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adminadapater extends RecyclerView.Adapter<adminadapater.idfetch> {

    ArrayList<adminaddnearandbuses> add;

    public adminadapater(ArrayList<adminaddnearandbuses> add) {
        this.add = add;
    }

    @NonNull
    @Override
    public idfetch onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

     View myview = LayoutInflater.from(parent.getContext()).inflate(R.layout.admincardviewrecycleview,parent,false);
     return new idfetch(myview);

    }

    @Override
    public void onBindViewHolder(@NonNull idfetch holder, int position) {

        holder.t1.setText( ""+add.get(position).getId());
        holder.t2.setText(add.get(position).getBus());
        holder.t3.setText(add.get(position).getCate());
        holder.t4.setText(add.get(position).getArea());


    }

    @Override
    public int getItemCount() {
        return add.size();
    }

    class idfetch extends RecyclerView.ViewHolder {

        TextView t1,t2,t3,t4;
        public idfetch(@NonNull View itemView) {
            super(itemView);

            t1 = (TextView) itemView.findViewById(R.id.id);
            t2 = (TextView) itemView.findViewById(R.id.busname);
            t3 = (TextView) itemView.findViewById(R.id.buses);
            t4 = (TextView) itemView.findViewById(R.id.busarea);
        }
    }
}


