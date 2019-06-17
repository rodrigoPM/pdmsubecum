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
import com.pdm.sube.cum.DB.models.Estadisticas;
import com.pdm.sube.cum.DB.models.Examen;
import com.pdm.sube.cum.DB.models.Examen_Table;
import com.pdm.sube.cum.DB.models.Seccion;
import com.pdm.sube.cum.DB.models.Seccion_Table;
import com.pdm.sube.cum.DB.models.Usuario;
import com.pdm.sube.cum.DB.models.Usuario_Table;
import com.pdm.sube.cum.seccion.MenuActivity;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.sql.SQLInput;
import java.util.Date;

import butterknife.BindView;

public class Registro extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.til_usuario)
    TextInputLayout til_usuario;
    @BindView(R.id.til_password1)
    TextInputLayout til_password1;
    @BindView(R.id.til_password2)
    TextInputLayout til_password2;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.til_correo)
    TextInputLayout til_correo;

    public static String user_email ;
    public static String pass_email ;





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
                            user_email=til_correo.getEditText().getText().toString();
                            pass_email=til_correo.getEditText().getText().toString();
                            user2.setEstado(true);
                            user2.save();
                            user = SQLite.select().from(Usuario.class).where(Usuario_Table.usuario.eq(this.til_usuario.getEditText().getText().toString())).queryList().get(0);
                            examen.setUsuario(user);
                            examen.setFecha(new Date());
                            examen.setNota(0);
                            examen.setExamen(SQLite.select().from(Examen.class).where(Examen_Table.id.eq(1)).querySingle());
                            examen.save();
                            examen2.setUsuario(user);
                            examen2.setFecha(new Date());
                            examen2.setNota(0);
                            examen2.setExamen(SQLite.select().from(Examen.class).where(Examen_Table.id.eq(2)).querySingle());
                            examen2.save();
                            examen3.setUsuario(user);
                            examen3.setFecha(new Date());
                            examen3.setNota(0);
                            examen3.setExamen(SQLite.select().from(Examen.class).where(Examen_Table.id.eq(3)).querySingle());
                            examen3.save();
                            seccion.setUsuario(user);
                            seccion.setSeccion(SQLite.select().from(Seccion.class).where(Seccion_Table.id.eq(1)).querySingle());
                            seccion2.setUsuario(user);
                            seccion2.setSeccion(SQLite.select().from(Seccion.class).where(Seccion_Table.id.eq(2)).querySingle());
                            seccion3.setUsuario(user);
                            seccion3.setSeccion(SQLite.select().from(Seccion.class).where(Seccion_Table.id.eq(3)).querySingle());
                            seccion.save();
                            seccion2.save();
                            seccion3.save();



                            Seccion seccion1 = new Seccion(1, "Alfabeto", "alfabeto1", 1, 1, 2);
                            seccion1.save();
                            Seccion seccion_2 = new Seccion(2, "Numeros", "numeros_general", 2, 2, 2);
                            seccion2.save();
                            Seccion seccion_3 = new Seccion(3, "Mama y Papa", "mama_papa", 3, 3, 2);
                            seccion3.save();







                            Date fecha = new Date();


                            Estadisticas estadisticas1 = new Estadisticas(1, fecha.getMonth() + 1, 0, seccion1, user2);
                            estadisticas1.save();

                            Estadisticas estadisticas2 = new Estadisticas(2, fecha.getMonth() + 1, 0, seccion_2, user2);
                            estadisticas2.save();
                            Estadisticas estadisticas3 = new Estadisticas(3, fecha.getMonth() + 1, 0, seccion_3, user2);
                            estadisticas3.save();



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
