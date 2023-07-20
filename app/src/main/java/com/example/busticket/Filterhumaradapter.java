package com.example.busticket;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Filterhumaradapter extends RecyclerView.Adapter<Filterhumaradapter.idleakao> {

    ArrayList<filteradapter> fliter;
    List<filteradapter> filteradapterList;

    public Filterhumaradapter(ArrayList<filteradapter> fliter) {
        this.fliter = fliter;
    }

    public Filterhumaradapter(List<filteradapter> filteradapterList) {
        this.filteradapterList = filteradapterList;
    }

    @NonNull
    @Override
    public idleakao onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myview = LayoutInflater.from(parent.getContext()).inflate(R.layout.busfilterview,parent,false);
        return new idleakao(myview);
    }

    @Override
    public void onBindViewHolder(@NonNull idleakao holder, int position) {

        holder.txt1.setText(fliter.get(position).getBus());
        holder.txt2.setText(fliter.get(position).getCate());
        holder.txt3.setText(fliter.get(position).getArea());
    }

    @Override
    public int getItemCount() {
        return fliter.size();
    }



    class idleakao extends RecyclerView.ViewHolder {
      TextView txt1,txt2,txt3;
        public idleakao(@NonNull View itemView) {
            super(itemView);

            txt1 = (TextView) itemView.findViewById(R.id.BUS);
            txt2 = (TextView) itemView.findViewById(R.id.BUSCATE);
            txt3 = (TextView) itemView.findViewById(R.id.BUSAREA);
        }
    }
}
