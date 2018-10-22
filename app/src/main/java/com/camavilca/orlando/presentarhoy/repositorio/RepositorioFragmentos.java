package com.camavilca.orlando.presentarhoy.repositorio;

import com.camavilca.orlando.presentarhoy.modelo.Nota;
import com.orm.SugarRecord;

import java.util.List;

public class RepositorioFragmentos {

    public static List<Nota> listarFavorito(){
        List<Nota> notas =SugarRecord.listAll(Nota.class);
        return notas;
    }
}
