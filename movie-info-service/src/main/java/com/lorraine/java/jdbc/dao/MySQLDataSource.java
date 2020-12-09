package com.lorraine.java.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLDataSource extends DataSource{
	private static final String MYSQL_DRIVER="com.mysql.jdbc.Driver";
	private static final String MYSQL_BRIDGE="jdbc:mysql:";
	public MySQLDataSource(String host,String source , String userName, String password) {
		super(MYSQL_DRIVER,MYSQL_BRIDGE+"//"+host+"/"+source,userName,password);
		//Mysqldriver==>driver
		//Mysqlbridge +host+ source ==>url
	}

	public MySQLDataSource(String source , String userName, String password) {
		super(MYSQL_DRIVER,MYSQL_BRIDGE+"//localhost/"+source,userName,password);
	}
	
	public MySQLDataSource(String source , String userName) {
		super(MYSQL_DRIVER,MYSQL_BRIDGE+"//localhost/"+source,userName,"");
	}
	public MySQLDataSource(String source ) {
		super(MYSQL_DRIVER,MYSQL_BRIDGE+"//localhost/"+source,"root","");
	}
	public Connection getConnection() {
		try {
			//1.Chargement de Driver
			Class.forName(MYSQL_DRIVER);
			//2.Construire l'url de connexion :
			//String url=MYSQL_BRIDGE+"//"+host+"/"+source;
			//3.Connexion au serveur de BD
			Connection db=DriverManager.getConnection(getUrl(), getUserName(), getPassword());
			System.out.println(">>Connexion Bien etablie ...");
			return db;
		}catch (Exception e) {
			System.out.println("Erreur de Connexion :"+e.getMessage());
			return null;
		}
	}

}
