package com.spring_legacy.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class Jdbc_oracle_test {

		static {
	        //드라이버 검색 (db와 연동 준비)
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("드라이버 검색 성공");
			} catch (ClassNotFoundException e) {
				System.err.println("드라이버 검색 실패");
				System.exit(0);
			}
		}
			@Test
			public void testConnection() {
				//데이터베이스 연결 - 커넥션 만들기 
				Connection conn = null;
				try {
					conn = DriverManager.getConnection(
							"jdbc:oracle:thin:@localhost:1521:xe"
							,"spring_legacy", "spring_legacy"
							);
					System.out.println("데이터베이스 연결 성공");
				} catch (SQLException e) {
					System.err.println("데이터베이스 연결 실패");
					System.exit(0);
				}
				try {
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
}
