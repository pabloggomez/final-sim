/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasAleatoridad;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Bruno
 */
public class ChiCuadrado {
    private double[] serie;     //Serie a probar
    private int k;              //Cantidad de Intervalos
    private int v;              //Grados de Libertad
    private double tabla[][];   //Tabla...
    private double precision;   //Precision con la que quiero trabajar (0.1, 0.01, 0.001, 0.0001)
    private double[] tablaChiCuadrado95;        //valores de tabla chi2 nivel de confianza 0.95
    private double r;
    public ChiCuadrado(double[] serie, int k, int op) {
        this.serie = serie;
        this.k = k;
        this.v = this.k - 1 - 0;
        this.tabla = new double[6][this.k];
        for (int i = 0; i < this.k; i++) {
            tabla[0][i] = i + 1;
        }
        for (int i = 0; i < this.k; i++) {
            tabla[3][i] = 0;
        }
        switch(op){
            case 1:
                precision = 0.1;
                break;
            case 2:
                precision = 0.01;
                break;
            case 3:
                precision = 0.001;
                break;
            case 4:
                precision = 0.0001;
                break;
        }
        this.r = 0;
        this.tablaChiCuadrado95 = new double[100];
        
        tablaChiCuadrado95[0] = 3.841;
        tablaChiCuadrado95[1] = 5.991;
        tablaChiCuadrado95[2] = 7.815;
        tablaChiCuadrado95[3] = 9.488;
        tablaChiCuadrado95[4] = 11.070;
        tablaChiCuadrado95[5] = 12.592;
        tablaChiCuadrado95[6] = 14.067;
        tablaChiCuadrado95[7] = 15.507;
        tablaChiCuadrado95[8] = 16.919;
        tablaChiCuadrado95[9] = 18.307;
        tablaChiCuadrado95[10] = 19.675;
        tablaChiCuadrado95[11] = 21.026;
        tablaChiCuadrado95[12] = 22.362;
        tablaChiCuadrado95[13] = 23.685;
        tablaChiCuadrado95[14] = 24.996;
        tablaChiCuadrado95[15] = 26.296;
        tablaChiCuadrado95[16] = 27.587;
        tablaChiCuadrado95[17] = 28.869;
        tablaChiCuadrado95[18] = 30.144;
        tablaChiCuadrado95[19] = 31.410;
        tablaChiCuadrado95[20] = 32.671;
        tablaChiCuadrado95[21] = 33.924;
        tablaChiCuadrado95[22] = 35.172;
        tablaChiCuadrado95[23] = 36.415;
        tablaChiCuadrado95[24] = 37.652;
        tablaChiCuadrado95[25] = 38.885;
        tablaChiCuadrado95[26] = 40.113;
        tablaChiCuadrado95[27] = 41.337;
        tablaChiCuadrado95[28] = 42.557;
        tablaChiCuadrado95[29] = 43.773;
        tablaChiCuadrado95[39] = 53.7;
        tablaChiCuadrado95[49] = 66.8;
        tablaChiCuadrado95[59] = 79.5;
        tablaChiCuadrado95[69] = 104.2;
        tablaChiCuadrado95[79] = 116.3;
        tablaChiCuadrado95[89] = 128.3;
        tablaChiCuadrado95[99] = 140.2;
        
    }
    
    public void distribucion(String distribucion){
        quickSort();
        setIntervalos(distribucion);
        for (int i = 0; i < serie.length; i++) {
            for (int j = 0; j < k; j++) {
                if (tabla[1][j]<= serie[i] && serie[i] <=tabla[2][j]) {
                    tabla[3][j]++;
                    break;
                }
            }
        }
    }
    
    public double chiCalculada() {
        for (int i = 0; i < k; i++) {
            tabla[5][i] = Math.pow((tabla[1][i] - tabla[2][i]), 2);
        }
        for (int i = 0; i < k; i++) {
            tabla[6][i] = tabla[5][i] / tabla[2][i];
        }
        
        for (int i = 0; i < k; i++) {
            r += tabla[6][i];
        }
        return r;
    }

    public boolean hipotesis(String distribucion) {
        distribucion(distribucion);
        return chiCalculada() <= tablaChiCuadrado95[v - 1];

    }

    public double[] getSerie() {
        return serie;
    }

    public void setSerie(double[] serie) {
        this.serie = serie;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public double[][] getTabla() {
        return tabla;
    }

    public void setTabla(double[][] tabla) {
        this.tabla = tabla;
    }
    
    public void setFe(double fe,int intervalo){
        if(fe == 0){
            fe=1;
        }
        this.tabla[2][intervalo]=fe;
    }

    public String getPosTabla (int col,int row){
        return String.valueOf(tabla[col][row]);
    }
    
    public String getValueTablaChi (){
        return String.valueOf(tablaChiCuadrado95[v - 1]);
    }
    
    public double getPrecision() {
        return precision;
    }

    public void setPrecision(double precision) {
        this.precision = precision;
    }

    public double[] getTablaChiCuadrado95() {
        return tablaChiCuadrado95;
    }

    public void setTablaChiCuadrado95(double[] tablaChiCuadrado95) {
        this.tablaChiCuadrado95 = tablaChiCuadrado95;
    }
    
    public void setIntervalos(String op){
        quickSort();
        double auxiliar;
        double rango;
        switch(op){
            case "poisson":
                tabla[1][0] = 0;
                tabla[2][tabla[1].length-1] = serie[serie.length-1]+1;
                auxiliar = serie[serie.length - 1] - serie[0];
                rango = Math.ceil(auxiliar / k);
                for (int j = 0; j < tabla[1].length; j++) {
                    if (j!=0) {
                        double li = tabla[1][j] + (rango) + 1;
                        tabla[1][j] = li;
                    }
                    if (j!=tabla[1].length-1) {
                        double ls = tabla[1][j] + rango;
                        tabla[2][j] = ls;                        
                    }
                    
                }
                break;
            case "uniforme":
                tabla[1][0] = Math.floor(serie[0]);
                tabla[2][tabla[1].length-1] = Math.ceil(serie[serie.length-1]);
                auxiliar = tabla[2][tabla[1].length-1] - tabla[1][0];
                rango = (auxiliar / k);
                for (int j = 0; j < tabla[1].length; j++) {
                    if (j!=0) {
                        double li = tabla[1][j-1] + (rango) + precision;
                        tabla[1][j] = li;
                    }
                    if (j!=tabla[1].length-1) {
                        double ls = tabla[1][j] + rango;
                        tabla[2][j] = ls;                        
                    }
                    
                }
                break;
            case "normal":
                tabla[1][0] = Math.floor(serie[0]);
                tabla[2][tabla[1].length-1] = Math.ceil(serie[serie.length-1]);
                auxiliar = tabla[2][tabla[1].length-1] - tabla[1][0];
                rango = (auxiliar / k);
                for (int j = 0; j < tabla[1].length; j++) {
                    if (j!=0) {
                        double li = tabla[1][j] + (rango) + precision;
                        tabla[1][j] = li;
                    }
                    if (j!=tabla[1].length-1) {
                        double ls = tabla[1][j] + rango;
                        tabla[2][j] = ls;                        
                    }
                    
                }
                
                break;    
            case "exponencial":
                tabla[1][0] = 0;
                tabla[2][tabla[2].length-1] = serie[serie.length-1]+1;
                auxiliar = serie[serie.length - 1] - serie[0];
                rango = (auxiliar / k);
                for (int j = 0; j < tabla[1].length; j++) {
                    if (j!=0) {
                        double li = tabla[1][j] + (rango) + precision;
                        tabla[1][j] = li;
                    }
                    if (j!=tabla[1].length-1) {
                        double ls = tabla[1][j] + rango;
                        tabla[2][j] = ls;                        
                    }
                    
                }
                
                break; 
        }

    }
    
    public void resizeTable(){
        
    }
    
    
    public String getIntervalo(int intervalo){
//        double auxiliar = serie[serie.length - 1] - serie[0];
//        double rango = (auxiliar / k);
//        if (poisson && rango < 1) {
//            rango = 1;
//        }
//        double li = serie[0] + (rango + precision) * (intervalo - 1);
//        if (poisson) {
//            li = (int) Math.floor(li);
//
//        }
//        double ls = li + rango;
//        if (poisson) {
//
//            if (intervalo == 0) {
//                li = 0;
//            }
//
//        }
//        String lin = new BigDecimal(li)
//                .setScale(4, RoundingMode.DOWN)
//                .stripTrailingZeros()
//                .toString();
//        String lsu;
//        
//        if (li == 10) {
//            lsu="10";
//        }
//        if (ls == 10) {
//             lsu = "10";
//        } else {
//            lsu = new BigDecimal(ls)
//                .setScale(4, RoundingMode.DOWN)
//                .stripTrailingZeros()
//                .toString();
//        }
//        
//        
        return (tabla[1][intervalo] + " - " + tabla[2][intervalo]);
    }
    
    public double getFrecuenciaObs(int intervalo){
        return tabla[1][intervalo];
    }
    
    public double getFrecuenciaEsp(int intervalo){
        return tabla[2][intervalo];
    }
    
    
    public double getR() {
        return r;
    }
    
    public void quickSort()
    {
        quick(0, serie.length - 1);
    }

    private void quick(int izq, int der)
    {
        int i = izq, j = der;
        double y;
        double x = serie[(izq + der) / 2];
        do
        {
            while (serie[i] < x && i < der)
            {
                i++;
            }
            while (x < serie[j] && j > izq)
            {
                j--;
            }
            if (i <= j)
            {
                y = serie[i];
                serie[i] = serie[j];
                serie[j] = y;
                i++;
                j--;
            }
        } while (i <= j);
        if (izq < j)
        {
            quick(izq, j);
        }
        if (i < der)
        {
            quick(i, der);
        }
    }

    public double getFrecuenciaEspMayor(int i) {
        double aux = 1;
        for (double d : tabla[2]) {
            if (d > aux) {
                aux=d;
            }
        }
        for (double d : tabla[1]) {
            if (d > aux) {
                aux=d;
            }
        }
        return aux;
    }
    
    public String getDesde(int i){
        return String.valueOf(this.tabla[1][i]);
    }
    
    public String getHasta(int i){
        return String.valueOf(this.tabla[2][i]);
    }
    
    public void setDesde(int i, double x){
        this.tabla[1][i] = x;
    }
    
    public void setHasta(int i, double x){
        this.tabla[2][i] = x;
    }
    
}
