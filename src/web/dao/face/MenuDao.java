package web.dao.face;

import java.util.List;

import web.dto.Menu;
import web.util.Paging;

public interface MenuDao {

	/**
	 *  게시글 수 조회
	 * @return - 전체 게시글 수
	 */
	public int selectCntAll();

	public List<Menu> selectCntAll(Paging paging);

}
