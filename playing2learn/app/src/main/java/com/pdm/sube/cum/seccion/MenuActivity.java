package com.pdm.sube.cum.seccion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.pdm.sube.cum.DB.models.Seccion;
import com.pdm.sube.cum.DB.models.Usuario;
import com.pdm.sube.cum.DB.models.Usuario_Table;
import com.pdm.sube.cum.R;
import com.pdm.sube.cum.leccion.menuLeccionActivity;
import com.pdm.sube.cum.seccion.SeccionFragment;
import com.pdm.sube.cum.seccion.SeccionItem;
import com.raizlabs.android.dbflow.sql.language.SQLite;


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
}
