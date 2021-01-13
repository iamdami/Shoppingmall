<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>
    
    <%@page import="java.util.*"%>
<%
request.setCharacterEncoding("UTF-8");
%>


<%String id = (String)session.getAttribute("idKey"); %>

<!DOCTYPE html>

<html>

<head>

<title>회원가입</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<link href="../css/style.css" rel="stylesheet" type="text/css">

<script src="../js/script.js"></script>

<script type="text/javascript">

window.onload = function(){

	regForm.id.focus();


	document.getElementById("btnId").onclick = idCheck;

	document.getElementById("btnSubmit").onclick = inputCheck;

}

</script>

</head>

<body>

<br>

<table class="table">

<tr>

	<td align="center" valign="middle" style="background-color: #E9B1B9">

		<form name="regForm" method="post" action="registerproc.jsp">

			<table border="1">

				<tr align="center" style="background-color: #8899aa">

					<td colspan="2"><b style="color: #FFFFFF">회원 가입</b></td>

				</tr>

			<tr>

					<td width="16%">아이디</td>

					<td width="57%"><input type="text" name="id" size="20">

						<input type="button" value="ID중복확인" id="btnId"></td>

				</tr>

				<tr>

					<td>패스워드</td>

					<td><input type="password" name="passwd" size="20"></td>

				</tr>


				<tr>

					<td>이름</td>

					<td><input type="text" name="name" size="20"></td>

				</tr>

				<tr>

					<td>이메일</td>

					<td><input type="text" name="email" size="40"></td>

				</tr>

				<tr>

					<td>전화번호</td>

					<td><input type="text" name="phone" size="30"></td>

				</tr>

			

				<tr>

					<td>주소</td>

					<td><input type="text" name="address" size="100"></td>

				</tr>

				

				<tr>

					<td colspan="2" align="center">

						<input type="button"

				value="회원가입" id="btnSubmit">

						&nbsp;&nbsp;&nbsp;&nbsp; 

						<input type="reset" value="다시쓰기">

						&nbsp;&nbsp;&nbsp;&nbsp;

						<input type="button" value="메인으로" onclick="location.href='../index.jsp'">

					</td>

				</tr>

			</table>

		</form>

	</td>

</tr>

</table>

</body>

</html>