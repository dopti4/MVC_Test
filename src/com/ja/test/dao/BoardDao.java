package com.ja.test.dao;

import java.util.ArrayList;

import com.ja.test.vo.BoardVO;
import java.sql.*;

public class BoardDao {
	
	public ArrayList<BoardVO> getBoardList(){
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		
		
		///////
		try {
			String sql = "SELECT * FROM FB_Board ORDER BY FB_Board.b_no DESC";
			
			
			//복붙!
			System.out.println("실행될 쿼리 : " + sql);
			
			//
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";	
			String dbUser = "SCOTT";
			String dbPW = "TIGER";
			
			Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPW);
			Statement stm = conn.createStatement();	//실행 API //여기까진 똑같다!
			
			//
			ResultSet rs = stm.executeQuery(sql);
			
			
			
			//로직 처리~
			while(rs.next()){
				BoardVO vo = new BoardVO(
						rs.getString("b_no"),
						rs.getString("m_no"),
						rs.getString("b_title"),
						rs.getString("b_content"),
						rs.getString("b_writedate")
						);
			}
			
			//
			rs.close();
			stm.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return list;
	}
}
