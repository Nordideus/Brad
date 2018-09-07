
package com.mycompany.modell;

public class Categoria {
    String id_categoria, name_cat, estado;

    public Categoria(String id_categoria, String name_cat, String estado) {
        this.id_categoria = id_categoria;
        this.name_cat = name_cat;
        this.estado = estado;
    }

    public Categoria() {
    }

    public String getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(String id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getName_cat() {
        return name_cat;
    }

    public void setName_cat(String name_cat) {
        this.name_cat = name_cat;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
