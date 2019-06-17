package com.pdm.sube.cum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.pdm.sube.cum.DB.ApplicationDB;
import com.pdm.sube.cum.DB.MyDB;
import com.pdm.sube.cum.DB.models.DetalleExamen;
import com.pdm.sube.cum.DB.models.DetalleSeccion;
import com.pdm.sube.cum.DB.models.EjercicioExamen;
import com.pdm.sube.cum.DB.models.Estadisticas;
import com.pdm.sube.cum.DB.models.Examen;
import com.pdm.sube.cum.DB.models.Leccion;
import com.pdm.sube.cum.DB.models.Seccion;
import com.pdm.sube.cum.DB.models.Usuario;
import com.pdm.sube.cum.DB.models.Ejercicio;
import com.pdm.sube.cum.DB.models.Usuario_Table;
import com.pdm.sube.cum.seccion.MenuActivity;
//import com.raizlabs.android.dbflow.config.MyDBMyDB_Database;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLogin;
    EditText edt_usuario, edt_password;
    TextView txt_crear_cuenta;

    Usuario user;


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
        Intent intent;
        Usuario user = null;
        switch (v.getId()) {
            case R.id.login_btn_login:
                try {
                    user = SQLite.select().from(Usuario.class).where(Usuario_Table.usuario.eq(this.edt_usuario.getText().toString())).queryList().get(0);
                }catch (Exception e){
                    user = null;
                }
                if(user != null){
                    if(user.getPassword().equals(this.edt_password.getText().toString())){
                        intent = new Intent(MainActivity.this, MenuActivity.class);
                        intent.putExtra("usuario",user.getId());
                        startActivity(intent);
                    }else{
                        Toast.makeText(this, "Password incorrecto" , Toast.LENGTH_SHORT).show();
                    }
                }else{
                   Toast.makeText(this, "El Usuario no existe", Toast.LENGTH_SHORT).show();
               }

                break;
            case R.id.txt_crear_cuenta:
                startActivity(new Intent(this, Registro.class));
                break;
        }
    }

    public void quemarDatos(){

        if(SQLite.select().from(Seccion.class).count() == 0 ){
            Usuario usuario1 = new Usuario(1,"admin","admin", "admin@admin.com",true);
            usuario1.save();


            /////////  Secciones
            Seccion seccion1 = new Seccion(1,"Alfabeto","alfabeto1",1,1,2);
            seccion1.save();
            Seccion seccion2 = new Seccion(2,"Numeros","numeros_general",2,2,2);
            seccion2.save();
            Seccion seccion3 = new Seccion(3,"Mama y Papa","mama_papa",3,3,2);
            seccion3.save();

            //////// lecciones
            Leccion leccion1 = new Leccion(1,"Vocales", "vocales",1,true,seccion1);
            leccion1.save();
            Leccion leccion2 = new Leccion(2,"Abecedario", "abecedario",2,true,seccion1);
            leccion2.save();

            Leccion leccion3 = new Leccion(3,"0-9", "numeros_0_10",1,true,seccion2);
            leccion3.save();
            Leccion leccion4 = new Leccion(4,"decenas", "numero_10_decena",2,true,seccion2);
            leccion4.save();

            Leccion leccion5 = new Leccion(5,"mama", "mama",1,true,seccion3);
            leccion5.save();
            Leccion leccion6 = new Leccion(6,"papa", "papa",2,true,seccion3);
            leccion6.save();


            /////// ejercicios vocales
            Ejercicio ejercicio1 = new Ejercicio(1,"letra_a","letra_a","a",leccion1);
            ejercicio1.save();
            Ejercicio ejercicio2 = new Ejercicio(2,"letra_e","letra_e","e",leccion1);
            ejercicio2.save();
            Ejercicio ejercicio3 = new Ejercicio(3,"letra_i","letra_i","i",leccion1);
            ejercicio3.save();
            Ejercicio ejercicio4 = new Ejercicio(4,"letra_o","letra_o","o",leccion1);
            ejercicio4.save();
            Ejercicio ejercicio5 = new Ejercicio(5,"letra_u","letra_u","u",leccion1);
            ejercicio5.save();

            ////// ejercicios abecedario
            Ejercicio ejercicio6 = new Ejercicio(6,"letra_a","letra_a","a",leccion2);
            ejercicio6.save();
            Ejercicio ejercicio7 = new Ejercicio(7,"letra_b","letra_b","b",leccion2);
            ejercicio7.save();
            Ejercicio ejercicio8 = new Ejercicio(8,"letra_c","letra_c","c",leccion2);
            ejercicio8.save();
            Ejercicio ejercicio9 = new Ejercicio(9,"letra_d","letra_d","d",leccion2);
            ejercicio9.save();
            Ejercicio ejercicio10 = new Ejercicio(10,"letra_e","letra_e","e",leccion2);
            ejercicio10.save();
            Ejercicio ejercicio11 = new Ejercicio(11,"letra_f","letra_f","f",leccion2);
            ejercicio11.save();
            Ejercicio ejercicio12 = new Ejercicio(12,"letra_g","letra_g","g",leccion2);
            ejercicio12.save();
            Ejercicio ejercicio13 = new Ejercicio(13,"letra_h","letra_h","h",leccion2);
            ejercicio13.save();
            Ejercicio ejercicio14 = new Ejercicio(14,"letra_i","letra_i","i",leccion2);
            ejercicio14.save();
            Ejercicio ejercicio15 = new Ejercicio(15,"letra_j","letra_j","j",leccion2);
            ejercicio15.save();
            Ejercicio ejercicio16 = new Ejercicio(16,"letra_k","letra_k","k",leccion2);
            ejercicio16.save();
            Ejercicio ejercicio17 = new Ejercicio(17,"letra_l","letra_l","l",leccion2);
            ejercicio17.save();
            Ejercicio ejercicio18 = new Ejercicio(18,"letra_m","letra_m","m",leccion2);
            ejercicio18.save();
            Ejercicio ejercicio19 = new Ejercicio(19,"letra_n","letra_n","n",leccion2);
            ejercicio19.save();
            Ejercicio ejercicio20 = new Ejercicio(20,"letra_nn","letra_nn","ñ",leccion2);
            ejercicio20.save();
            Ejercicio ejercicio21 = new Ejercicio(21,"letra_o","letra_o","o",leccion2);
            ejercicio21.save();
            Ejercicio ejercicio22 = new Ejercicio(22,"letra_p","letra_p","p",leccion2);
            ejercicio22.save();
            Ejercicio ejercicio23 = new Ejercicio(23,"letra_q","letra_q","q",leccion2);
            ejercicio23.save();
            Ejercicio ejercicio24 = new Ejercicio(24,"letra_r","letra_r","r",leccion2);
            ejercicio24.save();
            Ejercicio ejercicio25 = new Ejercicio(25,"letra_s","letra_s","s",leccion2);
            ejercicio25.save();
            Ejercicio ejercicio26 = new Ejercicio(26,"letra_t","letra_t","t",leccion2);
            ejercicio26.save();
            Ejercicio ejercicio27 = new Ejercicio(27,"letra_u","letra_u","u",leccion2);
            ejercicio27.save();
            Ejercicio ejercicio28 = new Ejercicio(28,"letra_v","letra_v","v",leccion2);
            ejercicio28.save();
            Ejercicio ejercicio29 = new Ejercicio(29,"letra_w","letra_w","w",leccion2);
            ejercicio29.save();
            Ejercicio ejercicio30 = new Ejercicio(30,"letra_x","letra_x","x",leccion2);
            ejercicio30.save();
            Ejercicio ejercicio31 = new Ejercicio(31,"letra_y","letra_y","y",leccion2);
            ejercicio31.save();
            Ejercicio ejercicio32 = new Ejercicio(32,"letra_z","letra_z","z",leccion2);
            ejercicio32.save();

            Examen examen1 = new Examen(1,"Examen Seccion 1","examen",seccion1);
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
            Ejercicio ejercicio33 = new Ejercicio(33, "numero_0","numero_0","0",leccion3);
            ejercicio33.save();
            Ejercicio ejercicio34 = new Ejercicio(34, "numero_1","numero_1","1",leccion3);
            ejercicio34.save();
            Ejercicio ejercicio35 = new Ejercicio(35, "numero_2","numero_2","2",leccion3);
            ejercicio35.save();
            Ejercicio ejercicio36 = new Ejercicio(36, "numero_3","numero_3","3",leccion3);
            ejercicio36.save();
            Ejercicio ejercicio37 = new Ejercicio(37, "numero_4","numero_4","4",leccion3);
            ejercicio37.save();
            Ejercicio ejercicio38 = new Ejercicio(38, "numero_5","numero_5","5",leccion3);
            ejercicio38.save();
            Ejercicio ejercicio39 = new Ejercicio(39, "numero_6","numero_6","6",leccion3);
            ejercicio39.save();
            Ejercicio ejercicio40 = new Ejercicio(40, "numero_7","numero_7","7",leccion3);
            ejercicio40.save();
            Ejercicio ejercicio41 = new Ejercicio(41, "numero_8","numero_8","8",leccion3);
            ejercicio41.save();
            Ejercicio ejercicio42 = new Ejercicio(42, "numero_9","numero_9","9",leccion3);
            ejercicio42.save();

            //ejercicio decenas
            Ejercicio ejercicio43 = new Ejercicio(43, "numero_10_decena","numero_10","10",leccion4);
            ejercicio43.save();
            Ejercicio ejercicio44 = new Ejercicio(44, "numero_20","numero_20","20",leccion4);
            ejercicio44.save();
            Ejercicio ejercicio45 = new Ejercicio(45, "numero_30","numero_30","30",leccion4);
            ejercicio45.save();
            Ejercicio ejercicio46 = new Ejercicio(46, "numero_40","numero_40","40",leccion4);
            ejercicio46.save();
            Ejercicio ejercicio47 = new Ejercicio(47, "numero_50","numero_50","50",leccion4);
            ejercicio47.save();
            Ejercicio ejercicio48 = new Ejercicio(48, "numero_60","numero_60","60",leccion4);
            ejercicio48.save();
            Ejercicio ejercicio49 = new Ejercicio(49, "numero_70","numero_70","70",leccion4);
            ejercicio49.save();
            Ejercicio ejercicio50 = new Ejercicio(50, "numero_80","numero_80","80",leccion4);
            ejercicio50.save();
            Ejercicio ejercicio51 = new Ejercicio(51, "numero_90","numero_90","90",leccion4);
            ejercicio51.save();
            Ejercicio ejercicio52 = new Ejercicio(52, "numero_100","numero_100","100",leccion4);
            ejercicio52.save();

            Examen examen2 = new Examen(2,"Examen Seccion 2","examen",seccion2);
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
            Ejercicio ejercicio53 = new Ejercicio(53, "mama","mama","mi mamá me mima",leccion5);
            ejercicio53.save();
            Ejercicio ejercicio54 = new Ejercicio(54, "mama","mama2","amo a mi mamá",leccion5);
            ejercicio54.save();
            Ejercicio ejercicio55 = new Ejercicio(55, "mama","mama3","memo ama a su mamá",leccion5);
            ejercicio55.save();

            //papa
            Ejercicio ejercicio56 = new Ejercicio(56, "papa","papa","papá me ama",leccion6);
            ejercicio56.save();
            Ejercicio ejercicio57 = new Ejercicio(57, "papa","papa2","pepe ama a papá",leccion6);
            ejercicio57.save();
            Ejercicio ejercicio58 = new Ejercicio(58, "papa","papa3","mi papá es bueno",leccion6);
            ejercicio58.save();

            Examen examen3 = new Examen(3,"Examen Seccion 3","examen",seccion3);
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




            //estadisticas
            Date fecha= new Date();

            Estadisticas estadisticas1=new Estadisticas(1,fecha.getMonth()+1,0,seccion1,user);
            estadisticas1.save();

            Estadisticas estadisticas2=new Estadisticas(2,fecha.getMonth()+1,0,seccion2,user);
            estadisticas2.save();
            Estadisticas estadisticas3=new Estadisticas(3,fecha.getMonth()+1,0,seccion3,user);
            estadisticas3.save();



        }else{
        Toast.makeText(this,"Base de datos llena", Toast.LENGTH_SHORT).show();
        }
    }
}
