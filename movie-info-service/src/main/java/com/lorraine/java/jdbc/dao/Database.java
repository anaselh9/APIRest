package com.lorraine.java.jdbc.dao;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	private DataSource  dataSource;
	private Connection db;
	public Database(){
		
	}
	public Database(DataSource datasource) {
		this.dataSource=datasource;
		db=dataSource.getConnection();
		
	}
	
	 public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		db=dataSource.getConnection();
		
	}


	public String[][] select(String tablename){
		String request = "SELECT * FROM "+ tablename;
		return executeQuery(request);
	}
	
	public String[][] executeQuery(String query){
		try {
			Statement sql = db.createStatement();
			ResultSet rs=  sql.executeQuery(query);
			ResultSetMetaData rsm=rs.getMetaData();//recupuper les meta donee
			int columnCount =rsm.getColumnCount();
			rs.last();
			int rowCount= rs.getRow();//coonait le numero de la ligne courant
			String data[][]= new String[rowCount+1][columnCount];
			for (int i = 0; i < columnCount; i++) {
				data[0][i]=rsm.getColumnName(i+1);	
			}
			rs.beforeFirst();
			int row=0;
			while (rs.next()) {
				row++;
				for (int i = 0; i <columnCount; i++) {
					data[row][i]=rs.getString(i+1);
					
				}
			}
			return data;
		} catch (Exception e) {
			System.out.println("Erreur :"+e.getMessage());
			return null;
		}
	}
	
	
		
	
	
}
