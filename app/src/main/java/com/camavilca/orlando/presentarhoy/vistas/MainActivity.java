package com.camavilca.orlando.presentarhoy.vistas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.camavilca.orlando.presentarhoy.R;
import com.camavilca.orlando.presentarhoy.repositorio.RepositorioUsuario;

public class MainActivity extends AppCompatActivity {
    EditText usuario;
    EditText contraseña;
    Button iniciar;
    Button registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario  =(EditText)findViewById(R.id.txt_usuario);
        contraseña  = (EditText)findViewById(R.id.txt_contraseña);
        iniciar  = (Button) findViewById(R.id.btn_iniciar_sesion);
        registrar  = (Button) findViewById(R.id.btn_iniciar_sesion);

    }

    public void onclick(View view) {
        switch (view.getId()){
            case R.id.btn_iniciar_sesion:
                iniciarSesion();
                break;
            case R.id.btn_registrar_usuario:
                llamarRegistro();
                break;
        }
    }
    private void iniciarSesion() {
        String usu = usuario.getText().toString();
        String cont = contraseña.getText().toString();

        if(RepositorioUsuario.inicioSesion(usu,cont)){
            llamarAgregarNotas();
        }else{
            Toast.makeText(this,"LOS DATOS NO COINCIDEN",Toast.LENGTH_LONG).show();
        }
    }

    private void llamarAgregarNotas() {
        Intent intent1 = new Intent(this, VistaPrincipalNotas.class);
        startActivity(intent1);
    }

    private void llamarRegistro() {
        Intent intent = new Intent(this, Registrar.class);
        startActivity(intent);
    }
}
