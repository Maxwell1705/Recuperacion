package com.example.recuperacion;

public class Cotizacion {
    private int folio;
    private String descripcion;
    private float valorAuto;
    private float porEnganche;
    private int plazo;

    // Getters y Setters

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public float getValorAuto() {
        return valorAuto;
    }

    public void setValorAuto(float valorAuto) {
        this.valorAuto = valorAuto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPorEnganche() {
        return porEnganche;
    }

    public void setPorEnganche(float porEnganche) {
        this.porEnganche = porEnganche;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public Cotizacion(){
        this.folio = 0;
        this.descripcion = "";
        this.valorAuto = 0;
        this.porEnganche = 0;
        this.plazo = 0;
    }
    // Constructor de parametros
    public Cotizacion(int folio, String descripcion, float valorAuto, float porEnganche, int plazo){
        this.folio = folio;
        this.descripcion = descripcion;
        this.valorAuto = valorAuto;
        this.porEnganche = porEnganche;
        this.plazo = plazo;
    }

    // Métodos
    public int generarFolio(){
        return this.folio + 1;
    }

    public float calcularEnganche(float valorAuto, float porEnganche){
        float enganche = valorAuto * (porEnganche / 100);
        return enganche;
    }

    public float calcularPagoMensual(float valorAuto, float enganche, int plazo){
        float total = valorAuto - enganche;
        float pagoMensual = total / plazo;

        return pagoMensual;
    }
}
