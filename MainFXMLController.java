/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio7;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author YO
 */
public class MainFXMLController implements Initializable
{

    @FXML
    private TextField txtCantSemanas;
    @FXML
    private TextField txtStockInicial;
    @FXML
    private Button btnProbar;
    @FXML
    private TableView<Row> tblTabla1;
    @FXML
    private TableView<Row> tblTabla2;
    @FXML
    private TableView<Row> tblTabla3;
    @FXML
    private TableView<Row> tblTabla4;

    private Instancia instanciaActual;
    
    @FXML
    private TextField txtDesde;
    @FXML
    private TextField txtHasta;
    
    @FXML
    private TextField txtRep1;
    @FXML
    private TextField txtRep2;
    @FXML
    private TextField txtRep3;
    @FXML
    private TextField txtRep4;
    @FXML
    private Button btnReiniciar;
    @FXML
    private Label lblAoMedia;
    @FXML
    private Label lblBoDesviacion;
    @FXML
    private Button bntParametros;
    @FXML
    private Label lblAoMedia1;
    @FXML
    private Label lblAoMedia11;
    @FXML
    private ListView<?> txfSerieGenerada;
    @FXML
    private Label lblEstadistico1;
    @FXML
    private Label lblAceptaPrueba1;
    @FXML
    private Label lblEstadistico2;
    @FXML
    private Label lblAceptaPrueba2;
    @FXML
    private Label lblEstadistico3;
    @FXML
    private Label lblAceptaPrueba3;
    @FXML
    private Label lblEstadistico4;
    @FXML
    private Label lblAceptaPrueba4;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        //Presento los datos de la Tabla 1
        
        tblTabla1.setEditable(true);

        TableColumn nroSemana1 = new TableColumn("Semana");
        TableColumn stockInicial1 = new TableColumn("StockInicial");
        TableColumn rndDemanda1 = new TableColumn("RND Demanda");
        TableColumn demanda1 = new TableColumn("Demanda");
        TableColumn cantVendida1 = new TableColumn("Cantidad Vendida");
        TableColumn stockFinal1 = new TableColumn("Stock Final");
        TableColumn rndDemora1 = new TableColumn("RND Demora Pedido");
        TableColumn semanasRestantesP1 = new TableColumn("Semanas Restantes Pedido");
        TableColumn cPed1 = new TableColumn("Costo de pedido");
        TableColumn acumCP1 = new TableColumn("Costo Pedido Acum.");
        TableColumn cMan1 = new TableColumn("Costo Mantenimiento");
        TableColumn acumCMan1 = new TableColumn("Costo Mantenimiento Acum.");
        TableColumn cFalt1 = new TableColumn("Costo por Faltante");        
        TableColumn acumCFalt1 = new TableColumn("Costo por Faltante Acum.");
        TableColumn cTAcum = new TableColumn("Costo total Acum."); 
        
        nroSemana1.setCellValueFactory(new PropertyValueFactory<>("nroSemana1"));
        stockInicial1.setCellValueFactory(new PropertyValueFactory<>("stockInicial1"));
        rndDemanda1.setCellValueFactory(new PropertyValueFactory<>("rndDemanda1"));
        demanda1.setCellValueFactory(new PropertyValueFactory<>("demanda1"));
        cantVendida1.setCellValueFactory(new PropertyValueFactory<>("cantVendida1"));
        stockFinal1.setCellValueFactory(new PropertyValueFactory<>("stockFinal1"));
        rndDemora1.setCellValueFactory(new PropertyValueFactory<>("rndDemora1"));
        semanasRestantesP1.setCellValueFactory(new PropertyValueFactory<>("semanasRestantesP1"));
        cPed1.setCellValueFactory(new PropertyValueFactory<>("cPed1"));
        acumCP1.setCellValueFactory(new PropertyValueFactory<>("acumCP1"));
        cMan1.setCellValueFactory(new PropertyValueFactory<>("cMan1"));
        acumCMan1.setCellValueFactory(new PropertyValueFactory<>("acumCMan1"));
        cFalt1.setCellValueFactory(new PropertyValueFactory<>("cFalt1"));
        acumCFalt1.setCellValueFactory(new PropertyValueFactory<>("acumCFalt1"));
        cTAcum.setCellValueFactory(new PropertyValueFactory<>("cTAcum"));



        tblTabla1.getColumns().addAll(nroSemana1, stockInicial1, rndDemanda1, demanda1, cantVendida1, stockFinal1, rndDemora1, semanasRestantesP1, cPed1, acumCP1, cMan1, acumCMan1, cFalt1, acumCFalt1,cTAcum);

        tblTabla1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    @FXML
    private void handleButtonProbar(ActionEvent event)
    {
        int cantidadRepo = 20;
        tblTabla1.getItems().clear();
        //int desde = Integer.parseInt(txtDesde.getText());
        //int hasta = Integer.parseInt(txtHasta.getText());
        int pRep1 = Integer.parseInt(txtRep1.getText());
        //int pRep2 = Integer.parseInt(txtRep2.getText());
        //int pRep3 = Integer.parseInt(txtRep3.getText());
        //int pRep4 = Integer.parseInt(txtRep4.getText());
        int stockInicial1 = Integer.parseInt(txtStockInicial.getText());
        int cantidad = Integer.parseInt(txtCantSemanas.getText());
        int stockFinal =stockInicial1;
        int semanasRestantes1 = 0;
        float cPed1 = 150;
        float cMan1 = 20;
        float cFalt1 = 10;
        float acumCP1 = 0;
        float acumCMan1 =0;  
        float acumCFalt1 =0;
        float cTAcum =0;
        
          /*if (desde == 0)
        {
            desde = 1;
        }*/


        instanciaActual = new Instancia();
        instanciaActual.setStockInicial(stockInicial1);
        instanciaActual.setStockFinal(stockFinal);
        instanciaActual.setpRep(pRep1);

        System.out.println(cantidad);
        for (int i = 0; i < cantidad; i++)
        {
            int semana = i + 1;

            //if (experimento >= desde && experimento <= hasta)
            //{
                
                instanciaActual.setSemana(semana);
                instanciaActual.setStockInicial(instanciaActual.getStockFinal());
                if(instanciaActual.getSemanasRestantes() ==1)
                {
                    instanciaActual.setStockInicial(instanciaActual.getStockInicial()+cantidadRepo);
                    
                }
                if(instanciaActual.getSemanasRestantes() > 1)
                {
                    instanciaActual.setSemanasRestantes(instanciaActual.getSemanasRestantes()-1);
                }
                
                double rndDemanda = Math.random();
                instanciaActual.setRndDemanda(rndDemanda);
                instanciaActual.setDemanda(respuestaDemanda(rndDemanda));
                int restante = 0;
                if (instanciaActual.getStockInicial()< instanciaActual.getDemanda())
                {
                    restante = instanciaActual.getDemanda() - instanciaActual.getStockInicial();
                    instanciaActual.setCuantoVende(instanciaActual.getStockInicial());
                    instanciaActual.setStockFinal(0);
                }
                else
                {
                    instanciaActual.setStockFinal(instanciaActual.getStockInicial()- instanciaActual.getDemanda());
                    instanciaActual.setCuantoVende(instanciaActual.getDemanda());
                }
                
                double rndDemoraP =0;
                semanasRestantes1 =0;
                float cP =0;
                if(instanciaActual.getStockInicial() <= instanciaActual.getpRep() && instanciaActual.getSemanasRestantes() == 0)
                {
                    rndDemoraP = Math.random();
                    instanciaActual.setRndDemora(rndDemoraP);
                    semanasRestantes1 = respuestaDemoraP(rndDemoraP);
                    instanciaActual.setSemanasRestantes(semanasRestantes1);
                    cP = cPed1; 
                }
                
                instanciaActual.setcPed1(cP);
                instanciaActual.setAcumCP1(instanciaActual.getAcumCP1()+cP);
                
                instanciaActual.setcMan1(cMan1 * instanciaActual.getStockFinal());
                instanciaActual.setAcumCMan1(instanciaActual.getAcumCMan1() + instanciaActual.getcMan1());
                        
                instanciaActual.setcFalt1(cFalt1 * restante);
                instanciaActual.setAcumCFalt1(instanciaActual.getAcumCFalt1() + instanciaActual.getcFalt1());
                
                instanciaActual.setcT(instanciaActual.obtenerCostoTotal());
                
                String s_Semana = String.valueOf(instanciaActual.getSemana());
                String s_stockInicial = String.valueOf(instanciaActual.getStockInicial());
                String s_rndDemanda = String.valueOf(instanciaActual.getRndDemanda());
                String s_demanda = String.valueOf(instanciaActual.getDemanda());
                String s_cantVendida = String.valueOf(instanciaActual.getCuantoVende());
                String s_stockFinal = String.valueOf(instanciaActual.getStockFinal());
                String s_rndDemora = String.valueOf(instanciaActual.getRndDemora());
                String s_semRestantes = String.valueOf(instanciaActual.getSemanasRestantes());
                String s_cPedido = String.valueOf(instanciaActual.getcPed1());
                String s_cPedidoAcum = String.valueOf(instanciaActual.getAcumCP1());
                String s_cMan = String.valueOf(instanciaActual.getcMan1());
                String s_cManAcum = String.valueOf(instanciaActual.getAcumCMan1());
                String s_cFalt = String.valueOf(instanciaActual.getcFalt1());
                String s_cFaltAcum = String.valueOf(instanciaActual.getAcumCFalt1());
                String s_cTAcum = String.valueOf(instanciaActual.getcT());
                System.out.println(s_rndDemanda);
                Row r = new Row(s_Semana, s_stockInicial, s_rndDemanda, s_demanda, s_cantVendida, s_stockFinal, s_rndDemora, s_semRestantes, s_cPedido, s_cPedidoAcum, s_cMan, s_cManAcum, s_cFalt, s_cFaltAcum, s_cTAcum);
                tblTabla1.getItems().add(r);
        }
                
                /*
                double rndCompra = Math.random();
                instanciaActual.setRndCompraProducto(rndCompra);

                String resp = respuestaCompraSI(rndCompra);
                instanciaActual.setComprarProducto(resp);

                if ("Definitivamente si".equals(resp))
                {
                    acumuladorCompras++;
                    instanciaActual.setSumatoriaCompras(acumuladorCompras);

                }

                String s_exp = String.valueOf(instanciaActual.getExperimento());
                String s_rndRec = String.valueOf(instanciaActual.getRndRecuerdaMensaje());
                String s_rndComp = String.valueOf(instanciaActual.getRndCompraProducto());
                String s_sum = String.valueOf(instanciaActual.getSumatoriaCompras());
                Row r = new Row(s_exp, s_rndRec, instanciaActual.getRecuerdaMensaje(), s_rndComp, instanciaActual.getComprarProducto(), s_sum);
                tblMontecarlo.getItems().add(r);

            //} else
            {
                double rndRecuerda = Math.random();
                String res = respuestaRecuerda(rndRecuerda);

                double rndCompra = Math.random();
                if ("SI".equals(res))
                {
                    if ("Definitivamente si".equals(respuestaCompraSI(rndCompra)))
                    {
                        acumuladorCompras++;
                    }
                } else
                {
                    if ("Definitivamente si".equals(respuestaCompraNO(rndCompra)))
                    {
                        acumuladorCompras++;
                    }
                }
            }
        }
        double probabilidadCompra = (double)instanciaActual.getSumatoriaCompras()/(double)cantidad;
        txtProbabilidad.setText(String.valueOf(probabilidadCompra));*/
        

    }
    @FXML
    private void handleButtonReiniciar(ActionEvent event)       
    {
        
    }
    
    @FXML
    private void handleButtonParametros(ActionEvent event)
    {
        
    }

    private int respuestaDemanda(double rnd_demanda)
    {
        if (rnd_demanda < 0.06)
        {
            return 4;
        }
        else if (rnd_demanda < 0.16)
        {
            return 5;
        }
        else if (rnd_demanda < 0.36)
        {
            return 6;
        }
        else if (rnd_demanda < 0.61)
        {
            return 7;
        }
        else if (rnd_demanda < 0.91)
        {
            return 8;
        }
        else return 9;
    }

    private int respuestaDemoraP(double rnd_demoraP)
    {
        if (rnd_demoraP < 0.4)
        {
            return 2;
        }
        else if (rnd_demoraP < 0.72)
        {
            return 3;
        }
        else
            return 4;
    }
    


    public static class Row
    {

        private final SimpleStringProperty semana;
        private final SimpleStringProperty stockInicial;
        private final SimpleStringProperty rndDemanda;
        private final SimpleStringProperty demanda;
        private final SimpleStringProperty cantVendida;
        private final SimpleStringProperty stockFinal;
        private final SimpleStringProperty rndDemora;
        private final SimpleStringProperty semRestantes;
        private final SimpleStringProperty cPedido;
        private final SimpleStringProperty cPedidoAcum;
        private final SimpleStringProperty cMan;
        private final SimpleStringProperty cManAcum;
        private final SimpleStringProperty cFalt;
        private final SimpleStringProperty cFaltAcum;
        private final SimpleStringProperty cTacum;


        private Row(String s_Semana,String s_stockInicial,String s_rndDemanda,String s_demanda,String s_cantVendida,String s_stockFinal,String s_rndDemora,String s_semRestantes,String s_cPedido,String s_cPedidoAcum,String s_cMan,String s_cManAcum,String s_cFalt,String s_cFaltAcum,String s_cTAcum)
        {
            this.semana = new SimpleStringProperty(s_Semana);
            this.stockInicial = new SimpleStringProperty(s_stockInicial);
            this.rndDemanda = new SimpleStringProperty(s_rndDemanda);
            this.demanda = new SimpleStringProperty(s_demanda);
            this.cantVendida = new SimpleStringProperty(s_cantVendida);
            this.stockFinal = new SimpleStringProperty(s_stockFinal);
            this.rndDemora = new SimpleStringProperty(s_rndDemora);
            this.semRestantes = new SimpleStringProperty(s_semRestantes);
            this.cPedido = new SimpleStringProperty(s_cPedido);
            this.cPedidoAcum = new SimpleStringProperty(s_cPedidoAcum);
            this.cMan = new SimpleStringProperty(s_cMan);
            this.cManAcum = new SimpleStringProperty(s_cManAcum);
            this.cFalt = new SimpleStringProperty(s_cFalt);
            this.cFaltAcum = new SimpleStringProperty(s_cFaltAcum);
            this.cTacum = new SimpleStringProperty(s_cTAcum);
        }

        
        public void setSemana(String asd)
        {
            semana.set(asd);
        }

        public void setRndDemanda(String asd)
        {
            rndDemanda.set(asd);
        }

        public void setRndDemora(String asd)
        {
            rndDemora.set(asd);
        }

        public void setDemanda(String asd)
        {
            demanda.set(asd);
        }

        public void setStockInicial(String asd)
        {
            stockInicial.set(asd);
        }

        public void setStockFinal(String asd)
        {
            stockFinal.set(asd);
        }
         public void setCantVendida(String asd)
        {
            cantVendida.set(asd);
        }

        public void setSemRestantes(String asd)
        {
            semRestantes.set(asd);
        }

        public void setCPedido(String asd)
        {
            cPedido.set(asd);
        }

        public void setcPedidoAcum(String asd)
        {
            cPedidoAcum.set(asd);
        }

        public void setcMan(String asd)
        {
            cMan.set(asd);
        }

        public void setcManAcum(String asd)
        {
            cManAcum.set(asd);
        }
        public void setcFalt(String asd)
        {
            cFalt.set(asd);
        }

        public void setcFaltAcum(String asd)
        {
            cFaltAcum.set(asd);
        }

        public void setCTacum(String asd)
        {
            cTacum.set(asd);
        }

        public String getsemana()
        {
            return semana.get();
        }

        public String getrndDemanda()
        {
            return rndDemanda.get();
        }

        public String getdemanda()
        {
            return demanda.get();
        }

        public String getcantVendida()
        {
            return cantVendida.get();
        }

        public String getstockFinal()
        {
            return stockFinal.get();
        }

        public String getstockInicial()
        {
            return stockInicial.get();
        }
        public String getrndDemora()
        {
            return rndDemora.get();
        }

        public String getsemRestantes()
        {
            return semRestantes.get();
        }

        public String getcPedido()
        {
            return cPedido.get();
        }

        public String getcPedidoAcum()
        {
            return cPedidoAcum.get();
        }

        public String getcMan()
        {
            return cMan.get();
        }

        public String getcManAcum()
        {
            return cManAcum.get();
        }
        public String getcFalt()
        {
            return cFalt.get();
        }

        public String getcFaltAcum()
        {
            return cFaltAcum.get();
        }

        public String getcTacum()
        {
            return cTacum.get();
        }


    }

}
