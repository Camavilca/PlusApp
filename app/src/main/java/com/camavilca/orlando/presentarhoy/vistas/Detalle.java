package com.camavilca.orlando.presentarhoy.vistas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.camavilca.orlando.presentarhoy.R;
import com.camavilca.orlando.presentarhoy.modelo.Nota;
import com.camavilca.orlando.presentarhoy.repositorio.RepositorioNota;

public class Detalle extends AppCompatActivity {
    private static final String TAG = Detalle.class.getSimpleName();
    private Long id;


    private TextView detalle_titulo;
    private TextView detalle_contenido;
    private CheckBox detalle_favorito;
    private CheckBox detalle_archivado;
    private TextView detalle_fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        detalle_titulo = (TextView)findViewById(R.id.detalle_titulo);
        detalle_contenido = (TextView)findViewById(R.id.detalle_contenido);
        detalle_favorito = (CheckBox)findViewById(R.id.detalle_favorito);
        detalle_archivado = (CheckBox)findViewById(R.id.detalle_archivado);
        detalle_fecha = (TextView) findViewById(R.id.detalle_fecha);

        id = getIntent().getExtras().getLong("ID");
        Log.e(TAG,"ID: "+id);

        Nota nota = RepositorioNota.get(id);

        detalle_titulo.setText("Titulo: "+nota.getTitulo());
        detalle_contenido.setText("Descripcion: "+nota.getDescripcion());
        detalle_fecha.setText("Fecha: "+nota.getFecha());

        if (nota.getFavorito()){
            detalle_favorito.setVisibility(View.VISIBLE);
        }else{
            detalle_favorito.setVisibility(View.GONE);
        }
        if(nota.getArchivar()){
            detalle_archivado.setVisibility(View.VISIBLE);
        }else{
            detalle_archivado.setVisibility(View.GONE);
        }

    }
    public boolean onSupportNavigationUp(){
        finish();
        return true;
    }
}
