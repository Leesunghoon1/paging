<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>My JSP Project</h1>
	<c:if test="${ses.id eq null }">
	<form action="/mem/login" method="post">
		ID : <input type="text" name="id"> PW : <input type="text"
			name="pwd">
	<button type="submit">>로그인</button>
	</form>
	</c:if>
	<br>
	<div>
		<c:if test="${ses.id ne null }">
			<!-- 널이 아니면 ne 맞으면 eq -->
		${ses.id } 로그인 하셨습니다.<br>
		계정 생성일 : ${ses.regdate }<br>
		마지막 접속 : ${ses.lastlogin }<br>
			<a href="/mem/modify"><button>회원정보 수정</button></a>
			<a href="/mem/list"><button>회원정보 리스트</button></a>
			<a href="/board/register.jsp"><button>게시판 글쓰기</button></a>
			<a href="/mem/logout"><button>로그아웃</button></a>
		</c:if>
	</div>
	<br>
	<a href="/mem/join"><button>회원가입</button></a>
	<br>
	<br>
	<a href="/brd/register">게시판 글쓰기로 이동...</a>
	<br>
	<a href="/brd/pageList">게시판 리스트로 이동...</a>


	<!-- 이해불가 -->
	<script type="text/javascript">
		const msg_login = `<c:out value="${msg_login}" />`;
		console.log(msg_login);
		if (msg_login === '0') {
			alert("로그인 정보가 일치하지 않습니다.");
		}
	</script>



</body>
</html>