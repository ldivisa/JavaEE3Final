/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hopto.depositodivisa.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Loja
 */
public class ConexaoFactory {

	
	private final String usuario = "estudos";
	private final String url  = "jdbc:mysql://depositodivisa2.hopto.org:3306/estudos";
	private final String driver = "com.mysql.jdbc.Driver";
	private final String senha = "Caralho@estudos1";

	public Connection getConnection(){
        try{
            Class.forName(driver);
            return DriverManager.getConnection(url,usuario,senha);
        }catch( SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
            
        }
        
        
        
}