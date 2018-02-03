/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

/**
 *
 * @author Victor Teshe
 */
public class Computadoras {
    
    private String marca;
    private String procesador;
    private int memoria;
    private String disco;
    private int memoriavideo;
    private String descripcion;
    /**
     * @return the nombre
     */
    public Computadoras(){
    }
    public Computadoras(String marca,String procesador,int memoria,String disco,int memoriavideo,String descripcion){
        this.marca = marca;
        this.procesador = procesador;
        this.memoria = memoria;
        this.disco = disco;
        this.memoriavideo = memoriavideo;
        this.descripcion = descripcion;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getProcesador() {
        return procesador;
    }
    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }
    public int getMemoria() {
        return memoria;
    }
    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }
    public String getDisco() {
        return disco;
    }
    public void setDisco(String disco) {
        this.disco = disco;
    }
    public int getMemoriavideo() {
        return memoriavideo;
    }
    public void setMemoriavideo(int memoriavideo) {
        this.memoriavideo = memoriavideo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
