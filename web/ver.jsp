<%@ page import="javabeans.*,java.util.*"%>
<html>
    <head><title>Lista de Computadoras</title></head>
<body>
<center>
<h1>Computadoras</h1>
<table border=1>
<tr><th>Marca</th><th>Procesador</th><th>Memoria</th><th>Disco</th><th>MemoriaVideo</th><th>Descripcion</th></tr>
<%boolean men=false;
ArrayList computadoras=(ArrayList)request.getAttribute("computadoras");
if(computadoras!=null)
  //si existen mensajes para ese destinatario
  //se generará una tabla con los mismos
  for(int i=0;i<computadoras.size();i++){
    Computadoras m=(Computadoras)computadoras.get(i);
      men=true;%>
      <tr><td><%=m.getMarca()%></td><td><%=m.getProcesador()%></td><td><%=m.getMemoria()%></td><td><%=m.getDisco()%></td><td><%=m.getMemoriavideo()%></td><td><%=m.getDescripcion()%></td></tr>
    <%}
if(!men){%>
    <jsp:forward page="nomensajes.jsp"/>
<%}%>
</table>
<br/><br/>
<a href="inicio.html">Inicio</a>
</center>
</body>
</html>
