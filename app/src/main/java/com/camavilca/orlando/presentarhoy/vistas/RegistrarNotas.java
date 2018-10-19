package com.camavilca.orlando.presentarhoy.vistas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.camavilca.orlando.presentarhoy.R;
import com.camavilca.orlando.presentarhoy.repositorio.RepositorioNota;

import java.util.Calendar;

public class RegistrarNotas extends AppCompatActivity {
    EditText titulo;
    EditText descrip;
    Calendar c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_notas);
        titulo = (EditText)findViewById(R.id.registrar_notas_titulo);
        descrip = (EditText)findViewById(R.id.registrar_notas_descripcion);
    }

    public void botonesNotas(View view) {
        switch (view.getId()){
            case R.id.btn_registrar_nota:
                registrarNotas();
                break;
            case R.id.btn_atras_vista:
                llamarVistaAnterior();
                break;
        }
    }
    private void llamarVistaAnterior() {
        Intent intent = new Intent(this, VistaPrincipalNotas.class);
        startActivity(intent);
    }
    private void registrarNotas() {
        String t = titulo.getText().toString();
        String d = descrip.getText().toString();
        c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY,0);
        c.set(Calendar.SECOND, 0);
        if (t.isEmpty() || d.isEmpty()){
            Toast.makeText(getApplicationContext(),"LOS CAMPOS SON REQUERIDOS",Toast.LENGTH_LONG).show();
            return;
        }else{
            RepositorioNota.registrar(t,d,c.getTime(),false,false);
        }
        finish();
    }
}
