package com.mycompany.controller;

import com.mycompany.controllerimpl.UsuarioCtrlImpl;
import com.mycompany.dao.UsuarioDAO;
import com.mycompany.modell.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "usuarioCtrl")
@SessionScoped

public class UsuarioCtrl implements Serializable {

    private Usuario selected;
    private boolean est;
    UsuarioDAO usudao;
    private ArrayList<Usuario> list = new ArrayList<>();

    public UsuarioCtrl() {
        this.selected = new Usuario();
        this.usudao = new UsuarioCtrlImpl();
    }

    public void createUsuario() {
        if (usudao.createUsuario(selected)) {
            System.out.println("Insertado");
        } else {
            System.out.println("Error al momento de insertar");
        }
    }

    public ArrayList<Usuario> getList() {
        list = usudao.readUsuario();
        return list;
    }

    public Usuario getSelected() {
        return selected;
    }

    public void setSelected(Usuario selected) {
        this.selected = selected;
    }

}
