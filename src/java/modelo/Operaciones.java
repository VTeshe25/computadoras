/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javabeans.Computadoras;
import javax.sql.DataSource;

/**
 *
 * @author Victor Teshe
 */
public class Operaciones {
    private String url;
    DataSource ds;
    PreparedStatement pstModificar;
    PreparedStatement pstEliminar;
    PreparedStatement pstInsertar;
    
     public Operaciones(String url) {
        //this.url=url;
        this.url = "jdbc:mysql://localhost:3306/favoritos?user=root&password=Doomrock321...";
     }
     
     public Operaciones(DataSource ds) {
        try {
            this.ds = ds;
            Connection cn = this.getConnection();
            pstModificar = cn.prepareStatement("Update computadoras set procesador=?,memoria=?,"
                    + "disco=?,memoriavideo=?,descripcion=? where marca=?");
            pstEliminar = cn.prepareStatement("Delete from computadoras where marca=?");
            pstInsertar = cn.prepareStatement("Insert into computadoras values(?,?,?,?,?,?)");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
     
     
     // Ordenar los campos Marca debería ser el sexto
     //
  public void modificaComputadoras(Computadoras c){
        try {
            pstModificar.setString(1, c.getProcesador());
            pstModificar.setInt(2, c.getMemoria());
            pstModificar.setString(3, c.getDisco());
            pstModificar.setInt(4, c.getMemoriavideo());
            pstModificar.setString(5, c.getDescripcion());
            pstModificar.setString(6, c.getMarca());
            pstModificar.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
  
  public void eliminaComputadoras(Computadoras c){
        try {
            pstEliminar.setString(1, c.getMarca());
            pstEliminar.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
     
 public Connection getConnection() {
        Connection cn = null;
        try {
//      Class.forName("com.mysql.jdbc.Driver").newInstance();
//      cn=DriverManager.getConnection(this.url);
            cn = this.ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cn;
    }
 
  public ArrayList obtenerComputadoras() {
        Connection cn = null;
        ArrayList computadoras = null;
        Statement st;
        ResultSet rs;
        try {
            cn = getConnection();
            st = cn.createStatement();
            String tsql;
            tsql = "select * from computadoras order by Marca";
            rs = st.executeQuery(tsql);
            computadoras = new ArrayList();
            //para cada registro encontrado crea un objeto Contacto y lo añade a la coleccion ArrayList
            while (rs.next()) {
                Computadoras m = new Computadoras(rs.getString("Marca"), rs.getString("Procesador"), rs.getInt("Memoria"),
                        rs.getString("Disco"), rs.getInt("MemoriaVideo"), rs.getString("Descripcion"));
                computadoras.add(m);
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return computadoras;
    }

public void insertaComputadoras(Computadoras c){
        try {
            pstInsertar.setString(1, c.getMarca());
            pstInsertar.setString(2, c.getProcesador());
            pstInsertar.setInt(3, c.getMemoria());
            pstInsertar.setString(4, c.getDisco());
            pstInsertar.setInt(5, c.getMemoriavideo());
            pstInsertar.setString(6, c.getDescripcion());
            pstInsertar.executeUpdate();
        } catch (Exception e) {
        }
    } 

public void grabaComputadoras(Computadoras c) {
        Connection cn;
        Statement st;
        //ResultSet rs;
        try {
            cn = getConnection();
            st = cn.createStatement();
            String tsql;
      //a partir de los datos del mensaje construye
            //la cadena SQL para realizar su inseri�n
            // Insert into clientes values(?,?,?,?,?,?,?,?)
            tsql = "Insert into computadoras values('";
            tsql += c.getMarca() + "','" + c.getProcesador() + "','" + c.getMemoria() + "','" + c.getDisco() + "','"
                    + c.getMemoriavideo()+ "','" + c.getDescripcion() + "')";
            st.execute(tsql);
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
    
}
