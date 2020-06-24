package web.service.impl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import web.dao.face.FranDao;
import web.dao.impl.FranDaoImpl;
import web.dto.Fran;
import web.dto.Menu;
import web.service.face.FranMenuService;
import web.util.Paging;

public class FranMenuServiceImpl implements FranMenuService{
private FranDao franDao = new FranDaoImpl();

	@Override
	public Map<Fran, Menu> FranMenuSelect() {
	
		
		return franDao.SelectFranMenu();
	}

	@Override
	public Map<Fran, Menu> FranMemberSelect(HttpServletRequest req) {
		Fran fran = new Fran();
		fran.setFranName(req.getParameter("search"));
		
		return franDao.SelectFranMember(fran);
	}

	//--------------------------------------------------------------------
	
	@Override
	public Paging getPagingReport(HttpServletRequest req) {
	
		//전달파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		System.out.println(curPage);
		//검색어
		String search = (String)req.getParameter("search");
		//Board 테이블의 총 게시글 수를 조회한다
		int totalCount = franDao.selectCntFran();

		//Paging 객체 생성 - 현재 페이지(curPage), 총 게시글 수(totalCount) 활용
		Paging paging = new Paging(totalCount, curPage);
		paging.setSearch(search);
		
		System.out.println(paging);
		//Paging 객체 반환
		return paging;
	}

	@Override
	public Map<Fran, String> viewFran(Paging paging) {
		return franDao.selectFran(paging);
	}

}
