/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javabeans.Computadoras;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import modelo.*;

/**
 *
 * @author Victor Teshe
 */

public class Controlador extends HttpServlet {
  String url;
  DataSource ds = null;
  public void init(ServletConfig scfig){
    this.url = scfig.getInitParameter("url");
      try {
          Context ctx = new InitialContext();
          ds = (DataSource) ctx.lookup("jdbc/dsComputadoras");        
      } catch (Exception e) {
      }  
  }
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
  
  @Override
  public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      
//      HttpSession ses = request.getSession(true);
//      ses.setAttribute("nombre", "10");
//      String x = (String)ses.getAttribute("nombre");
//      ses.getId();
//      ses.setMaxInactiveInterval(100);
//      ses.invalidate();
//      ses.isNew();
//      ses.getLastAccessedTime();
//      
      
      
      
    String op=request.getParameter("operacion");
    if(op.equals("envio"))
      response.sendRedirect("envio.jsp");
    if(op.equals("grabar")){
      Computadoras con=(Computadoras)request.getAttribute("compu");
      //ses.setAttribute("contacto", con);
      Operaciones oper=new Operaciones(this.ds);
      oper.insertaComputadoras(con);
      response.sendRedirect("inicio.html");
    }  
    if(op.equals("envioModifica"))
        response.sendRedirect("envioModifica.jsp");
    if(op.equals("modifica")){
        Computadoras c = (Computadoras)request.getAttribute("compu");
        Operaciones opera = new Operaciones(this.ds);
        opera.modificaComputadoras(c);
        response.sendRedirect("inicio.html");
    }
    if(op.equals("envioElimina"))
        response.sendRedirect("envioElimina.jsp");
    if(op.equals("elimina")){
        Computadoras c = (Computadoras)request.getAttribute("compu");
        Operaciones opera = new Operaciones(this.ds);
        opera.eliminaComputadoras(c);
        response.sendRedirect("inicio.html");
    }
    if(op.equals("ver")){
      Operaciones oper=new Operaciones(this.ds);
      UtilidadesHTML utilHtml = new UtilidadesHTML();
      ArrayList computadoras=oper.obtenerComputadoras();
      String tablaHtml = utilHtml.generarTablaHtmlComputadoras(computadoras);
      //request.setAttribute("contactos",contactos);
      request.setAttribute("computadoras",tablaHtml);
      RequestDispatcher rd=request.getRequestDispatcher("/ver_1.jsp");
      rd.forward(request,response);
    }
  }
}



    
