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
public class EjercicioDos extends Fragment {

    Ejercicio ejercicio;
    Context context;
    String respuesta = "";
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

    public EjercicioDos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ejercicio_dos, container, false);
        unbinder = ButterKnife.bind(this, v);

        ejercicio = ((EjercicioContainer) getActivity()).getEjercicio();
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
                        MediaPlayer mp1 = MediaPlayer.create(getActivity(), R.raw.correcto);
                        mp1.start();
                        Toast.makeText(getActivity(), "Respuesta correcta", Toast.LENGTH_SHORT).show();
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
                    respuesta = result.get(0);
                    switch (ejercicio.getId()){
                        case 3:
                            if(result.get(0) == "y"){
                                respuesta = "i";
                            }
                            break;
                        case 5:
                            if(result.get(0) == "ü"){
                                respuesta = "u";
                            }
                            break;
                        case 7:
                            if(result.get(0) == "v"){
                                respuesta = "b";
                            }
                            break;
                        case 9:
                            if(result.get(0) == "de"){
                                respuesta = "d";
                            }
                            break;
                        case 14:
                            if(result.get(0) == "y"){
                                respuesta = "i";
                            }
                            break;
                        case 21:
                            if(result.get(0) == "ü"){
                                respuesta = "u";
                            }
                            break;
                    }
                    texto_respuesta.setText(respuesta);
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
