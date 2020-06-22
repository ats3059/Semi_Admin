<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<section class="wrapper">

	<div class="gradetb">
		<p class="bg-primary">일반회원</p>
		<p class="bg-success">우수회원</p>
		<p class="bg-info">VIP</p>
		<p class="bg-warning">VVIP</p>

	</div>
	<h2 class="onlyh2">회원조회</h2>
	<div class="nav4">
		<div class="row">
			<div class="col-lg-6">
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search for...">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</span>
				</div>
				<!-- /input-group -->
			</div>
			<!-- /.col-lg-6 -->
		</div>
		<!-- /.row -->
	</div>
	<!-- nav4 -->

	<div class="tbcontainer">
		<table class="table table-bordered">
			<tr>
				<th style="width: 20%;">유저번호</th>
				<th style="width: 20%;">유저아이디</th>
				<th style="width: 20%;">한줄평 작성수</th>
				<th style="width: 20%;">별점 작성수</th>
				<th style="width: 20%;">등급</th>
			</tr>
		<c:forEach items="${list }" var="list">
		<tr>
	<td>${list.userNo }</td>
	<td>${list.userId }</td>
	<td>${list.reviewcnt }</td>
	<td>${list.startcnt }</td>

	<td>
		<c:choose>
			<c:when test="${list.userGrade eq 1 }">
				<%="등급1" %>
			</c:when>
			<c:when test="${list.userGrade eq 2 }">
				<%="등급2" %>
			</c:when>
			<c:when test="${list.userGrade eq 3 }">
				<%="등급3" %>
			</c:when>
			<c:otherwise>
				<%="등급4" %>
			</c:otherwise>
		</c:choose>
	</td>
	
</tr>
		</c:forEach>



		</table>






	</div>
</section>