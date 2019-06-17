package com.pdm.sube.cum.seccion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.pdm.sube.cum.DB.models.Estadisticas;
import com.pdm.sube.cum.DB.models.Estadisticas_Table;
import com.pdm.sube.cum.DB.models.Seccion;
import com.pdm.sube.cum.DB.models.Usuario;
import com.pdm.sube.cum.DB.models.Usuario_Table;
import com.pdm.sube.cum.DB.models.Seccion_Table;
import com.pdm.sube.cum.R;
import com.pdm.sube.cum.estadisticas.EstadisticasActivity;
import com.pdm.sube.cum.leccion.menuLeccionActivity;
import com.pdm.sube.cum.seccion.SeccionFragment;
import com.pdm.sube.cum.seccion.SeccionItem;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import java.util.Date;



public class MenuActivity extends AppCompatActivity implements SeccionFragment.OnListFragmentInteractionListener {
    Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        try {
            user = SQLite.select().from(Usuario.class).where(Usuario_Table.id.eq(getIntent().getExtras().getInt("usuario"))).queryList().get(0);
        }catch (Exception e){
            user = null;
        }
    }


    @Override
    public void onListFragmentInteraction(Seccion item) {
        Intent intent;
        intent = new Intent(this,menuLeccionActivity.class);
        intent.putExtra("id", item.getId());
        Toast.makeText(this,"id: "+item.getId(),Toast.LENGTH_SHORT).show();
        startActivity(intent);

    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intent =new Intent(this, EstadisticasActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void obtenerEstadisticas(int id){



        int contar=0;
        Date fecha=new Date();

        Estadisticas estadistica= SQLite.select().from(Estadisticas.class).where(Estadisticas_Table.seccion_id.eq(id)).and(Estadisticas_Table.mes.eq(fecha.getMonth()+1)).querySingle();
        Seccion seccion = SQLite.select().from(Seccion.class).where(Seccion_Table.id.eq(id)).querySingle();

        if(estadistica==null){
            Log.d("prueba","comienzo");

            contar=contar+1;

            Estadisticas estadisticas= new Estadisticas(id,fecha.getMonth()+1,contar,seccion);
            estadisticas.save();







        }
        else{
            contar=estadistica.getNumero_veces();
            contar=contar+1;


            estadistica.setNumero_veces(contar);

            Log.d("prueba","fin");
            estadistica.save();


        }











    }





}
