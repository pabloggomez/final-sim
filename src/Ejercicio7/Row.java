/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio7;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author 62684
 */
public class Row
    {

        private final SimpleStringProperty nroSemana1;
        private final SimpleStringProperty stockInicial1;
        private final SimpleStringProperty rndDemanda1;
        private final SimpleStringProperty demanda1;
        private final SimpleStringProperty cantVendida1;
        private final SimpleStringProperty stockFinal1;
        private final SimpleStringProperty rndDemora1;
        private final SimpleStringProperty semanasRestantesP1;
        private final SimpleStringProperty cPed1;
        private final SimpleStringProperty acumCP1;
        private final SimpleStringProperty cMan1;
        private final SimpleStringProperty acumCMan1;
        private final SimpleStringProperty cFalt1;
        private final SimpleStringProperty acumCFalt1;
        private final SimpleStringProperty cTAcum;


        public Row(String nroSemana1,String stockInicial1,String rndDemanda1,String demanda1,String cantVendida1,String stockFinal1,String rndDemora1,String semanasRestantesP1,String cPed1,String acumCP1,String cMan1,String acumCMan1,String cFalt1,String acumCFalt1,String cTAcum)
        {
            this.nroSemana1 = new SimpleStringProperty(nroSemana1);
            this.stockInicial1 = new SimpleStringProperty(stockInicial1);
            this.rndDemanda1 = new SimpleStringProperty(rndDemanda1);
            this.demanda1 = new SimpleStringProperty(demanda1);
            this.cantVendida1 = new SimpleStringProperty(cantVendida1);
            this.stockFinal1 = new SimpleStringProperty(stockFinal1);
            this.rndDemora1 = new SimpleStringProperty(rndDemora1);
            this.semanasRestantesP1 = new SimpleStringProperty(semanasRestantesP1);
            this.cPed1 = new SimpleStringProperty(cPed1);
            this.acumCP1 = new SimpleStringProperty(acumCP1);
            this.cMan1 = new SimpleStringProperty(cMan1);
            this.acumCMan1 = new SimpleStringProperty(acumCMan1);
            this.cFalt1 = new SimpleStringProperty(cFalt1);
            this.acumCFalt1 = new SimpleStringProperty(acumCFalt1);
            this.cTAcum = new SimpleStringProperty(cTAcum);
        }

        
        public void setSemana(String asd)
        {
            nroSemana1.set(asd);
        }

        public void setRndDemanda(String asd)
        {
            rndDemanda1.set(asd);
        }

        public void setRndDemora(String asd)
        {
            rndDemora1.set(asd);
        }

        public void setDemanda(String asd)
        {
            demanda1.set(asd);
        }

        public void setStockInicial(String asd)
        {
            stockInicial1.set(asd);
        }

        public void setStockFinal(String asd)
        {
            stockFinal1.set(asd);
        }
         public void setCantVendida(String asd)
        {
            cantVendida1.set(asd);
        }

        public void setSemRestantes(String asd)
        {
            semanasRestantesP1.set(asd);
        }

        public void setCPedido(String asd)
        {
            cPed1.set(asd);
        }

        public void setcPedidoAcum(String asd)
        {
            acumCP1.set(asd);
        }

        public void setcMan(String asd)
        {
            cMan1.set(asd);
        }

        public void setcManAcum(String asd)
        {
            acumCMan1.set(asd);
        }
        public void setcFalt(String asd)
        {
            cFalt1.set(asd);
        }

        public void setcFaltAcum(String asd)
        {
            acumCFalt1.set(asd);
        }

        public void setCTacum(String asd)
        {
            cTAcum.set(asd);
        }

        public String getsemana()
        {
            return nroSemana1.get();
        }

        public String getrndDemanda()
        {
            return rndDemanda1.get();
        }

        public String getdemanda()
        {
            return demanda1.get();
        }

        public String getcantVendida()
        {
            return cantVendida1.get();
        }

        public String getstockFinal()
        {
            return stockFinal1.get();
        }

        public String getstockInicial()
        {
            return stockInicial1.get();
        }
        public String getrndDemora()
        {
            return rndDemora1.get();
        }

        public String getsemRestantes()
        {
            return semanasRestantesP1.get();
        }

        public String getcPedido()
        {
            return cPed1.get();
        }

        public String getcPedidoAcum()
        {
            return acumCP1.get();
        }

        public String getcMan()
        {
            return cMan1.get();
        }

        public String getcManAcum()
        {
            return acumCMan1.get();
        }
        public String getcFalt()
        {
            return cFalt1.get();
        }

        public String getcFaltAcum()
        {
            return acumCFalt1.get();
        }

        public String getcTacum()
        {
            return cTAcum.get();
        }


    }
