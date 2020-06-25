<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div>
   프렌차이즈 이름: ${frkey.get(0).franName }<br>
   메뉴이름 : ${muval.get(0).menuName }<br>
  가격 : ${muval.get(0).menuCost }<br>
  설명 : ${muval.get(0).menuInfo }<br> 
 신청날짜 : ${muval.get(0).menuDate }<br>
   이미지 : <img src = "/upload/${imglist.get(0).imgServer }"><br>
  <button type="button" onclick="location.href='/m/web/main/fran/update?menuno=${menuno }' ">승인</button>
    
    </div>