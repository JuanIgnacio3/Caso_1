/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caso_1;

/**
 *
 * @author Ignacio
 */
public class Cliente {
    public String nombre;
    public String cedula;
    public Factura[] facturas;
    public int numFacturas;
    public double totalPagado;

    public Cliente(String nombre, String cedula, int maxFacturas) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.facturas = new Factura[maxFacturas];
        this.numFacturas = 0;
        this.totalPagado = 0;
    }

    public void agregarFactura(Factura factura) {
        if (numFacturas < facturas.length) {
            facturas[numFacturas] = factura;
            numFacturas++;
        } else {
            System.out.println("No se pueden agregar más facturas.");
        }
    }

    public void calcularTotalPagado() {
        for (int i = 0; i < numFacturas; i++) {
            if (facturas[i].getEstado() == 1) {
                totalPagado += facturas[i].getMonto();
            }
        }
    }

    public double getTotalPagado() {
        return totalPagado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public Factura[] getFacturas() {
        return facturas;
    }

    public int getNumFacturas() {
        return numFacturas;
    }
    
    public double calcularDeudaTotal() {
        double deudaTotal = 0;
        for (int i = 0; i < numFacturas; i++) {
            if (facturas[i].getEstado() == 2) {
                deudaTotal += facturas[i].getMonto();
            }
        }
        return deudaTotal;
    }

    public double calcularCobroFraccionado(double tasaInteres, int numMeses) {
        double deudaTotal = calcularDeudaTotal();
        return (deudaTotal * tasaInteres + deudaTotal) / numMeses;
    }

    public void imprimirPlanPagos(int numMeses, int añoInicio) {
        double cuotaMensual = calcularCobroFraccionado(0.05, numMeses);
        int mesInicio = 7; 
        for (int i = 1; i <= numMeses; i++) {
            System.out.println("Cuota " + i + " " + cuotaMensual + " Fecha de pago " + obtenerNombreMes(mesInicio) + " " + añoInicio);
            mesInicio++;
            if (mesInicio > 12) {
                mesInicio = 1; 
                añoInicio++;
            }
        }
    }

    private String obtenerNombreMes(int mes) {
        String[] nombresMeses = {
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Setiembre", "Octubre", "Noviembre", "Diciembre"
        };
        return nombresMeses[mes - 1];
    }

}
