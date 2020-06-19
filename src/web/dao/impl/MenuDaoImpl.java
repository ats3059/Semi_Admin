package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import web.dao.face.MenuDao;
import web.dbutil.JDBCTemplate;
import web.dto.Menu;
import web.util.Paging;

public class MenuDaoImpl implements MenuDao{
	
	private Connection conn = null; //DB연결 객체
	private PreparedStatement ps = null; //SQL수행 객체
	private ResultSet rs = null; //SQL조회 결과 객체

	@Override
	public int selectCntAll() {
		
		conn = JDBCTemplate.getConnection();

		String sql = "";
		sql += "SELECT count(*) FROM menu";
		sql += " WHERE FRAN_NO = ?";
		
		//결과저장할 변수
		int totalCount = 0;
		
		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			
			while(rs.next()) {//조회 결과 처리
				totalCount = rs.getInt(1);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		return totalCount;
	}

	@Override
	public List<Menu> selectCntAll(Paging paging) {
		
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "SELECT * FROM menu";
//		여기 추가해야댐
		
		List<Menu> MenuList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			
			
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Menu menu = new Menu();
				
				menu.setMenuNo(rs.getInt("MENU_NO"));
				menu.setMenuName(rs.getString("MENU_NAME"));
				menu.setMenuInfo(rs.getString("MENU_INFO"));
				menu.setMenuCost(rs.getInt("MENU_COST"));
				menu.setMenuDate(rs.getDate("MENU_DATE"));
				
				
				menu.setFranNo(rs.getInt("FRAN_NO"));
				
				
				
				
				
				MenuList.add(menu);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return MenuList;
	}

}
