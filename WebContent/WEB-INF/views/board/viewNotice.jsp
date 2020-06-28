<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- <link rel="stylesheet" type="text/css" href="/resources/css/board/board.css"> -->

<%-- <c:import url="/WEB-INF/views/layout/header.jsp"></c:import> --%>

<c:import url="/WEB-INF/views/web_layout/header2.jsp" />
<c:import url="/WEB-INF/views/web_layout/body_nav.jsp" />

<script type="text/javascript">
// $(document).ready(function() {
// 	//검색 버틀 클릭
// 	$("#btnSearch").click(function() {
// 		location.href="/m/view/notice?search="+$("#search").val();
// 	});
	
// });
</script>
<section class="wrapper">
<div class="board">
	<!-- 공지사항 Title -->
<!-- 	<div class="board_top" style="float: right;"> -->
<!-- <!--  		<h3 style="display: inline; margin-right: 660px;" >공지사항</h3> --> 
<!-- <!-- 		<input type="text" id="search" /><button class="button" id="btnSearch">검색</button> -->
<!-- 		<button class="btn btn-primary btn-lg" onclick="location.href='/add/posts'">글쓰기</button> -->
<!-- 	</div> -->
	
	<!-- 공지사항 목록 -->
	<table class="table table-bordered" style="text-align: center">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>조회수</th>
			<th>작성일자</th>
		</tr>
		
		<c:forEach var="item" items="${boardList}">
			<tr>
				<td width="15%"><c:out value="${item.bdNo}" /></td>
				<td width="55%"><a href="/m/detail/notice?bdNo=${item.bdNo }"><c:out value="${item.bdTitle}" /></a></td>
				<td width="15%"><c:out value="${item.bdCnt}" /></td>
				<td width="15%"><c:out value="${item.bdDate}" /></td>
			</tr>
		</c:forEach>
	</table>
	<button class="btn btn-primary btn-lg" onclick="location.href='/m/add/notice'" style="float: right;">글쓰기</button>
</div>
</section>
<c:import url="/WEB-INF/views/board/paging_notice.jsp" />
<c:import url="/WEB-INF/views/web_layout/footer.jsp" />