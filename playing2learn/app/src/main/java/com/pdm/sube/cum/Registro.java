package com.pdm.sube.cum;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pdm.sube.cum.DB.models.DetalleExamen;
import com.pdm.sube.cum.DB.models.DetalleSeccion;
import com.pdm.sube.cum.DB.models.Usuario;
import com.pdm.sube.cum.DB.models.Usuario_Table;
import com.pdm.sube.cum.seccion.MenuActivity;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.Date;

public class Registro extends AppCompatActivity implements View.OnClickListener{

    TextInputLayout til_usuario,til_password1,til_password2,til_correo;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        this.til_usuario = findViewById(R.id.til_usuario);
        this.til_password1 = findViewById(R.id.til_password1);
        this.til_password2 = findViewById(R.id.til_password2);
        this.til_correo = findViewById(R.id.til_correo);
        this.button2 = findViewById(R.id.button2);
        this.button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        Usuario user=new Usuario();
        try {
        user = SQLite.select().from(Usuario.class).where(Usuario_Table.usuario.eq(this.til_usuario.getEditText().getText().toString())).queryList().get(0);
        }catch (Exception e){
            user = null;
        }
        //try{
            if(user != null){
                Toast.makeText(this, "El Usuario ya existe", Toast.LENGTH_SHORT).show();
            }else{
                if (til_usuario.getEditText().getText().toString().isEmpty()){
                    Toast.makeText(this,"digite usuario", Toast.LENGTH_SHORT).show();
                }
                else{
                    if (til_password1.getEditText().getText().toString().isEmpty()){
                        Toast.makeText(this,"clave vacia", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        if (String.valueOf(til_password1.getEditText().getText()).equals(String.valueOf(til_password2.getEditText().getText()))){
                            Usuario user2=new Usuario();
                            DetalleExamen examen=new DetalleExamen();
                            DetalleExamen examen2=new DetalleExamen();
                            DetalleExamen examen3=new DetalleExamen();
                            DetalleSeccion seccion=new DetalleSeccion();
                            DetalleSeccion seccion2=new DetalleSeccion();
                            DetalleSeccion seccion3=new DetalleSeccion();
                            Intent intent;
                            user2.setUsuario(String.valueOf(til_usuario.getEditText().getText()));
                            user2.setPassword(String.valueOf(til_password1.getEditText().getText()));
                            user2.setCorreo(String.valueOf(til_correo.getEditText().getText()));
                            user2.setEstado(true);
                            user2.save();
                            user = SQLite.select().from(Usuario.class).where(Usuario_Table.usuario.eq(this.til_usuario.getEditText().getText().toString())).queryList().get(0);
                            examen.setUsuario(user);
                            examen.setFecha(new Date());
                            examen.save();
                            examen2.setUsuario(user);
                            examen2.setFecha(new Date());
                            examen2.save();
                            examen3.setUsuario(user);
                            examen3.setFecha(new Date());
                            examen3.save();
                            seccion.setUsuario(user);
                            seccion2.setUsuario(user);
                            seccion3.setUsuario(user);
                            seccion.save();
                            seccion2.save();
                            seccion3.save();
                            Toast.makeText(this,"usuario guardado", Toast.LENGTH_SHORT).show();
                            intent = new Intent(Registro.this, MainActivity.class);
                            startActivity(intent);

                        }
                        else{
                            Toast.makeText(this,"clave no es similar", Toast.LENGTH_SHORT).show();
                        }

                    }

                }

            }



        //}catch (Exception e){
           // Toast.makeText(this,"error al guardar usuario", Toast.LENGTH_SHORT).show();

        //}

    }

}
