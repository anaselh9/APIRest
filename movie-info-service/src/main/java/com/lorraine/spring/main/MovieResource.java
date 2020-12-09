package com.lorraine.spring.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lorraine.java.jdbc.dao.DataSource;
import com.lorraine.java.jdbc.dao.Database;
import com.lorraine.java.jdbc.dao.MySQLDataSource;
import com.lorraine.java.models.Movie;

@RestController
@RequestMapping("/movies")
public class MovieResource {
	private List<Movie> movies;
	void db() {
		System.out.println("db");
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
	@RequestMapping("/{movieId}")
	public List<Movie> getCatalog(@PathVariable("movieId")int userId)
	{
		db();
		return movies;
	}
}
