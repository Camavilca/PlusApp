package com.camavilca.orlando.presentarhoy.Fragmentos;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import com.camavilca.orlando.presentarhoy.R;
import com.camavilca.orlando.presentarhoy.adaptador.NotaAdaptador;
import com.camavilca.orlando.presentarhoy.modelo.Nota;
import com.camavilca.orlando.presentarhoy.repositorio.RepositorioNota;

import java.util.List;

public class ArchivadosFragment extends Fragment {

    private RecyclerView recyclerView;
    private CheckBox detalle_archivado;
    public ArchivadosFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_archivados, container, false);
        detalle_archivado = (CheckBox)view.findViewById(R.id.detalle_archivado);
        recyclerView = (RecyclerView)view.findViewById(R.id.mostrar_item_archivados);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        List<Nota> archivados = RepositorioNota.listarArchivados();
        if (archivados.isEmpty()){
             Toast.makeText(getContext(),"NO HAY DATOS",Toast.LENGTH_SHORT).show();
        }else{
              recyclerView.setAdapter(new NotaAdaptador(archivados));
        }
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
        List<Nota> notas = RepositorioNota.listarArchivados();
        notaAdaptador.setNotas(notas);
        notaAdaptador.notifyDataSetChanged();
    }
    public void m(){

    }
}
