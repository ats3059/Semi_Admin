<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
   메뉴이름 : ${mukey.get(0).menuName }<br>
   신청이유 : ${blval.get(0).blindRsn }<br>
  블라인드 요청일자 : ${blval.get(0).blindDate }<br>
  블라인드 희망일자 : ${blval.get(0).blindStart }<br>
  비고: ${blval.get(0).blindNote }<br>
  이미지 : <img src = "/upload/${bimglist.get(0).imgServer }"><br>
 <button type="button" onclick="location.href='/m/web/main/blind/update?menuno=${menuno }' ">${menuno }</button>
</div>

