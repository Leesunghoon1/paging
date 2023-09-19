<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<h1>Board List Page</h1>
<!-- 검색 구역 -->
   <!-- 검색 구역 -->
   <div>
       <form action="/brd/pageList" method="get">
          <div>
          <c:set value="${ph.pgvo.type }" var="typed"></c:set>
             <select name="type">
                <option ${typed == null? 'selected':''}>Choose..</option>
                <option value="t"  ${typed eq 't'? 'selected':''}>title</option>
                <option value="w" ${typed eq 'w'? 'selected':''}>writer</option>
                <option value="c" ${typed eq 'c'? 'selected':''}>content</option>
                <option value="tw" ${typed eq 'tw'? 'selected':''}>title + writer</option>
                <option value="tc" ${typed eq 'tc'? 'selected':''}>title + content</option>
                <option value="wc" ${typed eq 'wc'? 'selected':''}>writer + content</option>
                <option value="twc" ${typed eq 'twc'? 'selected':''}>title + content + writer</option>
             </select>
             <input type="text" name="keyword" value="${ph.pgvo.keyword }" placeholder="Search..">
             <input type="hidden" name="pageNo" value="${ph.pgvo.pageNo }">
             <input type="hidden" name="qty" value="${ph.pgvo.qty }">
             ${ph.totalCount }
             <button type="submit">Search</button>
          </div>
          
       </form>
   </div>
<table>
<tr>

	<th>BNO</th>
	<th>TITLE</th>
	<th>WRWITER</th>
	<th>REG_DATE</th>
</tr>
<!--  DB의 전체 리스트를 반복 c:foreach -->

<c:forEach items="${list }" var="bvo">
<tr>
	<td><a href="/brd/detail?bno=${bvo.bno }">${bvo.bno }</a></td>
	<td><a href="/brd/detail?bno=${bvo.bno }">${bvo.title }</a></td>
	<td><a>${bvo.writer }</a></td>
	<td><a>${bvo.regdate }</a></td>
</tr>
</c:forEach>
</table>
<!-- 페이지네이션 표시 구역 -->
   <div>
      <!-- prev -->
      <c:if test="${ph.prev }">
         <a href="/brd/pageList?pageNo=${ph.startPage-1 }&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}"> ◁ | </a>
      </c:if>
      
      <c:forEach begin="${ph.startPage }" end="${ph.endPage }" var="i"> 
          <a href="/brd/pageList?pageNo=${i }&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}">${i } </a>
      </c:forEach>
      
      <!-- next -->
      <c:if test="${ph.next }">
         <a href="/brd/pageList?pageNo=${ph.endPage+1 }&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}"> | ▷ </a>
      </c:if>
      
   </div>
   
   <a href="/index.jsp">Index</a>
   <a href="/brd/register">Register</a>
</body>
</html>