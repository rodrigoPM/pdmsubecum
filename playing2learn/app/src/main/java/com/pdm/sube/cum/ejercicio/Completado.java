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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Completado extends Fragment {



    @BindView(R.id.txt_estado)
    TextView txt_estado;
    @BindView(R.id.btn_fin)
    Button btn_fin;
    @BindView(R.id.txt_total)
    TextView txt_total;
    @BindView(R.id.txt_aprobadas)
    TextView txt_aprobados;
    @BindView(R.id.txt_reprobadas)
    TextView txt_reprobados;
    @BindView(R.id.imagen_estado)
    ImageView imagen_estado;
    Unbinder unbinder;

    public Completado() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_completado, container, false);
        unbinder = ButterKnife.bind(this, v);

        txt_estado.setText("Resumen");
        if (((EjercicioContainer) getActivity()).getTipo() == false) {
            txt_total.setText("Nota: " + ((EjercicioContainer) getActivity()).getNota());
            if (((EjercicioContainer) getActivity()).getNota() > 7.0) {
                imagen_estado.setImageResource(R.drawable.completado);
            } else {
                imagen_estado.setImageResource(R.drawable.mal_resultado);
            }
        } else {
            txt_total.setText("Total de Ejercicos: " + ((EjercicioContainer) getActivity()).totalEjercicios());
            if (((EjercicioContainer) getActivity()).getNota() > 7.0) {
                imagen_estado.setImageResource(R.drawable.completado_icono);
            } else {
                imagen_estado.setImageResource(R.drawable.practicar);
            }
        }
        if (((EjercicioContainer) getActivity()).getNota() > 7.0) {
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.felicidades);
            mp.start();
        } else {
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.sigue);
            mp.start();
        }

        txt_aprobados.setText("Ejercicios Aprobados: "+((EjercicioContainer)getActivity()).getAprobadas());
        txt_reprobados.setText("Ejercicios Reprobados: "+((EjercicioContainer)getActivity()).getReprobadas());



        return v;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_fin)
    public void onViewClicked() {
        ((EjercicioContainer) getActivity()).salir();
    }
}
