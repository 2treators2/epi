/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.epi;

/**
 *
 * @author sebag
 */
public class H2V {
    private double caudal;
    private double corriente;
    private double voltaje;
    private double horas;
    private double energiaInicial;
    
    public H2V(double caudal, double voltaje, double corriente, double horas){
        this.caudal=caudal;
        this.voltaje=voltaje;
        this.corriente=corriente;
        this.horas=3600*horas;
        this.energiaInicial = 0;
    }
    public H2V(double caudal, double voltaje, double corriente, double horas, double energiaInicial){
        this.caudal=caudal;
        this.voltaje=voltaje;
        this.corriente=corriente;
        this.horas= 3600*horas;
        this.energiaInicial = energiaInicial;
    }
    public double calcularProduccion(){
    double masa = this.energiaInicial + ((((corriente * horas * 2.0) / (2.0 * 96485.0) * 0.8) * caudal) / 1000);
    return masa;
    }
       
}
