package com.pdm.sube.cum.ejercicio;


import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pdm.sube.cum.DB.models.Ejercicio;
import com.pdm.sube.cum.R;

import java.util.ArrayList;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class EjercicicioUno extends Fragment{

    Ejercicio ejercicio;
    Context context;
    String respuesta = "";

    Boolean leccion;
    @BindView(R.id.imagen_ejercicio)
    ImageView imagen;
    @BindView(R.id.texto_ejercicio)
    TextView texto_ejercicio;
    @BindView(R.id.btn_audio)
    ImageButton btn_audio;
    @BindView(R.id.btn_grabar)
    ImageButton btn_grabar;
    @BindView(R.id.texto_respuesta)
    TextView texto_respuesta;
    @BindView(R.id.btn_comprobar)
    Button btn_comprobar;
    Unbinder unbinder;

    public EjercicicioUno() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ejercicicio_uno, container, false);
        unbinder = ButterKnife.bind(this, v);

        ejercicio = ((EjercicioContainer) getActivity()).getEjercicio();
        leccion = ((EjercicioContainer) getActivity()).getTipo();
        context = getActivity();

        int resId = context.getResources().getIdentifier(ejercicio.getImagen(), "drawable", context.getPackageName());
        imagen.setImageResource(resId);
        texto_ejercicio.setText(ejercicio.getRespuesta());
        texto_respuesta.setText("");


        return v;
    }

    @OnClick({R.id.btn_audio, R.id.btn_grabar, R.id.btn_comprobar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_audio:
                int resId = context.getResources().getIdentifier(ejercicio.getAudio(), "raw", context.getPackageName());
                MediaPlayer mp = MediaPlayer.create(getActivity(), resId);
                mp.start();
                break;
            case R.id.btn_grabar:
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivityForResult(intent, 10);
                } else {
                    Toast.makeText(getActivity(), "Tu dispositivo no soporta Speech to Text", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_comprobar:
                if (respuesta != "") {
                    Log.d("respuesta ", respuesta);
                    Log.d("ejercicio respuesta", "" + ejercicio.getRespuesta());
                    if (respuesta.toLowerCase().equals(ejercicio.getRespuesta())) {
                        Toast.makeText(getActivity(), "Respuesta correcta", Toast.LENGTH_SHORT).show();
                        MediaPlayer mp1 = MediaPlayer.create(getActivity(), R.raw.correcto);
                        mp1.start();
                        ((EjercicioContainer) getActivity()).mostrarBoton();
                        ((EjercicioContainer) getActivity()).setEstado(true);
                    } else {
                        MediaPlayer mp1 = MediaPlayer.create(getActivity(), R.raw.incorrecto);
                        mp1.start();
                        Toast.makeText(getActivity(), "Incorrecto", Toast.LENGTH_SHORT).show();
                        ((EjercicioContainer) getActivity()).mostrarBoton();
                    }
                } else {
                    MediaPlayer mp1 = MediaPlayer.create(getActivity(), R.raw.incorrecto);
                    mp1.start();
                    Toast.makeText(getActivity(), "No hay grabacion", Toast.LENGTH_SHORT).show();
                    ((EjercicioContainer) getActivity()).mostrarBoton();
                }
                break;
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 10:
                if (resultCode == getActivity().RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    if ((ejercicio.getId() == 3 || ejercicio.getId() == 14 && result.get(0) == "y") ||
                            (ejercicio.getId() == 5 || ejercicio.getId() == 21 && result.get(0) == "ü")) {
                        if (ejercicio.getId() == 3 || ejercicio.getId() == 14) {
                            texto_respuesta.setText("i");
                            respuesta = "i";
                        }
                        if (ejercicio.getId() == 5 || ejercicio.getId() == 21) {
                            texto_respuesta.setText("u");
                            respuesta = "u";
                        }
                    } else {
                        texto_respuesta.setText(result.get(0));
                        respuesta = result.get(0);
                    }

                }
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
