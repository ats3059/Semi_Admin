<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%List<Date>graphKey =(List)request.getAttribute("graphKey"); %> 
<%List<Integer>graphVal =(List)request.getAttribute("graphVal"); %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>

<script> 
var key=[];
var val=[];
<% int cnt=0; %>
	 <% for(int i=0;i<graphKey.size();i++){ 			
		String year= String.valueOf(graphKey.get(i).getYear()+1900);
		String month=String.valueOf(graphKey.get(i).getMonth()+1);
		String date = String.valueOf(graphKey.get(i).getDate());
		int total=graphVal.get(i);	  %>
		
 	key.push(<%=year%>+ "-" +<%=month%>+ "-" +<%=date %>); 
	val.push(<%=total%>);		
<%  } %> 

	window.onload = function(){
		console.log(key[0])
		 new Morris.Line({
	            element: 'morrisChart',
	              data: [
	                      { period: key[0] , value: val[0] },
	                      { period:	key[1] , value: 20 },
	                      { period: key[2] , value: 20 },
	                      { period: key[3] , value: 20 },
	                      { period: key[4] , value: 20 },
	                      { period: key[5] , value: 20 },
	                     
	                      
	                      
	                  ],
	                  
	            xkey: 'period',
	            ykeys: ['value'],
	            labels: ['value'],  
	            xLabels: 'day'
	        
	        });
	        
		
	};                 
          
        
    </script>



</head>
<body>
      <div id="morrisChart" ></div>        
  	<div id ="div1"></div>

</body>
</html>