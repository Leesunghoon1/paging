package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.CommentDAO;
import dao.CommentDAOImpl;
import domain.CommentVO;

public class CommentServiceImpl implements CommentService {
	private static final Logger log = LoggerFactory.getLogger(CommentServiceImpl.class);
	private CommentDAO cdao;
	
	public CommentServiceImpl() {
		cdao = new CommentDAOImpl();
	}

	@Override
	public int post(CommentVO cvo) {
		// TODO Auto-generated method stub
		return cdao.insert(cvo);
	}

	@Override
	public List<CommentVO> getList(int bno) {
		return cdao.getList(bno);
	}

	@Override
	public int modify(CommentVO cvo) {
		return cdao.update(cvo);
	}

	@Override
	public int remove(int cno) {
		// TODO Auto-generated method stub
		return cdao.delete(cno);
	}

	@Override
	public int remove2(int bno) {
		// TODO Auto-generated method stub
		return cdao.delete2(bno);
	}
	
	//메서드 구현
}
