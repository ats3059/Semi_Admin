<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<c:import url="/WEB-INF/views/fran_layout/header.jsp" />

<c:import url="/WEB-INF/views/fran_layout/header_menu.jsp" />

<div class="body-content-list">
<table class="table table-striped table-hover table-condensed" >
<thead>
<tr>
	<th>번호</th>
	<th>메뉴명</th>
	<th>뭐야?</th>
	<th>가격</th>
	<th>등록일자</th>
	<th>Blind 상태</th>
	<th>승인 상태</th>
</tr>
</thead>
<c:forEach items="${MenuList }" var="menu">
<tr>
	<td>${menu.menuNo}</td>
	<td>${menu.menuName}</td>
	<td>${menu.menuInfo}</td>
	<td>${menu.menuCost}</td>
	<td>${menu.menuDate}</td>
	<td>${menu.menuBlind}</td>
	<td>${menu.menuStat}</td>
</tr>
</c:forEach>


</table>
</div>

<c:import url="/WEB-INF/views/fran_layout/paging.jsp" />


<c:import url="/WEB-INF/views/fran_layout/footer.jsp" />