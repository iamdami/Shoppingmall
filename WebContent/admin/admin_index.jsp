<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>관리자전용 페이지</title>

<link rel="stylesheet" type="text/css" href="../css/board.css">

<script src="../js/script.js"></script>

<script type="text/javascript">



</script>

</head>

<body>



<h2>Page for admin</h2>

<%@ include file="admin_top.jsp" %>
<br><br>
<table style="width:100%">


	<tr>

		<td style="background-image: url(../images/adminpicc.png); 
		background-repeat: repeat;

		 background-position: center;
		 background-size: 800px 800px;">

			<br><br>

		<h3 style="text-align:center; color:white;">관리자 페이지</h3>

		</td>

	</tr>

</table>
<br><br>
<%@ include file="admin_bottom.jsp" %>

</body>

</html>