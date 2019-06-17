package com.pdm.sube.cum.seccion;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.pdm.sube.cum.DB.Constantes;
import com.pdm.sube.cum.DB.models.DetalleSeccion;
import com.pdm.sube.cum.DB.models.DetalleSeccion_Table;
import com.pdm.sube.cum.R;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVWriter;

public class AvanceSeccionActivity extends AppCompatActivity {

    static List<DetalleSeccion> listaAvance;
    static List<String> nombreAvance;
    ListView lstViewAvances;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avance_seccion);
        lstViewAvances = (ListView) findViewById(R.id.listView1);
        nombreAvance = new ArrayList<String>();
        setTitle("Progreso de secciones");
        llenarLista();
    }

    private void llenarLista(){

        String dato;
        try {

            if(SQLite.select().from(DetalleSeccion.class).where(DetalleSeccion_Table.usuario_id.eq(Constantes.ID)).count()!=0){
                listaAvance = SQLite.select().from(DetalleSeccion.class).where(DetalleSeccion_Table.usuario_id.eq(Constantes.ID)).queryList();

                dato = "USUARIO     SECCIÓN     LECCIONES APROBADAS";
                nombreAvance.add(dato);
                for (int i = 0;i < listaAvance.size();i++){
                    dato = listaAvance.get(i).getUsuario().getUsuario() + "     " + listaAvance.get(i).getSeccion().getNombre() +
                            "       " + listaAvance.get(i).getLecciones_aprobadas();
                    nombreAvance.add(dato);
                }

                if (nombreAvance.size() > 0){
                    ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombreAvance);
                    lstViewAvances.setAdapter(adaptador);
                }
            }else{
                Toast.makeText(this,"NO HAY AVANCES PARA EL USUARIO ACTUAL",Toast.LENGTH_SHORT).show();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void exportarExcel(View v){

        try {
            ExportDatabaseCSVTask task=new ExportDatabaseCSVTask();
            task.execute();

        }catch (Exception e){
            Toast.makeText(this,"PROMEBLAS A EXPORTAR",Toast.LENGTH_SHORT).show();
        }

    }

    //CLASE PARA EXPORTAR A EXCEL
    private class ExportDatabaseCSVTask extends AsyncTask<String,String,String> {

        private final ProgressDialog dialog = new ProgressDialog(AvanceSeccionActivity.this);

        @Override
        protected void onPreExecute() {
            this.dialog.setMessage("Exportando datos...");
            this.dialog.show();
        }

        protected String doInBackground(final String... args){
            File exportDir = new File(Environment.getExternalStorageDirectory(), "");
            if (!exportDir.exists()) {
                exportDir.mkdirs();
            }
            File file = new File(exportDir, "ArchivoExcel.csv");
            try {
                file.createNewFile();
                CSVWriter csvWrite = new CSVWriter(new FileWriter(file));

                //HEADERS
                String arrStr1[] ={"USUARIO", "SECCION", "LECCIONES APROBADAS"};
                csvWrite.writeNext(arrStr1);

                //DATOS
                String dato = "";
                for (int i = 0; i < listaAvance.size(); i++) {
                    String arrStr[] ={listaAvance.get(i).getUsuario().getUsuario(), listaAvance.get(i).getSeccion().getNombre(),
                            String.valueOf(listaAvance.get(i).getLecciones_aprobadas())};
                    csvWrite.writeNext(arrStr);
                }
                csvWrite.close();
                return "";
            }
            catch (IOException e){
                Log.e("AvanceSeccionActivity", e.getMessage(), e);
                return "";
            }
        }
        @SuppressLint("NewApi")
        @Override
        protected void onPostExecute(final String success) {
            if (this.dialog.isShowing()){
                this.dialog.dismiss();
            }
            if (success.isEmpty()){
                Toast.makeText(AvanceSeccionActivity.this, "Exportación Exitosa!", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(AvanceSeccionActivity.this, "Exportación Fallo!", Toast.LENGTH_SHORT).show();
            }
        }

    }

}
