package com.camavilca.orlando.presentarhoy.Fragmentos;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.camavilca.orlando.presentarhoy.R;
import com.camavilca.orlando.presentarhoy.adaptador.NotaAdaptador;
import com.camavilca.orlando.presentarhoy.modelo.Nota;
import com.camavilca.orlando.presentarhoy.repositorio.RepositorioNota;
import com.camavilca.orlando.presentarhoy.vistas.Registrar;
import com.camavilca.orlando.presentarhoy.vistas.RegistrarNotas;
import com.camavilca.orlando.presentarhoy.vistas.VistaPrincipalNotas;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private static final String TAG = HomeFragment.class.getSimpleName();
    private static final int REGISTER_FORM_REQUEST = 100;
    private RecyclerView recyclerView;


    TextView nombre_del_usuario;
    private CheckBox detalle_favorito;
    private CheckBox detalle_archivado;
    FloatingActionButton agregarNotas;
    public HomeFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.mostrar_notas_agregadas);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        List<Nota> notas = RepositorioNota.listar();
        recyclerView.setAdapter(new NotaAdaptador(notas));

        agregarNotas = view.findViewById(R.id.float_btn_agregar);
        agregarNotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(this, Registrar.class)
                startActivityForResult(new Intent(getContext(),RegistrarNotas.class),REGISTER_FORM_REQUEST);
            }
        });
        return view;
    }
    public void onButtonPressed(Uri uri) {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        NotaAdaptador notaAdaptador = (NotaAdaptador)recyclerView.getAdapter();
        List<Nota> notas = RepositorioNota.listar();
        notaAdaptador.setNotas(notas);
        notaAdaptador.notifyDataSetChanged();
    }

}
