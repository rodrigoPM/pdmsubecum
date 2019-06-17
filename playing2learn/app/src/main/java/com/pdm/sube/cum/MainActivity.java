package com.pdm.sube.cum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.pdm.sube.cum.DB.models.DetalleExamen;
import com.pdm.sube.cum.DB.models.DetalleSeccion;
import com.pdm.sube.cum.DB.models.EjercicioExamen;
import com.pdm.sube.cum.DB.models.Examen;
import com.pdm.sube.cum.DB.models.Leccion;
import com.pdm.sube.cum.DB.models.Seccion;
import com.pdm.sube.cum.DB.models.Usuario;
import com.pdm.sube.cum.DB.models.Ejercicio;
import com.pdm.sube.cum.seccion.MenuActivity;
import com.raizlabs.android.dbflow.sql.language.SQLite;

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

        //if(SQLite.select().from(Seccion.class).count() == 0 ){
            Usuario usuario1 = new Usuario(1,"admin","admin", "admin@admin.com",true);
            usuario1.save();


            /////////  Secciones
            Seccion seccion1 = new Seccion(1,"Alfabeto",R.drawable.alfabeto1,1,1,2);
            seccion1.save();
            Seccion seccion2 = new Seccion(2,"Numeros",R.drawable.numeros_general,2,2,2);
            seccion2.save();
            Seccion seccion3 = new Seccion(3,"Mama y Papa",R.drawable.mama_papa,3,3,2);
            seccion3.save();

            //////// lecciones
            Leccion leccion1 = new Leccion(1,"Vocales", R.drawable.vocales,1,true,seccion1);
            leccion1.save();
            Leccion leccion2 = new Leccion(2,"Abecedario", R.drawable.abecedario,2,true,seccion1);
            leccion2.save();

            Leccion leccion3 = new Leccion(3,"0-9", R.drawable.numeros_0_10,1,true,seccion2);
            leccion3.save();
            Leccion leccion4 = new Leccion(4,"decenas", R.drawable.numero_10_decena,2,true,seccion2);
            leccion4.save();

            Leccion leccion5 = new Leccion(5,"mama", R.drawable.mama,1,true,seccion3);
            leccion5.save();
            Leccion leccion6 = new Leccion(6,"papa", R.drawable.papa,2,true,seccion3);
            leccion6.save();


            /////// ejercicios vocales
            Ejercicio ejercicio1 = new Ejercicio(1,R.drawable.letra_a,R.raw.letra_a,"a",leccion1);
            ejercicio1.save();
            Ejercicio ejercicio2 = new Ejercicio(2,R.drawable.letra_e,R.raw.letra_e,"e",leccion1);
            ejercicio2.save();
            Ejercicio ejercicio3 = new Ejercicio(3,R.drawable.letra_i,R.raw.letra_i,"i",leccion1);
            ejercicio3.save();
            Ejercicio ejercicio4 = new Ejercicio(4,R.drawable.letra_o,R.raw.letra_o,"o",leccion1);
            ejercicio4.save();
            Ejercicio ejercicio5 = new Ejercicio(5,R.drawable.letra_u,R.raw.letra_u,"u",leccion1);
            ejercicio5.save();

            ////// ejercicios abecedario
            Ejercicio ejercicio6 = new Ejercicio(6,R.drawable.letra_a,R.raw.letra_a,"a",leccion2);
            ejercicio6.save();
            Ejercicio ejercicio7 = new Ejercicio(7,R.drawable.letra_b,R.raw.letra_b,"b",leccion2);
            ejercicio7.save();
            Ejercicio ejercicio8 = new Ejercicio(8,R.drawable.letra_c,R.raw.letra_c,"c",leccion2);
            ejercicio8.save();
            Ejercicio ejercicio9 = new Ejercicio(9,R.drawable.letra_d,R.raw.letra_d,"d",leccion2);
            ejercicio9.save();
            Ejercicio ejercicio10 = new Ejercicio(10,R.drawable.letra_e,R.raw.letra_e,"e",leccion2);
            ejercicio10.save();
            Ejercicio ejercicio11 = new Ejercicio(11,R.drawable.letra_f,R.raw.letra_f,"f",leccion2);
            ejercicio11.save();
            Ejercicio ejercicio12 = new Ejercicio(12,R.drawable.letra_g,R.raw.letra_g,"g",leccion2);
            ejercicio12.save();
            Ejercicio ejercicio13 = new Ejercicio(13,R.drawable.letra_h,R.raw.letra_h,"h",leccion2);
            ejercicio13.save();
            Ejercicio ejercicio14 = new Ejercicio(14,R.drawable.letra_i,R.raw.letra_i,"i",leccion2);
            ejercicio14.save();
            Ejercicio ejercicio15 = new Ejercicio(15,R.drawable.letra_j,R.raw.letra_j,"j",leccion2);
            ejercicio15.save();
            Ejercicio ejercicio16 = new Ejercicio(16,R.drawable.letra_k,R.raw.letra_k,"k",leccion2);
            ejercicio16.save();
            Ejercicio ejercicio17 = new Ejercicio(17,R.drawable.letra_l,R.raw.letra_l,"l",leccion2);
            ejercicio17.save();
            Ejercicio ejercicio18 = new Ejercicio(18,R.drawable.letra_m,R.raw.letra_m,"m",leccion2);
            ejercicio18.save();
            Ejercicio ejercicio19 = new Ejercicio(19,R.drawable.letra_n,R.raw.letra_n,"n",leccion2);
            ejercicio19.save();
            Ejercicio ejercicio20 = new Ejercicio(20,R.drawable.letra_nn,R.raw.letra_nn,"ñ",leccion2);
            ejercicio20.save();
            Ejercicio ejercicio21 = new Ejercicio(21,R.drawable.letra_o,R.raw.letra_o,"o",leccion2);
            ejercicio21.save();
            Ejercicio ejercicio22 = new Ejercicio(22,R.drawable.letra_p,R.raw.letra_p,"p",leccion2);
            ejercicio22.save();
            Ejercicio ejercicio23 = new Ejercicio(23,R.drawable.letra_q,R.raw.letra_q,"q",leccion2);
            ejercicio23.save();
            Ejercicio ejercicio24 = new Ejercicio(24,R.drawable.letra_r,R.raw.letra_r,"r",leccion2);
            ejercicio24.save();
            Ejercicio ejercicio25 = new Ejercicio(25,R.drawable.letra_s,R.raw.letra_s,"s",leccion2);
            ejercicio25.save();
            Ejercicio ejercicio26 = new Ejercicio(26,R.drawable.letra_t,R.raw.letra_t,"t",leccion2);
            ejercicio26.save();
            Ejercicio ejercicio27 = new Ejercicio(27,R.drawable.letra_u,R.raw.letra_u,"u",leccion2);
            ejercicio27.save();
            Ejercicio ejercicio28 = new Ejercicio(28,R.drawable.letra_v,R.raw.letra_v,"v",leccion2);
            ejercicio28.save();
            Ejercicio ejercicio29 = new Ejercicio(29,R.drawable.letra_w,R.raw.letra_w,"w",leccion2);
            ejercicio29.save();
            Ejercicio ejercicio30 = new Ejercicio(30,R.drawable.letra_x,R.raw.letra_x,"x",leccion2);
            ejercicio30.save();
            Ejercicio ejercicio31 = new Ejercicio(31,R.drawable.letra_y,R.raw.letra_y,"y",leccion2);
            ejercicio31.save();
            Ejercicio ejercicio32 = new Ejercicio(32,R.drawable.letra_z,R.raw.letra_z,"z",leccion2);
            ejercicio32.save();

            Examen examen1 = new Examen(1,"Examen Seccion 1",R.drawable.examen,seccion1);
            examen1.save();

            DetalleSeccion detalleSeccion1 = new DetalleSeccion(1,true,0,false,usuario1,seccion1);
            detalleSeccion1.save();

            DetalleExamen detalleExamen1 = new DetalleExamen(1,new Date(),0,usuario1,examen1);
            detalleExamen1.save();


            EjercicioExamen ejercicioExamen1 = new EjercicioExamen(1,false,examen1,ejercicio4);
            ejercicioExamen1.save();
            EjercicioExamen ejercicioExamen2 = new EjercicioExamen(2,false,examen1,ejercicio15);
            ejercicioExamen2.save();
            EjercicioExamen ejercicioExamen3 = new EjercicioExamen(3,false,examen1,ejercicio26);
            ejercicioExamen3.save();


            //ejercicio numeros 0-9
            Ejercicio ejercicio33 = new Ejercicio(33, R.drawable.numero_0,R.raw.numero_0,"0",leccion3);
            ejercicio33.save();
            Ejercicio ejercicio34 = new Ejercicio(34, R.drawable.numero_1,R.raw.numero_1,"1",leccion3);
            ejercicio34.save();
            Ejercicio ejercicio35 = new Ejercicio(35, R.drawable.numero_2,R.raw.numero_2,"2",leccion3);
            ejercicio35.save();
            Ejercicio ejercicio36 = new Ejercicio(36, R.drawable.numero_3,R.raw.numero_3,"3",leccion3);
            ejercicio36.save();
            Ejercicio ejercicio37 = new Ejercicio(37, R.drawable.numero_4,R.raw.numero_4,"4",leccion3);
            ejercicio37.save();
            Ejercicio ejercicio38 = new Ejercicio(38, R.drawable.numero_5,R.raw.numero_5,"5",leccion3);
            ejercicio38.save();
            Ejercicio ejercicio39 = new Ejercicio(39, R.drawable.numero_6,R.raw.numero_6,"6",leccion3);
            ejercicio39.save();
            Ejercicio ejercicio40 = new Ejercicio(40, R.drawable.numero_7,R.raw.numero_7,"7",leccion3);
            ejercicio40.save();
            Ejercicio ejercicio41 = new Ejercicio(41, R.drawable.numero_8,R.raw.numero_8,"8",leccion3);
            ejercicio41.save();
            Ejercicio ejercicio42 = new Ejercicio(42, R.drawable.numero_9,R.raw.numero_9,"9",leccion3);
            ejercicio42.save();

            //ejercicio decenas
            Ejercicio ejercicio43 = new Ejercicio(43, R.drawable.numero_10_decena,R.raw.numero_10,"10",leccion4);
            ejercicio43.save();
            Ejercicio ejercicio44 = new Ejercicio(44, R.drawable.numero_20,R.raw.numero_20,"20",leccion4);
            ejercicio44.save();
            Ejercicio ejercicio45 = new Ejercicio(45, R.drawable.numero_30,R.raw.numero_30,"30",leccion4);
            ejercicio45.save();
            Ejercicio ejercicio46 = new Ejercicio(46, R.drawable.numero_40,R.raw.numero_40,"40",leccion4);
            ejercicio46.save();
            Ejercicio ejercicio47 = new Ejercicio(47, R.drawable.numero_50,R.raw.numero_50,"50",leccion4);
            ejercicio47.save();
            Ejercicio ejercicio48 = new Ejercicio(48, R.drawable.numero_60,R.raw.numero_60,"60",leccion4);
            ejercicio48.save();
            Ejercicio ejercicio49 = new Ejercicio(49, R.drawable.numero_70,R.raw.numero_70,"70",leccion4);
            ejercicio49.save();
            Ejercicio ejercicio50 = new Ejercicio(50, R.drawable.numero_80,R.raw.numero_80,"80",leccion4);
            ejercicio50.save();
            Ejercicio ejercicio51 = new Ejercicio(51, R.drawable.numero_90,R.raw.numero_90,"90",leccion4);
            ejercicio51.save();
            Ejercicio ejercicio52 = new Ejercicio(52, R.drawable.numero_100,R.raw.numero_100,"100",leccion4);
            ejercicio52.save();

            Examen examen2 = new Examen(2,"Examen Seccion 2",R.drawable.examen,seccion2);
            examen2.save();

            DetalleSeccion detalleSeccion2 = new DetalleSeccion(2,true,0,false,usuario1,seccion2);
            detalleSeccion2.save();

            DetalleExamen detalleExamen2 = new DetalleExamen(2,new Date(),0,usuario1,examen2);
            detalleExamen2.save();


            EjercicioExamen ejercicioExamen4 = new EjercicioExamen(4,false,examen2,ejercicio37);
            ejercicioExamen4.save();
            EjercicioExamen ejercicioExamen5 = new EjercicioExamen(5,false,examen2,ejercicio42);
            ejercicioExamen5.save();
            EjercicioExamen ejercicioExamen6 = new EjercicioExamen(6,false,examen2,ejercicio48);
            ejercicioExamen6.save();


            //ejercicio de la seccion 3
            //mama
            Ejercicio ejercicio53 = new Ejercicio(53, R.drawable.mama,R.raw.mama,"mi mamá me mima",leccion5);
            ejercicio53.save();
            Ejercicio ejercicio54 = new Ejercicio(54, R.drawable.mama,R.raw.mama2,"amo a mi mamá",leccion5);
            ejercicio54.save();
            Ejercicio ejercicio55 = new Ejercicio(55, R.drawable.mama,R.raw.mama3,"memo ama a su mamá",leccion5);
            ejercicio55.save();

            //papa
            Ejercicio ejercicio56 = new Ejercicio(56, R.drawable.papa,R.raw.papa,"papá me ama",leccion6);
            ejercicio56.save();
            Ejercicio ejercicio57 = new Ejercicio(57, R.drawable.papa,R.raw.papa2,"pepe ama a papá",leccion6);
            ejercicio57.save();
            Ejercicio ejercicio58 = new Ejercicio(58, R.drawable.papa,R.raw.papa3,"mi papá es bueno",leccion6);
            ejercicio58.save();

            Examen examen3 = new Examen(3,"Examen Seccion 3",R.drawable.examen,seccion3);
            examen3.save();

            DetalleSeccion detalleSeccion3 = new DetalleSeccion(3,true,0,false,usuario1,seccion3);
            detalleSeccion3.save();

            DetalleExamen detalleExamen3 = new DetalleExamen(3,new Date(),0,usuario1,examen3);
            detalleExamen3.save();


            EjercicioExamen ejercicioExamen7 = new EjercicioExamen(7,false,examen3,ejercicio54);
            ejercicioExamen7.save();
            EjercicioExamen ejercicioExamen8 = new EjercicioExamen(8,false,examen3,ejercicio55);
            ejercicioExamen8.save();
            EjercicioExamen ejercicioExamen9 = new EjercicioExamen(9,false,examen3,ejercicio57);
            ejercicioExamen9.save();


        //}else{
       // Toast.makeText(this,"Base de datos llena", Toast.LENGTH_SHORT).show();
        //}
    }
}
