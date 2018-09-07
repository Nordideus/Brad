
package com.mycompany.dao;

import com.mycompany.modell.Categoria;
import java.util.ArrayList;

public interface CategoriaDAO {
    public boolean createCategoria(Categoria cat);
    public ArrayList<Categoria> readCategoria();
    public boolean updateCategoria(Categoria cat);
    public boolean deleteCategoria(String id);
}
