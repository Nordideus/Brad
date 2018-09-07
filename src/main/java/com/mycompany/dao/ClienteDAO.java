
package com.mycompany.dao;

import com.mycompany.modell.Cliente;
import java.util.ArrayList;

public interface ClienteDAO {
    public boolean createCliente(Cliente cli);
    public ArrayList<Cliente> readCliente();
    public boolean updateCliente(Cliente cli);
    public boolean deleteteCliente(String id_cliente_direccion);
}
