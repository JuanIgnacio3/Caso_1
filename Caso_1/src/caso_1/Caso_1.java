/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package caso_1;

import java.util.Scanner;

/**
 *
 * @author Ignacio
 */
public class Caso_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Bienvenido al caso 1 de Juan Ignacio!");
        System.out.println("");
        System.out.println("");

        System.out.println("Ingrese el nombre del cliente:");
        String nombre = scanner.nextLine();
        System.out.println("");
        System.out.println("Ingrese la cédula del cliente:");
        String cedula = scanner.nextLine();
        System.out.println("");

        System.out.println("Ingrese la cantidad máxima de facturas a registrar:");
        int maxFacturas = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("");

        Cliente cliente = new Cliente(nombre, cedula, maxFacturas);

        System.out.println("Ingrese la cantidad de facturas a registrar:");
        int numFacturas = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("");
        System.out.println("");
        System.out.println("");

        for (int i = 1; i <= numFacturas; i++) {
            System.out.println("Factura " + i + ":");
            System.out.println("");
            System.out.println("Número de factura:");
            int numero = scanner.nextInt();
            System.out.println("");
            System.out.println("Monto de la factura:");
            double monto = scanner.nextDouble();
            System.out.println("");
            System.out.println("Mes de la factura (1-12):");
            int mes = scanner.nextInt();
            System.out.println("");
            System.out.println("Año de la factura:");
            int año = scanner.nextInt();
            System.out.println("");
            System.out.println("Estado de la factura (1: Pagada, 2: No pagada):");
            int estado = scanner.nextInt();
            scanner.nextLine(); 
            System.out.println("");
            System.out.println("");

            Factura factura = new Factura(numero, monto, mes, año, estado);
            cliente.agregarFactura(factura);
        }
        
        System.out.println("");
        System.out.println("");
        
        cliente.calcularTotalPagado();
        System.out.println("Información del cliente:");
        System.out.println("");
        System.out.println("Nombre: " + cliente.getNombre());
        System.out.println("Cédula: " + cliente.getCedula());
        System.out.println("Facturas registradas:");

        for (int i = 0; i < cliente.getNumFacturas(); i++) {
            Factura factura = cliente.getFacturas()[i];
            System.out.println("Número: " + factura.getNumero());
            System.out.println("Monto: " + factura.getMonto());
            System.out.println("Mes: " + factura.getMes());
            System.out.println("Año: " + factura.getAño());
            System.out.println("Estado: " + (factura.getEstado() == 1 ? "Pagada" : "No pagada"));
        }

        System.out.println("Total pagado por el cliente: " + cliente.getTotalPagado());
        System.out.println("");
        
        System.out.println("Deuda total del cliente: " + cliente.calcularDeudaTotal());

        int numCuotas = 6; 
        int añoInicio = 2023; 
        cliente.imprimirPlanPagos(numCuotas, añoInicio);
    
    }
}
