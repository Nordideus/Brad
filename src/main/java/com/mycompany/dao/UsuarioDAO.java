
package com.mycompany.dao;

import com.mycompany.modell.Usuario;
import java.util.ArrayList;

public interface UsuarioDAO {
    public boolean createUsuario(Usuario usu);
    public ArrayList<Usuario> readUsuario();
    public boolean updateUsuario(Usuario usu);
    public boolean deleteUsuario(String id_usuario);
}
