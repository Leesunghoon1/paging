package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.MemberDAO;
import dao.MemberDAOImpl;
import domain.MemberVO;

public class MemberServiceImpl implements MemberService {
	private static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
	private MemberDAO mdao; 
	
	public MemberServiceImpl(){
		mdao = new MemberDAOImpl();
	}

	@Override
	public int register(MemberVO mvo) {
		log.info("join check 2");
		return mdao.insert(mvo);
	}

	@Override
	public MemberVO login(MemberVO mvo) {
		log.info("login check 2");
		return mdao.login(mvo);
	}

	@Override
	public int lastLogin(String id) {
		log.info("logout check 2");
		return mdao.logout(id);
	}

	@Override
	public List<MemberVO> getList() {
		log.info("list check 2");
		return mdao.getList();
	}

	@Override
	public int update(MemberVO mvo) {
		log.info("update check 2");
		return mdao.update(mvo);
	}

	@Override
	public int remove(String id) {
		log.info("update check 2");
		return mdao.remove(id);
	}

}
