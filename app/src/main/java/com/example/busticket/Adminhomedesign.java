package com.example.busticket;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Adminhomedesign#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Adminhomedesign extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Adminhomedesign() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Adminhomedesign.
     */
    // TODO: Rename and change types and number of parameters
    public static Adminhomedesign newInstance(String param1, String param2) {
        Adminhomedesign fragment = new Adminhomedesign();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        Spinner sp;
        TextInputLayout ed1,ed2,ed3,ed4;
        Button btn1,btn2,btn3,btn4;
        View myview = inflater.inflate(R.layout.fragment_adminhomedesign, container, false);

        ed1 = (TextInputLayout) myview.findViewById(R.id.addnearname);
        ed2 = (TextInputLayout) myview.findViewById(R.id.addbus);
        ed3 = (TextInputLayout) myview.findViewById(R.id.addarea);
        sp = (Spinner) myview.findViewById(R.id.catespiner);
        btn1 = (Button) myview.findViewById(R.id.addednear);
        btn2 = (Button) myview.findViewById(R.id.added);

       busdatabase busdata = new busdatabase(getContext());
        database db = new database(getContext());


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.bus, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp.setAdapter(adapter);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String near = ed1.getEditText().getText().toString();




                if (db.insert(near)){
                    Toast.makeText(getContext(), "Added", Toast.LENGTH_SHORT).show();
                }

                else {
                    Toast.makeText(getContext(), "Added not", Toast.LENGTH_SHORT).show();
                }


            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bus = ed2.getEditText().getText().toString();
                String cat = sp.getSelectedItem().toString();
                String area = ed3.getEditText().getText().toString();


                if (busdata.addbus(bus,cat,area)){
                    Toast.makeText(getContext(), "Added", Toast.LENGTH_SHORT).show();


                }

                else {
                    Toast.makeText(getContext(), "Added not", Toast.LENGTH_SHORT).show();
                }


            }
        });












        return myview;
    }
}