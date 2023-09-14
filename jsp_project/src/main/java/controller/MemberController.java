package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import service.MemberService;
import service.MemberServiceImpl;



/**
 * Servlet implementation class MemberController
 */
@WebServlet("/mem/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
    private RequestDispatcher rdp; //jsp에서 받은 요청을 처리하고, 처리의 결과를 다른 jsp로 보내는 역활
    private String destPage; //목적지 주소 기록
    private int isOK;  //DB의 구문 체크 값 저장
	private MemberService msv; // service 생성
    
    public MemberController() {
    	msv = new MemberServiceImpl(); // msv를 구현할 실제 구현객체(service => class로 생성)
    	
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 모든 처리가 이루어지는 부분
		// 각 객체의 인코딩 설정
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String uri = request.getRequestURI(); //jsp에서 오는 요청 주소
		log.info("서버 들어온지 확인 >>>>>" + uri);
		String path = uri.substring(uri.lastIndexOf("/")+1);
		log.info("주소확인");
		
		switch(path) {
			
		case "join" :
			log.info("회원가입 페이지 열기");
			destPage = "/member/join.jsp";
			break;
		case "register" : // 회원가입한 데이터 저장 
			try {
				//jsp에서 보낸 파라미터 받기
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				String email = request.getParameter("email");
				int age = Integer.parseInt(request.getParameter("age"));
				MemberVO mvo = new MemberVO(id, pwd, email, age);
				log.info("mbvo >>>>" + mvo);
				isOK = msv.register(mvo);
				log.info((isOK>0)? "OK" : "FALS");
				destPage = "/index.jsp";
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		
		break;
		
		case "login" :
			try {
				//파라미터가 DB의 값에 있는지 확인
				//해당 id, pw가 일치하는 데이터를 가져오기
				//가져온 데이터를 세션에 저장
				//session : 모든 jsp페이지에 공유되는 데이터
				//만약에 아이디가 없다면, 메세지를 보내서 alert 창 띄우기
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				MemberVO mvo = new MemberVO(id, pwd);
				//가져온 데이터를 세션에 저장
				//세션 가져오기
				MemberVO loginmvo = msv.login(mvo);
				log.info("login cheak 1 >>>" + loginmvo);
				
				if(loginmvo != null) {
					//연결된 세션이 있다면 기존의 세션 가져오기, 없으면 새로 생성
					//다른 페이지로 이동해도 객체 or 데이터를 가지고 있겟다.
					HttpSession ses = request.getSession();
					ses.setAttribute("ses", loginmvo);
					ses.setMaxInactiveInterval(300); //초단위 유지	
				}else {
					//로그인 객체가 없다면 ...
					request.setAttribute("msg_login", 0);
				}
				destPage="/index.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case "logout" :
			try {
				//연결된 세션이 있다면 해당 세션을 가져오기
				HttpSession ses = request.getSession(); //로그인한 세션
				//lastlogin 시간 기록, id가 필요
				//session에서 id 가져오기
				MemberVO mvo = (MemberVO)ses.getAttribute("ses");
				String id = mvo.getId();
				log.info("ses id>>>>"+id);
				isOK = msv.lastLogin(id);
				ses.invalidate(); //연결 끊는 구문
				log.info("logout >>" +(isOK > 0 ? "ok" : "fail"));
				destPage="/index.jsp";
				} catch (Exception e) {
					e.printStackTrace();
			}
			break;
			
		case "list" :
			try {
				List<MemberVO> list = msv.getList();
				request.setAttribute("list", list);
				destPage = "/member/list.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case "modify" :
			destPage="/member/modify.jsp";

			break;
			
		case "update" :
			try {
				//jsp에서 파라미터 가져와서 mvo 객체 생성
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				String email = request.getParameter("email");
				int age = Integer.parseInt(request.getParameter("age"));
				MemberVO mvo = new MemberVO(id, pwd, email, age);
				isOK = msv.update(mvo);
				log.info("update >>" +(isOK > 0 ? "ok" : "fail"));
				//세션 끊고, index로 이동
				destPage = "logout";
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case "remove" :
			try {
				//세션에 저장된 id만 가져오기
				HttpSession ses = request.getSession(); //현재 로그인한 정보
				//lastlogin 시간 기록, id가 필요
				//session에서 id 가져오기
				MemberVO mvo = (MemberVO)ses.getAttribute("ses"); //(MemberVO) 형변환 해줘야됨
				
				String id = mvo.getId();
				
				log.info("ses remove >>>>>" + id);

				//msv에 id 주고 객체 삭제요청 -> mdao id 주고 삭제요청
				isOK = msv.remove(id);
				ses.invalidate();
				log.info("remove >>" +(isOK > 0 ? "ok" : "fail"));
				//mapper 삭제
				
				//세션 끊고, index로 이동
				destPage="/index.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
		
		rdp = request.getRequestDispatcher(destPage);
		rdp.forward(request, response); //요청에 필요한 객체를 가지고, 경로로 이동.
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		service(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		service(request, response);
	}

}
