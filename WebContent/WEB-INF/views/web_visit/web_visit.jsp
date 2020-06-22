<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	window.onload = function(){
		 new Morris.Line({
	            element: 'morrisChart',
	              data: [
	                      { year: '2008', value: 30 },
	                      { year: '2009', value: 10 },
	                      { year: '2010', value: 5 },
	                      { year: '2011', value: 5 },
	                      { year: '2012', value: 20 }
	                  ],
	            xkey: 'year',
	            ykeys: ['value'],
	            labels: ['value']
	        
	        });
	        
	        new Morris.Donut({
	            element: 'morrisDonut',
	            data: [        
	                    {label: "Download Sales", value: 12},
	                    {label: "In-Store Sales", value: 30},
	                    {label: "Mail-Order Sales", value: 20}
	                  ]
	        });
		
	};                 
          
        
    </script>



</head>
<body>
      <div id="morrisChart" ></div>        
      <div id="morrisDonut" ></div>        
    
    

</body>
</html>