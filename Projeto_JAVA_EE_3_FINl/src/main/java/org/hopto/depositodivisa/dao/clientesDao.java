/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hopto.depositodivisa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hopto.depositodivisa.factory.ConexaoFactory;
import org.hopto.depositodivisa.interfaces.clientesInterface;
import org.hopto.depositodivisa.model.Clientes;

/**
 *
 * @author Loja
 */
public class clientesDao implements clientesInterface{

    Connection connection;
    ConexaoFactory conexaoFactory;
    PreparedStatement ps;
    ResultSet resultSet;
    List<Clientes> listaClientes;
 
    public clientesDao() {
        listaClientes = new ArrayList<Clientes>();
     try {
         this.connection = new ConexaoFactory().getConnection();
     } catch (Exception ex) {
         Logger.getLogger(clientesDao.class.getName()).log(Level.SEVERE, null, ex);
     }
        
    }

    @Override
    public List<Clientes> getListaClientes() {
        try {
            try {
                ps =connection.prepareStatement("select * from clientes");
                resultSet=ps.executeQuery();
                while(resultSet.next()){
                    Clientes cliente = new Clientes();
                    cliente.setCodigo(resultSet.getInt("codigo"));
                    cliente.setNome(resultSet.getString("nome"));
                    listaClientes.add(cliente);
                }
            } catch (SQLException ex) {
                Logger.getLogger(clientesDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            resultSet.close();
            ps.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(clientesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
                return listaClientes;
    }
    
}
