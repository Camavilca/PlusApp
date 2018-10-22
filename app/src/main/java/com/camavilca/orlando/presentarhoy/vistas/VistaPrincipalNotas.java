package com.camavilca.orlando.presentarhoy.vistas;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.camavilca.orlando.presentarhoy.Fragmentos.ArchivadosFragment;
import com.camavilca.orlando.presentarhoy.Fragmentos.FavoritosFragment;
import com.camavilca.orlando.presentarhoy.Fragmentos.HomeFragment;
import com.camavilca.orlando.presentarhoy.R;
import com.camavilca.orlando.presentarhoy.adaptador.NotaAdaptador;
import com.camavilca.orlando.presentarhoy.modelo.Nota;
import com.camavilca.orlando.presentarhoy.repositorio.RepositorioNota;
import com.camavilca.orlando.presentarhoy.repositorio.RepositorioUsuario;

import java.util.List;

public class VistaPrincipalNotas extends AppCompatActivity {

    private static final String TAG = VistaPrincipalNotas.class.getSimpleName();
    private static final int REGISTER_FORM_REQUEST = 100;
    private RecyclerView recyclerView;
    TextView nombre_del_usuario;
    private CheckBox detalle_favorito;
    private CheckBox detalle_archivado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_principal_notas);
        /*
        * Se esta agregando esto manito para el favorito y archivado
        * */
        detalle_favorito = (CheckBox)findViewById(R.id.detalle_favorito);
        detalle_archivado = (CheckBox)findViewById(R.id.detalle_archivado);

        /**
         * FIN DE LO DE AGREGADO
         * */


        nombre_del_usuario = (TextView)findViewById(R.id.nombre_del_usuario);
        /*recyclerView = (RecyclerView)findViewById(R.id.mostrar_notas_agregadas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Nota> notas = RepositorioNota.listar();
        recyclerView.setAdapter(new NotaAdaptador(notas));*/

        FragmentManager fragmentManager  = getSupportFragmentManager();
        Fragment fragment  = new HomeFragment();
        fragmentManager.beginTransaction().replace(R.id.vista_principal_notas,fragment).addToBackStack("tag").commit();
        String nombre = RepositorioUsuario.nombre;
        nombre_del_usuario.setText("Bienvenido: "+ nombre.toUpperCase());
        BottomNavigationView b = (BottomNavigationView)findViewById(R.id.bootom_navigation);
        b.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                switch (item.getItemId()){
                    case R.id.menu_home:
                        //Toast.makeText(getApplicationContext(),"HOME",Toast.LENGTH_SHORT).show();
                        Fragment fragment2  =new HomeFragment();
                        fragmentManager.beginTransaction().replace(R.id.vista_principal_notas,fragment2).addToBackStack("tag").commit();
                        break;
                    case R.id.menu_favorito:
                        Fragment fragment = new FavoritosFragment();
                        fragmentManager.beginTransaction().replace(R.id.vista_principal_notas,fragment).addToBackStack("tag").commit();
                        break;
                    case R.id.menu_archivados:
                        Fragment fragment1 = new ArchivadosFragment();
                        fragmentManager.beginTransaction().replace(R.id.vista_principal_notas,fragment1).addToBackStack("tag").commit();
                        break;
                }
                return true;
            }
        });

    }

    public void agregarNotas(View view) {
        startActivityForResult(new Intent(this,RegistrarNotas.class),REGISTER_FORM_REQUEST);
    }


}
