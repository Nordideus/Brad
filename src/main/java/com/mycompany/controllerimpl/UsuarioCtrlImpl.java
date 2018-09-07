
package com.mycompany.controllerimpl;

import com.mycompany.modell.Usuario;
import com.mycompamy.configbd.Conexionbd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.dao.UsuarioDAO;

public class UsuarioCtrlImpl implements UsuarioDAO{
    Conexionbd cx;
    String sql;
    ResultSet rs;
    ArrayList<Usuario> listDatos;
    
    public UsuarioCtrlImpl() {
        cx = new Conexionbd();
}

    @Override
    public boolean createUsuario(Usuario usu) {
        sql = "INSERT INTO public.usuario(id_usuario, id_persona, campo1, campo2, estado)"
                + "VALUES(" + usu.getId_usuario() + ",'" + usu.getId_persona() + "','" + usu.getCampo1() + "','" + usu.getCampo2() + "','" + usu.getEstado() +"' )";
        return cx.executeInsertUpdate(sql);
    }

    @Override
    public ArrayList<Usuario> readUsuario() {
        
        listDatos = new ArrayList<>();
        sql = "SELECT * "
                + "    FROM public.usuario";
        rs = cx.executeQuery(sql);
        try {
            while (rs.next()) {
                listDatos.add(new Usuario(rs.getString("id_usuario"), rs.getString("id_persona"), rs.getString("campo1"), rs.getString("campo2"), rs.getString("estado")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioCtrlImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDatos;
    }

    @Override
    public boolean updateUsuario(Usuario usu) {
        
        sql = "UPDATE public.usuario SET"
                + " id_usuario = '" + usu.getId_usuario()+ "' , id_persona = '" + usu.getId_persona() + "' , campo1 = '" + usu.getCampo1() + "' , campo2 = '" + usu.getCampo2() + "' "
                + " WHERE id_usuario = " + usu.getId_usuario() + " ";
        return cx.executeInsertUpdate(sql);
    }

    @Override
    public boolean deleteUsuario(String id_usuario) {
        sql = "DELETE public.usuario "
                + "WHERE id_usuario = " + id_usuario + " ";
        return cx.executeInsertUpdate(sql);
    }
}
