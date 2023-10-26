/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caso_1;

/**
 *
 * @author Ignacio
 */
public class Factura {
    public int numero;
    public double monto;
    public int mes;
    public int año;
    public int estado; // 1: Pagada, 2: No pagada

    public Factura(int numero, double monto, int mes, int año, int estado) {
        this.numero = numero;
        this.monto = monto;
        this.mes = mes;
        this.año = año;
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public double getMonto() {
        return monto;
    }

    public int getMes() {
        return mes;
    }

    public int getAño() {
        return año;
    }

    public int getEstado() {
        return estado;
    }
    
}
