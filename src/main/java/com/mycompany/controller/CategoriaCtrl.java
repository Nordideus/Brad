package com.mycompany.controller;

import com.mycompany.controllerimpl.CategoriaCtrlImpl;
import com.mycompany.modell.Categoria;
import com.mycompany.dao.CategoriaDAO;
import java.util.ArrayList;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "categoriaCtrl")
@SessionScoped
public class CategoriaCtrl implements Serializable {

    private Categoria selected;
    private boolean est;
    CategoriaDAO catdao;
    private ArrayList<Categoria> list = new ArrayList<>();

    public CategoriaCtrl() {
        this.selected = new Categoria();
        this.catdao = new CategoriaCtrlImpl();
    }

    public void createCategoria() {
        if (catdao.createCategoria(selected)) {
            System.out.println("Insertado");
        } else {
            System.out.println("Error al momento de insertar");
        }
    }
    
    public ArrayList<Categoria> getList() {
        list = catdao.readCategoria();
        return list;
    }

    public Categoria getSelected() {
        return selected;
    }

    public void setSelected(Categoria selected) {
        this.selected = selected;
    }
    
}
