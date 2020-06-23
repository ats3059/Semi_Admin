package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import web.dao.face.FranDao;
import web.dbutil.JDBCTemplate;
import web.dto.Fran;
import web.dto.Menu;

public class FranDaoImpl implements FranDao{
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	@Override
	public Map<Fran, Menu> SelectFranMenu() {
		
		conn = JDBCTemplate.getConnection();
		
		String sql = "select f.fran_no,f.fran_name,m.menu_name from fran f , menu m where m.fran_no = f.fran_no\r\n" + 
				"and menu_stat = 'N'";
		Map<Fran,Menu> map = new LinkedHashMap<Fran, Menu>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {	
				Fran fran = new Fran();
				Menu menu = new Menu();
				
				fran.setFranNo(rs.getInt("fran_no"));
				fran.setFranName(rs.getString("fran_name"));
				menu.setMenuName(rs.getString("menu_name"));
				
				map.put(fran,menu);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return map;
	}
	@Override
	public Map<Fran, Menu> SelectFranMember(Fran fran) {

		conn = JDBCTemplate.getConnection();
		
		String sql = "select f.fran_no,f.fran_name,m.menu_name from fran f , menu m where m.fran_no = f.fran_no\r\n" + 
				"and menu_stat = 'N'";
		Map<Fran,Menu> map = new LinkedHashMap<Fran, Menu>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {	
				Fran fra = new Fran();
				Menu menu = new Menu();
				
				fran.setFranNo(rs.getInt("fran_no"));
				fran.setFranName(rs.getString("fran_name"));
				menu.setMenuName(rs.getString("menu_name"));
				
				map.put(fran,menu);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return map;
	}

	
	
}
