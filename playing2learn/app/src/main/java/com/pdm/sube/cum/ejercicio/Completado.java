package com.pdm.sube.cum.ejercicio;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.pdm.sube.cum.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Completado extends Fragment implements View.OnClickListener {

    Button btn_fin;
    TextView txt_estado, txt_total, txt_aprobados, txt_reprobados;
    ImageView imagen_estado;

    public Completado() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_completado, container, false);
        btn_fin = v.findViewById(R.id.btn_fin);
        txt_estado = v.findViewById(R.id.txt_estado);
        txt_total = v.findViewById(R.id.txt_total);
        txt_aprobados = v.findViewById(R.id.txt_aprovadas);
        txt_reprobados = v.findViewById(R.id.txt_reprobadas);
        imagen_estado = v.findViewById(R.id.imagen_estado);

        txt_estado.setText("Resumen");
        if(((EjercicioContainer)getActivity()).getTipo() == false){
            txt_total.setText("Nota: "+((EjercicioContainer)getActivity()).getNota());
            if(((EjercicioContainer)getActivity()).getNota() > 7.0){
                imagen_estado.setImageResource(R.drawable.completado);
            }else{
                imagen_estado.setImageResource(R.drawable.mal_resultado);
            }
        }else{
            txt_total.setText("Total de Ejercicos: "+((EjercicioContainer)getActivity()).totalEjercicios());
            if(((EjercicioContainer)getActivity()).getNota() > 7.0){
                imagen_estado.setImageResource(R.drawable.completado_icono);
            }else{
                imagen_estado.setImageResource(R.drawable.practicar);
            }
        }
        if(((EjercicioContainer)getActivity()).getNota() > 7.0){
            MediaPlayer mp = MediaPlayer.create(getActivity(),R.raw.felicidades);
            mp.start();
        }else{
            MediaPlayer mp = MediaPlayer.create(getActivity(),R.raw.sigue);
            mp.start();
        }
        txt_aprobados.setText("Ejercicios Aprobados: "+((EjercicioContainer)getActivity()).getAprobadas());
        txt_reprobados.setText("Ejercicios Reprobados: "+((EjercicioContainer)getActivity()).getReprobadas());


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
