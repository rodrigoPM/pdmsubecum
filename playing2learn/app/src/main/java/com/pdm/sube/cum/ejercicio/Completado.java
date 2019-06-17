package com.pdm.sube.cum.ejercicio;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pdm.sube.cum.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Completado extends Fragment implements View.OnClickListener {

    Button btn_fin;

    public Completado() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_completado, container, false);
        btn_fin = v.findViewById(R.id.btn_fin);
        btn_fin.setOnClickListener(this);
        return  v;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_fin:
                ((EjercicioContainer)getActivity()).salir();
                break;
        }
    }
}
