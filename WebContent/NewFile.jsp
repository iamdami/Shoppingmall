<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
     <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
Connection conn=null;
String driver = "oracle.jdbc.driver.OracleDriver";
String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	
Boolean connect = false;
	
try{
    Class.forName(driver);
    conn=DriverManager.getConnection(url,"SYSTEM","1234"); //�ڽ��� ���̵�� ��й�ȣ
    connect = true;
    conn.close();
}catch(Exception e){
    connect = false;
    e.printStackTrace();
}
%>
<%
if(connect==true){%>
    ����Ǿ����ϴ�.
<%}else{ %>
    ���ῡ �����Ͽ����ϴ�.
<%}%> 
</body>
</html>