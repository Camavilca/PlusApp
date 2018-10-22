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
import com.camavilca.orlando.presentarhoy.repositorio.RepositorioFragmentos;
import com.camavilca.orlando.presentarhoy.repositorio.RepositorioNota;

import java.util.List;

public class FavoritosFragment extends Fragment {

    private RecyclerView recyclerView;
    private CheckBox detalle_favorito;
    private CheckBox detalle_archivado;
    public FavoritosFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favoritos, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.mostrar_item_favoritos);
        detalle_archivado = (CheckBox)view.findViewById(R.id.detalle_archivado);
        detalle_favorito = (CheckBox)view.findViewById(R.id.detalle_favorito);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        List<Nota> notas = RepositorioFragmentos.listarFavorito();
        for (Nota nota: notas) {
            if (nota.getFavorito().equals(true)){
                if (nota.getArchivar().equals(false)){
                    recyclerView.setAdapter(new NotaAdaptador(notas));
                }
            }else{
                Toast.makeText(getContext(),"NO HAY DATOS",Toast.LENGTH_SHORT).show();
            }
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
        List<Nota> notas = RepositorioFragmentos.listarFavorito();
        notaAdaptador.setNotas(notas);
        notaAdaptador.notifyDataSetChanged();
    }
}
