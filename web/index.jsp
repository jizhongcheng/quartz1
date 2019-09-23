<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <script type="text/javascript" src="js/jquery-1.11.0.js"></script>
    <script type="text/javascript">
    	var currentPage = 1 , pageSize = 10;
    	var totalCount , totalPage;
    	$(function(){
    		requestData();
    	});
    	function requestData(){
    		$.ajax({
//     			url:"selectuser",
    			url:"selectuser",
//    			dataType:"json",
    			type:"post",
    			success:function(data){
    				console.log(333);
    			}
    		});
    	}
    </script>
  </head>
  
  <body>
	success
  </body>
</html>