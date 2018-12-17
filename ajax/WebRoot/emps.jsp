<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script type="text/javascript" src="ajax.js"></script>
  	<script type="text/javascript" src="jquery-3.3.1.min.js"></script>
  	<script type="text/javascript">
  		$(function(){
  			$ajax({
  				url:"cemp.do",
  				type:"post",
  				data:{
  				},
  				success:function(data){
  					for(i in data){
  						var p = $("<p></p>");
  						p.text(data[i].EMPNO+","+data[i].ENAME+","+data[i].SAL+","+data[i].JOB+","+data[i].COMM);
  						$(".div").append(p);
  					}
  				},
  				error:function(error){
  					alert(error);
  				}
  			});
  			/* setInterval(function() {
  				$ajax({
  				url:"cemp.do",
  				type:"post",
  				data:{},
  				success:function(data){
  				
  					for(i in data){
  						var p = $("<p></p>");
  						p.text(data[i].EMPNO+","+data[i].ENAME+","+data[i].SAL+","+data[i].JOB+","+data[i].COMM);
  						$(".div").append(p);
  					}
  				},
  				error:function(error){
  					alert(error);
  				}
  			});
  			}, 100000); */
  		});
  	</script>
  </head>
  <body>
  	<h1>工作排行榜</h1>
	<div class="div"></div>
  </body>
</html>
