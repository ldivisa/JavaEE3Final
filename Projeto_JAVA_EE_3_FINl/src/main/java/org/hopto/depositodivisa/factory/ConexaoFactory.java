/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hopto.depositodivisa.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Loja
 */
public class ConexaoFactory {

	private volatile static ConexaoFactory instance = new ConexaoFactory();
	private final String usuario = "estudos";
	private final String url  = "jdbc:mysql://depositodivisa2.hopto.org:3306/estudos";
	private final String driver = "com.mysql.jdbc.Driver";
	private final String senha = "Q2FyYWxob0Blc3R1ZG9zMQ==";

	public ConexaoFactory(){
	}

	public static ConexaoFactory getInstance(){

		synchronized(ConexaoFactory.class){
			if(instance == null){
				instance = new ConexaoFactory();
			}
			return instance;
		}
	}

	public Connection getConnection() throws SQLException,Exception{

	try {
	    Class.forName(driver);
            return DriverManager.getConnection(url,usuario,senha);
        } catch (ClassNotFoundException e) {           
            
            return null;
        }
	}

	public void closeConnection(Connection com) throws SQLException{
		com.close();
	}


    
}
