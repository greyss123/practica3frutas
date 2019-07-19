package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listaDatos;
    ArrayList<Datos> Lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaDatos = (ListView) findViewById(R.id.lstDatos);
        Lista = new ArrayList<Datos>();
        Lista.add(new Datos(1,"HERMOSOS PELUCHES","Desde 80bs",R.drawable.peluches));
        Lista.add(new Datos(2,"ZAPATOS"," varios colores a 200 BS.",R.drawable.zapatos));
        Lista.add(new Datos(3,"DVD en HD","las mejores peliculas a 5bs.",R.drawable.peliculas));
        Lista.add(new Datos(4,"BLUSAS","diversos modelos desde 50Bs.",R.drawable.moda));
        Lista.add(new Datos(5,"ACCESORIOS TECNOLOGICOS","costo desde 100Bs.",R.drawable.tecnologia));
        Lista.add(new Datos(6,"JUGUETES PARA LOS MAS PEQUEÑOS","desde 100Bs.",R.drawable.juguetes));
        Lista.add(new Datos(7,"MUEBLES","en diferentes diseños desde 1000Bs.",R.drawable.mueble));
        Lista.add(new Datos(8,"ACCESORIOS DE BELLEZA","desde 5Bs.",R.drawable.belleza));



        Adaptador miadaptador = new Adaptador(getApplicationContext(),Lista);
        listaDatos.setAdapter(miadaptador);

        listaDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Datos obj = (Datos) parent.getItemAtPosition(position);
                Intent paso = new Intent(getApplicationContext(),DetalleActivity.class);
                paso.putExtra("objeto",(Serializable)obj);
                startActivity(paso);
            }
        });



    }
}
