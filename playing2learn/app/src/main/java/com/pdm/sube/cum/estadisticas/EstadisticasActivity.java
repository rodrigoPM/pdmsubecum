package com.pdm.sube.cum.estadisticas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.pdm.sube.cum.DB.models.Estadisticas;
import com.pdm.sube.cum.DB.models.Estadisticas_Table;
import com.pdm.sube.cum.R;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.Date;

public class EstadisticasActivity extends AppCompatActivity {
    BarChart barChart;
    Date fecha=new Date();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas2);
        setTitle("Estadisticas del mes");
        barChart=findViewById(R.id.grafico);



        Estadisticas estadisticas1= SQLite.select().from(Estadisticas.class).where(Estadisticas_Table.seccion_id.eq(1)).and(Estadisticas_Table.usuario_id.eq(getIntent().getExtras().getInt("usuario"))).and(Estadisticas_Table.mes.eq(fecha.getMonth()+1)).querySingle();

        Estadisticas estadisticas2= SQLite.select().from(Estadisticas.class).where(Estadisticas_Table.seccion_id.eq(2)).and(Estadisticas_Table.usuario_id.eq(getIntent().getExtras().getInt("usuario"))).and(Estadisticas_Table.mes.eq(fecha.getMonth()+1)).querySingle();


        Estadisticas estadisticas3= SQLite.select().from(Estadisticas.class).where(Estadisticas_Table.seccion_id.eq(3)).and(Estadisticas_Table.usuario_id.eq(getIntent().getExtras().getInt("usuario"))).and(Estadisticas_Table.mes.eq(fecha.getMonth()+1)).querySingle();

        //try {


            ArrayList<BarEntry> barEntries = new ArrayList<>();

            barEntries.add(new BarEntry(0, Float.parseFloat(String.valueOf(estadisticas1.getNumero_veces()))));

            barEntries.add(new BarEntry(1, Float.parseFloat(String.valueOf(estadisticas2.getNumero_veces()))));

            barEntries.add(new BarEntry(2, Float.parseFloat(String.valueOf(estadisticas3.getNumero_veces()))));

            ArrayList<String> secciones = new ArrayList<>();
            secciones.add("Alfabeto");
            secciones.add("Numeros");
            secciones.add("Mama y Papa");
            BarDataSet barDataSet = new BarDataSet(barEntries, "secciones: Alfabeto,numeros,mama y papa");

            barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);


            BarData theData = new BarData(barDataSet);
            barChart.setData(theData);
            barChart.setTouchEnabled(true);
            barChart.setDragEnabled(true);
            barChart.setScaleEnabled(true);
            Description description =new Description();
            description.setText("secciones mas visitidas por este mes");
            barChart.setDescription(description);
       // }catch (Exception e){

            //e.printStackTrace();


          //  Toast.makeText(this,"no hay datos disponibles",Toast.LENGTH_SHORT).show();



        //}



    }
}
