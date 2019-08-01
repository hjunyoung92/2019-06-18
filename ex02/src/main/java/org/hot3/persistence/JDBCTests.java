package org.hot3.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		} // end try

	}

	@Test
	public void testConnection() {

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://192.168.41.51:3306/echo?useSSL=false&serverTimezone=Asia/Seoul", "echo", "echo");

			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}

	}
}
