package com.pdm.sube.cum.ejercicio;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v4.app.Fragment;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class EjercicioDos extends Fragment implements View.OnClickListener {

    ImageView imagen;
    TextView texto_ejercicio,texto_respuesta;
    ImageButton btn_audio,btn_grabar;
    Button btn_comprobar;
    Ejercicio ejercicio;
    String respuesta = "";

    public EjercicioDos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_ejercicio_dos, container, false);

        imagen = v.findViewById(R.id.imagen_ejercicio);
        texto_ejercicio = v.findViewById(R.id.texto_ejercicio);
        btn_audio = v.findViewById(R.id.btn_audio);
        btn_grabar = v.findViewById(R.id.btn_grabar);
        texto_respuesta = v.findViewById(R.id.texto_respuesta);
        btn_comprobar = v.findViewById(R.id.btn_comprobar);

        ejercicio = ((EjercicioContainer)getActivity()).getEjercicio();
        imagen.setImageResource(ejercicio.getImagen());
        texto_ejercicio.setText(ejercicio.getRespuesta());
        texto_respuesta.setText("");

        btn_audio.setOnClickListener(this);
        btn_grabar.setOnClickListener(this);
        btn_comprobar.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_audio:
                MediaPlayer mp = MediaPlayer.create(getActivity(),ejercicio.getAudio());
                mp.start();
                break;
            case R.id.btn_grabar:
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

                if(intent.resolveActivity(getActivity().getPackageManager()) != null){
                    startActivityForResult(intent,10);
                }else {
                    Toast.makeText(getActivity(),"Tu dispositivo no soporta Speech to Text",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_comprobar:
                if(respuesta != ""){
                    if(respuesta.equals(ejercicio.getRespuesta())){
                        Toast.makeText(getActivity(),"Respuesta correcta",Toast.LENGTH_SHORT).show();
                        ((EjercicioContainer)getActivity()).mostrarBoton();
                    }else{
                        Toast.makeText(getActivity(),"Incorrecto",Toast.LENGTH_SHORT).show();
                    }
                }else{

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
                    texto_respuesta.setText(result.get(0));
                    respuesta = result.get(0);
                }
                break;
        }
    }
}
