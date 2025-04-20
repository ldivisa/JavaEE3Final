/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hopto.depositodivisa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
 
 
    public clientesDao() {
     try {
         this.conexaoFactory = (ConexaoFactory) new ConexaoFactory().getConnection();
     } catch (Exception ex) {
         Logger.getLogger(clientesDao.class.getName()).log(Level.SEVERE, null, ex);
     }
        connection = (Connection) conexaoFactory;
    }

    @Override
    public List<Clientes> getClientes() {
       
    
    }
    
}
