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

    public static Connection conexao;
    ConexaoFactory conFactory ;
    PreparedStatement ps;
    ResultSet resultSet;
    List<Clientes> listaClientes;
 
    public clientesDao()  {
        conFactory= new ConexaoFactory();
        listaClientes = new ArrayList<Clientes>();
        conexao = conFactory.getConnection();
         
    }

    @Override
    public List<Clientes> getListaClientes() {
        
            try {
                ps = conexao.prepareStatement("select * from clientes");
                resultSet=ps.executeQuery();
                    while(resultSet.next()){
                        Clientes cliente = new Clientes();
                        cliente.setCodigo(resultSet.getInt("codigo"));
                        cliente.setNome(resultSet.getString("nome"));
                        System.out.println("\n nome:"+resultSet.getString("nome"));
                        listaClientes.add(cliente);
                    }
           
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            finally{
           
                try {
                    resultSet.close();
                    ps.close();
                    conexao.close();
                    conFactory.getConnection().close();
                } catch (Exception ex) {
                     throw new RuntimeException(ex);
                }
            }
                    
                   
           
    
    return listaClientes; 
}
}

