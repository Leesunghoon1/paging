package dao;

import java.util.List;

import domain.BoardVO;
import domain.PagingVO;

public interface BoardDAO {

	int insert(BoardVO bvo);

	List<BoardVO> selectList();

	BoardVO selectdetail(int bno);

	int update(BoardVO bvo);


	int remove(int bno);

	int getTotalCount(PagingVO pgvo);

	int count(int bno);

	List<BoardVO> getPageList(PagingVO pgvo);

	String getFileName(int bno);
	
}
