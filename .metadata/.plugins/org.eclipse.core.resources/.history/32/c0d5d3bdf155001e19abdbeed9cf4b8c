package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.CommentDAO;
import dao.CommentDAOImpl;
import domain.CommentVO;

public class CommentServiceImlp implements CommentService {
	private static final Logger log = LoggerFactory.getLogger(CommentServiceImlp.class);
	private CommentDAO cdao;
	
	public CommentServiceImlp() {
		cdao = new CommentDAOImpl();
	}

	@Override
	public int post(CommentVO cvo) {
		// TODO Auto-generated method stub
		return cdao.insert(cvo);
	}
	
	
	//메서드 구현
}
