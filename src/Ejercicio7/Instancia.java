/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio7;

/**
 *
 * @author YO
 */
public class Instancia {
    private int nroSemana1; 
    private double rndDemanda1;
    private int demanda1;
    private int cantVendida1;
    private int stockInicial1;
    private int stockFinal1;
    private double rndDemora1;
    private int semanasRestantesP1;
    private float cPed1;
    private float acumCP1;
    private float cMan1;
    private float acumCMan1;
    private float cFalt1;
    private float acumCFalt1;
    private int pRep;
    private float cTAcum;
    
    
        public Instancia() 
        {
            this.nroSemana1=0;
            this.rndDemanda1=0;
            this.demanda1=0;
            this.cantVendida1=0;
            this.stockInicial1=0;
            this.stockFinal1=0;
            this.rndDemora1=0;
            this.semanasRestantesP1=0;
            this.cPed1=0;
            this.cFalt1=0;
            this.cMan1=0;
            this.cTAcum=0;
            this.acumCFalt1=0;
            this.acumCMan1=0;
            this.acumCP1=0;
            
        }

    public float getcT() {
        return cTAcum;
    }

    public void setcT(float cT) {
        this.cTAcum = cT;
    }
                 

    public int getpRep() {
        return pRep;
    }

    public void setpRep(int pRep) {
        this.pRep = pRep;
    }
    

    public int getSemana() {
        return nroSemana1;
    }

    public void setSemana(int semana) {
        this.nroSemana1 = semana;
    }

    public double getRndDemanda() {
        return rndDemanda1;
    }

    public void setRndDemanda(double rndDemanda) {
        this.rndDemanda1 = rndDemanda;
    }

    public int getDemanda() {
        return demanda1;
    }

    public void setDemanda(int demanda) {
        this.demanda1 = demanda;
    }

    public int getCuantoVende() {
        return cantVendida1;
    }

    public void setCuantoVende(int cuantoVende) {
        this.cantVendida1 = cuantoVende;
    }

    public int getStockInicial() {
        return stockInicial1;
    }

    public void setStockInicial(int stockInicial) {
        this.stockInicial1 = stockInicial;
    }

    public int getStockFinal() {
        return stockFinal1;
    }

    public void setStockFinal(int stockFinal) {
        this.stockFinal1 = stockFinal;
    }

    public double getRndDemora() {
        return rndDemora1;
    }

    public void setRndDemora(double rndDemora) {
        this.rndDemora1 = rndDemora;
    }


    public int getSemanasRestantes() {
        return semanasRestantesP1;
    }

    public void setSemanasRestantes(int semanasRestantes) {
        this.semanasRestantesP1 = semanasRestantes;
    }



    public float getcPed1() {
        return cPed1;
    }

    public void setcPed1(float cPed1) {
        this.cPed1 = cPed1;
    }

    public float getAcumCP1() {
        return acumCP1;
    }

    public void setAcumCP1(float acumCP1) {
        this.acumCP1 = acumCP1;
    }

    public float getcMan1() {
        return cMan1;
    }

    public void setcMan1(float cMan1) {
        this.cMan1 = cMan1;
    }

    public float getAcumCMan1() {
        return acumCMan1;
    }

    public void setAcumCMan1(float acumCMan1) {
        this.acumCMan1 = acumCMan1;
    }

    public float getcFalt1() {
        return cFalt1;
    }

    public void setcFalt1(float cFalt1) {
        this.cFalt1 = cFalt1;
    }

    public float getAcumCFalt1() {
        return acumCFalt1;
    }

    public void setAcumCFalt1(float acumCFalt10) {
        this.acumCFalt1 = acumCFalt10;
    }

    public float obtenerCostoTotal() {
        return acumCFalt1 + acumCMan1 + acumCP1;
    }


    
    
}
