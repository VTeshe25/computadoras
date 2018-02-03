<%@page import="javabeans.Computadoras"%>
<%@ page import="java.util.*"%>
<html>
    <head><title>Lista de Computadoras</title></head>
<body>
<center>
<h1>Computadoras</h1>
<%=(String)request.getAttribute("computadoras")%>
<%
    Computadoras c = new Computadoras();
%>
<br/><br/>
<a href="inicio.html">Inicio</a>
</center>
</body>
</html>