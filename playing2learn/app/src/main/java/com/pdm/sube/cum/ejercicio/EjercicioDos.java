package com.pdm.sube.cum.ejercicio;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.pdm.sube.cum.DB.models.Ejercicio;
import com.pdm.sube.cum.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EjercicioDos extends Fragment {

    ImageView imagen;
    Ejercicio ejercicio;

    public EjercicioDos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_ejercicio_dos, container, false);

        imagen = v.findViewById(R.id.imagen_ejercicio);
        ejercicio = ((EjercicioContainer)getActivity()).getEjercicio();
        imagen.setImageResource(ejercicio.getImagen());

        return v;
    }

}
