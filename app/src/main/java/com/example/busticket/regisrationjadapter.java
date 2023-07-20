package com.example.busticket;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class regisrationjadapter extends RecyclerView.Adapter<regisrationjadapter.idlekaaojaopeter>  {

    ArrayList<userregisration> user;

    public regisrationjadapter(ArrayList<userregisration> user) {
        this.user = user;
    }

    @NonNull
    @Override
    public idlekaaojaopeter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View myview = LayoutInflater.from(parent.getContext()).inflate(R.layout.registrationcard,parent,false);
        return new idlekaaojaopeter(myview);
    }

    @Override
    public void onBindViewHolder(@NonNull idlekaaojaopeter holder, int position) {

        holder.t1.setText("" + user.get(position).getId());
        holder.t2.setText(user.get(position).getName());
        holder.t3.setText( user.get(position).getCnic());
        holder.t4.setText( user.get(position).getPhone());
        holder.t5.setText( user.get(position).getPswd());
        holder.t6.setText( user.get(position).getCpswd());
        holder.t7.setText( user.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return user.size();
    }

    class idlekaaojaopeter extends RecyclerView.ViewHolder {

        TextView t1,t2,t3,t4,t5,t6,t7;
        public idlekaaojaopeter(@NonNull View itemView) {

            super(itemView);

            t1 = (TextView) itemView.findViewById(R.id.registid);
            t2 = (TextView) itemView.findViewById(R.id.registname);
            t3 = (TextView) itemView.findViewById(R.id.registcnic);
            t4 = (TextView) itemView.findViewById(R.id.registnum);
            t5 = (TextView) itemView.findViewById(R.id.registpswd);
            t6 = (TextView) itemView.findViewById(R.id.registcpswd);
            t7 = (TextView) itemView.findViewById(R.id.registaddrss);


        }
    }
}
