
package com.mycompany.controllerimpl;

import com.mycompany.modell.Categoria;
import com.mycompamy.configbd.Conexionbd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.dao.CategoriaDAO;

public class CategoriaCtrlImpl implements CategoriaDAO {

    Conexionbd cx;
    String sql;
    ResultSet rs;
    ArrayList<Categoria> listDatos;

    public CategoriaCtrlImpl() {
        cx = new Conexionbd();
    }

    @Override
    public boolean createCategoria(Categoria cat) {
        sql = "INSERT INTO public.categoria(id_categoria, name_cat , estado)"
                + "VALUES("+cat.getId_categoria()+",'"+cat.getName_cat()+"','"+cat.getEstado()+"')";
        return cx.executeInsertUpdate(sql);
    }

    @Override
    public ArrayList<Categoria> readCategoria() {
        listDatos = new ArrayList<>();
        sql = "SELECT * "
                + "    FROM public.categoria "
                + " ORDER BY id_categoria";
        rs = cx.executeQuery(sql);
        try {
            while (rs.next()) {
                listDatos.add(new Categoria(rs.getString("id_categoria"),rs.getString("name_cat"),rs.getString("estado")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaCtrlImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDatos;
    }

    @Override
    public boolean updateCategoria(Categoria cat) {
        sql = "UPDATE public.categoria SET"
                + " name_cat = '"+cat.getName_cat()+"' , estado = '"+cat.getEstado()+"'"
                + " WHERE id_categoria = "+cat.getId_categoria()+" ";
        return cx.executeInsertUpdate(sql);
    }

    @Override
    public boolean deleteCategoria(String id) {       
        sql = "DELETE public.categoria "
                + "WHERE id_categoria = "+id+" ";
        return cx.executeInsertUpdate(sql);
    }

}
