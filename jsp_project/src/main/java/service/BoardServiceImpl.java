package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.BoardDAO;
import dao.BoardDAOImpl;
import domain.BoardVO;
import domain.PagingVO;

public class BoardServiceImpl implements BoardService {
	
	
	   private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	   private BoardDAO bdao; // dao=> interface로 생성
	   
	   public BoardServiceImpl() {
		   bdao = new BoardDAOImpl(); //dao => class로 생성
	   }
	   
	@Override
	public int register(BoardVO bvo) {
		log.info("service register check 2");
		return bdao.insert(bvo);
	}

	@Override
	public List<BoardVO> getList() {
		log.info("list check 2");
		return bdao.selectList();
	}

	@Override
	public BoardVO getDetail(int bno) {
		log.info("detail check 2");
		return bdao.selectdetail(bno);
	}

	@Override
	public int modify(BoardVO bvo) {
		log.info("modify check 2");
		return bdao.update(bvo);
	}

	@Override
	public int remove(int bno) {
		// comment의 댓글 먼저 지우고 본 게시글 삭제
		// CommentServiceImpl scv = new CommentServiceImpl();
		// int isOK = csv.deleteAll(bno);
		// int cnt = scv.commnetCount(bno);
		// if(cnt>0) {
		
		log.info("delete check 2");
		return bdao.remove(bno);
	}



	@Override
	public int getTotalCount(PagingVO pgvo) {
		log.info("getTotalCount check 2");
		return bdao.getTotalCount(pgvo);
	}

	@Override
	public int count(int bno) {
		log.info("getTotalCount check 2");
		return bdao.count(bno);
	}

	@Override
	public List<BoardVO> getPageList(PagingVO pgvo) {
		log.info("getPageList check 2");
		return bdao.getPageList(pgvo);
	}

	@Override
	public String getFileName(int bno) {
		log.info("getFileName check 2");
		return bdao.getFileName(bno);
	}




	

	

}
