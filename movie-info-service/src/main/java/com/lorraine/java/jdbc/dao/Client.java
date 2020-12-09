package com.lorraine.java.jdbc.dao;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.lorraine.java.models.Movie;





public class Client {
    private List<Movie> movies;
    Client() {
    	ex01_a();
    	
		
		
	}


	private void ex01_a() {
		DataSource ds = new MySQLDataSource("dbMovies");
		Database db = new Database(ds);
		String data[][]=db.executeQuery("select * from movies");
		print(data);
						
	}
	void print(String data[][]) {
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j]+",");
			}
			System.out.println();
			
		}
		movies = new ArrayList<>();
		for (int i = 1; i < data.length; i++) {
			
			Movie m = new Movie(Integer.parseInt(data[i][0]), data[i][1]);
			movies.add(m);
			
		}

				
	}

	

	public static void main(String[] args) {
		new Client();
		
	}
}
