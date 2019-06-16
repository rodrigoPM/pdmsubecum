package com.pdm.sube.cum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.pdm.sube.cum.DB.models.DetalleMenu;
import com.pdm.sube.cum.DB.models.Examen;
import com.pdm.sube.cum.DB.models.Leccion;
import com.pdm.sube.cum.DB.models.Menu;
import com.pdm.sube.cum.DB.models.Seccion;
import com.pdm.sube.cum.DB.models.Usuario;
import com.pdm.sube.cum.seccion.MenuActivity;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLogin;
    EditText edt_usuario, edt_password;
    TextView txt_crear_cuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        this.edt_usuario = findViewById(R.id.edt_usuario);
        this.edt_password = findViewById(R.id.edt_password);
        this.txt_crear_cuenta = findViewById(R.id.txt_crear_cuenta);

        this.btnLogin = findViewById(R.id.login_btn_login);
        this.btnLogin.setOnClickListener(this);
        this.txt_crear_cuenta.setOnClickListener(this);

        quemarDatos();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_btn_login:
                Toast.makeText(this,"Click a login", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MenuActivity.class));

                break;
            case R.id.txt_crear_cuenta:
                startActivity(new Intent(this, Registro.class));
                break;
        }
    }

    public void quemarDatos(){
        Usuario usuario1 = new Usuario(1,"admin","admin", "admin@admin.com",true);
        usuario1.save();

        Menu menu1 = new Menu(1,3);
        menu1.save();

        DetalleMenu detalleMenu = new DetalleMenu(1,0,0,usuario1,menu1);
        detalleMenu.save();

        Seccion seccion1 = new Seccion(1,"Alfabeto",R.drawable.alfabeto1,1,1,true,menu1);
        seccion1.save();
        Seccion seccion2 = new Seccion(2,"Numeros",R.drawable.numeros_general,2,2,false,menu1);
        seccion2.save();
        Seccion seccion3 = new Seccion(3,"Mama y Papa",R.drawable.mama_papa,3,3,false,menu1);
        seccion3.save();

        Leccion leccion1 = new Leccion(1,"Vocales", R.drawable.vocales,1,true,seccion1);
        leccion1.save();
        Leccion leccion2 = new Leccion(2,"Abecedario", R.drawable.abecedario,2,true,seccion1);
        leccion2.save();
        Examen examen1 = new Examen(1,"Examen del Alfabeto",0,new Date(),R.drawable.examen,usuario1,seccion1);
        examen1.save();


    }
}
