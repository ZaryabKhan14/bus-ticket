package com.example.busticket;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Homefragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Homefragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Homefragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Homefragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Homefragment newInstance(String param1, String param2) {
        Homefragment fragment = new Homefragment();
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

        Spinner spi,sp2,sp3;
        Button btn;

        View myview = inflater.inflate(R.layout.fragment_homefragment, container, false);


        spi = (Spinner) myview.findViewById(R.id.departurespiner);
        sp2 = (Spinner) myview.findViewById(R.id.terminalspiner);
        sp3 = (Spinner) myview.findViewById(R.id.busspinner);

        btn = (Button) myview.findViewById(R.id.findbtn);
        database db = new database(getContext());

        List<String> address = db.address();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),R.layout.support_simple_spinner_dropdown_item,address);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spi.setAdapter(adapter);



        List<String> bus = db.address();
        ArrayAdapter<String> buss = new ArrayAdapter<>(getContext(),R.layout.support_simple_spinner_dropdown_item,bus);
        buss.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp2.setAdapter(buss);


        ArrayAdapter<CharSequence> peter = ArrayAdapter.createFromResource(getContext(), R.array.bus, R.layout.support_simple_spinner_dropdown_item);
        peter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp3.setAdapter(peter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String destination = sp2.getSelectedItem().toString();
                Intent o = new Intent(getContext(), filterReycleview.class );
                o.putExtra("destination",destination);
                startActivity(o);
            }
        });

  SharedPreferences shar = getContext().getSharedPreferences("kuchbhi",MODE_PRIVATE);
  if (!shar.contains("mob")){

  }


        return myview;
    }


}