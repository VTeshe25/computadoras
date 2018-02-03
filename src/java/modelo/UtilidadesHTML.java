/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import javabeans.Computadoras;

/**
 *
 * @author Victor Teshe
 */
public class UtilidadesHTML {
    
        public String generarTablaHtmlComputadoras(ArrayList listaComputadoras) {
        String html = "<table border=1>";
        html += "<tr><th>Marca</th><th>Procesador</th><th>Memoria</th>"
                + "<th>Disco</th><th>MemoriaVideo</th><th>Descripcion</th></tr>";
        for (Object objComputadoras : listaComputadoras) {
            Computadoras computadoras = (Computadoras) objComputadoras;
            html += "<tr>";
            html += "<td>" + computadoras.getMarca() + "</td>";
            html += "<td>" + computadoras.getProcesador() + "</td>";
            html += "<td>" + computadoras.getMemoria() + "</td>";
            html += "<td>" + computadoras.getDisco() + "</td>";
            html += "<td>" + computadoras.getMemoriavideo() + "</td>";
            html += "<td>" + computadoras.getDescripcion() + "</td>";
            html += "</tr>";
        }
        html += "</table>";
        return html;
    }
    
}
