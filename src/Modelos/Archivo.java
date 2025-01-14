package Modelos;

import java.util.ArrayList;
import java.util.List;

public class Archivo {
    private List<Registro> listaDeRegistros;


    public Archivo() {
        this.listaDeRegistros = new ArrayList<>();
    }
    public void agragarAlista(Registro registro){
        this.listaDeRegistros.add(registro);
    }


    public List<Registro> getListaDeRegistros() {
        return listaDeRegistros;
    }
}
