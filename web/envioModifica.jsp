<html>
<head>
<title>Modificar Computadora</title>
</head>
<!--captura de datos e inserción en el Javabean-->
<jsp:useBean id="compu" scope="request" class="javabeans.Computadoras" />
<jsp:setProperty name="compu" property="*"/>
<%if(request.getParameter("marca")!=null){%>
   <jsp:forward page="controlador?operacion=modifica"/>
<%}%>
<body>
<center>       
  <h1>Modificar Computadoras</h1>
  <form method="post">
  <br/><br/>
  <b>Datos de la Computadora:</b><br/><br/>
  Introduzca Marca:  <input type="text" name="marca"><br/>
  <br/>
  Introduzca Procesador:  <input type="text" name="procesador"><br/>
  <br/>
  Introduzca Memoria: <input type="int" name="memoria"><br/>
  <br/>
  Introduzca Disco: <input type="text" name="disco"><br/>
  <br/>
  Introduzca Memoria Video: <input type="int" name="memoriavideo"><br/>
  <br/>
  Introduzca Descripcion:  <input type="text" name="descripcion"><br/>
  <br/>
  <input type="submit" name="Submit" value="Modificar">
  <input type="reset" value="Reset">
  </form>
</center>
</body>
</html>
