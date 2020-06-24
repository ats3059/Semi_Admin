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
import web.dto.Report;
import web.dto.User;
import web.util.Paging;

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
	//--------------------------------------------------------------------

	@Override
	public int selectCntFran() {
		conn = JDBCTemplate.getConnection(); //DB연결
		
		//SQL 작성
		String sql = "";
		sql += "SELECT count(*) FROM fran";
		
		//최종 결과값
		int cnt = 0;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			rs = ps.executeQuery(); //SQL수행 및 결과집합 반환
			
			//조회결과 처리
			while( rs.next() ) {
				cnt = rs.getInt(1);
				System.out.println("이거되냐");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("개수"+cnt);
		return cnt;
	}
	@Override
	public Map<Fran, String> selectFran(Paging paging) {
		//DB연결 객체
		conn = JDBCTemplate.getConnection();
		
		//SQL 작성
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "    SELECT rownum rnum, C.* FROM ("; 
		sql += "	SELECT F.*, D.food_name FROM fran F JOIN food D on F.food_no=D.food_no";
		sql += "		WHERE fran_name LIKE '%'||?||'%'"; 
		sql += "    ) C";
		sql += "    ORDER BY rnum";
		sql += " ) BOARD";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		//결과 저장할 List
		Map<Fran, String> franList = new LinkedHashMap<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setString(1, paging.getSearch());
			ps.setInt(2, paging.getStartNo());	//페이징 게시글 시작 번호
			ps.setInt(3, paging.getEndNo());	//페이징 게시글 끝 번호
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
//			System.out.println(rs.next());
			//조회 결과 처리
			while(rs.next()) {
//				System.out.println(rs.getInt("bd_no"));
				System.out.println("몇번");
				Fran fran = new Fran();
				//결과값 한 행 처리
				fran.setFranNo(rs.getInt("fran_no"));
				fran.setFranName(rs.getString("fran_name"));
				
				//리스트에 결과값 저장
				franList.put(fran,rs.getString("food_name"));
			}
			System.out.println("뭐야");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		//최종 결과 반환
		System.out.println("이래야지"+franList);
		return franList;
	}

	
}
