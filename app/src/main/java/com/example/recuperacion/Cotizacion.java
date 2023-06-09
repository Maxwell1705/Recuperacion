package com.example.recuperacion;

public class Cotizacion {
    private int folio = 0;
    private String descripcion = "";
    private float valorAuto = 0;
    private float porEnganche = 0;
    private int plazo = 0;

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

    public Cotizacion(int folio, String descripcion, float valorAuto, float porEnganche, int plazo){
        this.folio = folio;
        this.descripcion = descripcion;
        this.valorAuto = valorAuto;
        this.porEnganche = porEnganche;
        this.plazo = plazo;
    }

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

