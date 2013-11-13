package com.spring.data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.spring.data.model.Circle;



public class JDBCDaoImpl {

	public Circle getCircle(int circleId) {

		Connection con = null;
		String driver = "oracle.jdbc.driver.OracleDriver";
		Circle circle = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con =DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "practice",
					"practice");
			System.out.println("Connection Acquired");
			ps = con.prepareStatement("select * from circle where id= ?");
			ps.setInt(1, circleId);

			rs = ps.executeQuery();
			if (rs.next())
				circle = new Circle(circleId, rs.getString("name"));

		} catch (ClassNotFoundException e) {
			
			System.out.println(e);
		} catch (SQLException e) {
			
			System.out.println(e);
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				
				System.out.println(e);
			}

		}

		return circle;

	}

}
