package com.example.cotizacion;

import java.util.concurrent.atomic.DoubleAdder;

public class cotizacion {
    //Atributos
    private int NoCotizacion;
    private String desAutomovil;
    private double precio;
    private double porcentajePagoInicial;
    private int plazo;
    private double pagoInicial;
    private double pagoFinal;
    private double pagoMensual;


    //Constructor vacio
    cotizacion() {
        this.NoCotizacion = 0;
        this.desAutomovil = "";
        this.precio = 0.0;
        this.porcentajePagoInicial = 0.0;
        this.plazo = 0;
    }

    //Constructor de parametros
    cotizacion(int numeroCotizacion,
               String descripcionAutomovil,
               double precio,
               double porcentajePagoInicial,
               int plazo) {
        this.NoCotizacion = numeroCotizacion;
        this.desAutomovil = descripcionAutomovil;
        this.precio = precio;
        this.porcentajePagoInicial = porcentajePagoInicial;
        this.plazo = plazo;
    }

    //Constructor de copia
    cotizacion(cotizacion costo) {
        this.NoCotizacion = costo.NoCotizacion;
        this.desAutomovil = costo.desAutomovil;
        this.precio = costo.precio;
        this.porcentajePagoInicial = costo.porcentajePagoInicial;
        this.plazo = costo.plazo;
    }

    /**
     * @return the numeroCotizacion
     */
    public int getNumeroCotizacion() {
        return NoCotizacion;
    }

    /**
     * @param numeroCotizacion the numeroCotizacion to set
     */
    public void setNumeroCotizacion(int numeroCotizacion) {
        this.NoCotizacion = numeroCotizacion;
    }

    /**
     * @return the descripcionAutomovil
     */
    public String getDescripcionAutomovil() {
        return desAutomovil;
    }

    /**
     * @param descripcionAutomovil the descripcionAutomovil to set
     */
    public void setDescripcionAutomovil(String descripcionAutomovil) {
        this.desAutomovil = descripcionAutomovil;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the porcentajePagoInicial
     */
    public double getPorcentajePagoInicial() {
        return porcentajePagoInicial;
    }

    /**
     * @param porcentajePagoInicial the porcentajePagoInicial to set
     */
    public void setPorcentajePagoInicial(double porcentajePagoInicial) {
        this.porcentajePagoInicial = porcentajePagoInicial;
    }

    /**
     * @return the plazo
     */
    public int getPlazo() {
        return plazo;
    }

    /**
     * @param plazo the plazo to set
     */
    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }


    //Funciones
    public Double calcularPagoInicial() {
        pagoInicial = precio * (porcentajePagoInicial  / 100);
        return pagoInicial;
    }

    public Double calcularTotalFinal() {
        pagoFinal = precio - pagoInicial;
        return pagoFinal;
    }

    public Double calcularPagoMensual() {
        pagoMensual = pagoFinal / plazo;
        return pagoMensual;
    }
}