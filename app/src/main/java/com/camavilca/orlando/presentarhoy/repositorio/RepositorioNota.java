package com.camavilca.orlando.presentarhoy.repositorio;
import com.camavilca.orlando.presentarhoy.modelo.Nota;
import com.orm.SugarApp;
import com.orm.SugarRecord;

import java.util.Date;
import java.util.List;

public class RepositorioNota {


    public static List<Nota> listar(){
        List<Nota> notas = SugarRecord.listAll(Nota.class);
        return notas;
    }
    public static Nota get(Long id){
        List<Nota> notas = SugarRecord.listAll(Nota.class);
        for (Nota nota : notas){
            if (nota.getId().equals(id)){
                return nota;
            }
        }
        return null;
    }
    public static void registrar(String titulo, String descripcion, Date fecha,Boolean favorito, Boolean archivar){
        Nota nota = new Nota(titulo,descripcion,fecha,favorito,archivar);
        SugarRecord.save(nota);
    }
    public static void eliminar(Long id){
        Nota nota = SugarRecord.findById(Nota.class,id);
        SugarRecord.delete(nota);
    }
}