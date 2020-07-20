/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio7;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;


/**
 * FXML Controller class
 *
 * @author 62684
 */
public class MainFXMLController implements Initializable {

    @FXML
    private TabPane tpPaneles;

    @FXML
    private Tab tabParametros;

    @FXML
    private Button btnProbar;

    @FXML
    private TextField txtCantSemanas;

    @FXML
    private TextField txtStockInicial;

    @FXML
    private Button btnReiniciar;

    @FXML
    private Label lblAoMedia;

    @FXML
    private Label lblBoDesviacion;

    @FXML
    private TextField txtRep1;

    @FXML
    private TextField txtRep2;

    @FXML
    private TextField txtRep3;

    @FXML
    private TextField txtRep4;

    @FXML
    private Button bntParametros;

    @FXML
    private Label lblAoMedia1;

    @FXML
    private Label lblAoMedia11;

    @FXML
    private TextField txtDesde;

    @FXML
    private TextField txtHasta;

    @FXML
    private ListView<?> txfSerieGenerada;

    @FXML
    private Tab tabEstrategia1;

    @FXML
    private TableView<Row> tblTabla1;

    @FXML
    private Label lblEstadistico1;

    @FXML
    private Label lblAceptaPrueba1;

    @FXML
    private Tab tabEstrategia2;

    @FXML
    private TableView<Row> tblTabla2;

    @FXML
    private Label lblEstadistico2;

    @FXML
    private Label lblAceptaPrueba2;

    @FXML
    private Tab tabEstrategia3;

    @FXML
    private TableView<Row> tblTabla3;

    @FXML
    private Label lblEstadistico3;

    @FXML
    private Label lblAceptaPrueba3;

    @FXML
    private Tab tabEstrategia4;

    @FXML
    private TableView<Row> tblTabla4;

    @FXML
    private Label lblEstadistico4;

    @FXML
    private Label lblAceptaPrueba4;
    
    private Instancia instanciaActual;
    private final ObservableList<Row> data = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //Presento los datos de la Tabla 1
        inicializarTabla(tblTabla1);
        inicializarTabla(tblTabla2);
        inicializarTabla(tblTabla3);
        inicializarTabla(tblTabla4);

        
        
    }    

    @FXML
    private void handleButtonProbar(ActionEvent event) {
        int cantidadRepo = 20;
        tblTabla1.getItems().clear();
        tblTabla2.getItems().clear();
        tblTabla3.getItems().clear();
        tblTabla4.getItems().clear();
        //int desde = Integer.parseInt(txtDesde.getText());
        //int hasta = Integer.parseInt(txtHasta.getText());
        int pRep1 = Integer.parseInt(txtRep1.getText());
        //int pRep2 = Integer.parseInt(txtRep2.getText());
        //int pRep3 = Integer.parseInt(txtRep3.getText());
        //int pRep4 = Integer.parseInt(txtRep4.getText());
        int stockInicial = Integer.parseInt(txtStockInicial.getText());
        int cantidad = Integer.parseInt(txtCantSemanas.getText());
        int stockFinal =stockInicial;
        int semanasRestantes1 = 0;
        float cPed = 150;
        float cMan = 20;
        float cFalt = 10;

        
          /*if (desde == 0)
        {
            desde = 1;
        }*/

        instanciaActual = new Instancia();
        instanciaActual.setStockInicial(stockInicial);
        instanciaActual.setStockFinal(stockFinal);
        instanciaActual.setpRep(pRep1);

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
                double rndDemoraP=0;
                boolean pedido = false;
                semanasRestantes1 =0;
                float cP =0;
                if(instanciaActual.getStockInicial() <= instanciaActual.getpRep() && instanciaActual.getSemanasRestantes() == 0)
                {
                    pedido = true;
                    instanciaActual.setRndDemora(Math.random());
                    semanasRestantes1 = respuestaDemoraP(rndDemoraP);
                    instanciaActual.setSemanasRestantes(semanasRestantes1);
                    cP = cPed; 
                }
                
                instanciaActual.setcPed1(cP);
                instanciaActual.setAcumCP1(instanciaActual.getAcumCP1()+cP);
                
                instanciaActual.setcMan1(cMan * instanciaActual.getStockFinal());
                instanciaActual.setAcumCMan1(instanciaActual.getAcumCMan1() + instanciaActual.getcMan1());
                        
                instanciaActual.setcFalt1(cFalt * restante);
                instanciaActual.setAcumCFalt1(instanciaActual.getAcumCFalt1() + instanciaActual.getcFalt1());
                
                instanciaActual.setcT(instanciaActual.obtenerCostoTotal());
                
                agregarFila(pedido);
                             
        }
                tblTabla1.getItems().addAll(data);
                tblTabla2.setItems(data);
                tblTabla3.getItems().addAll(data);
                tblTabla4.getItems().addAll(data);
                
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
    private void handleButtonReiniciar(ActionEvent event) {
        
    }

    @FXML
    private void handleButtonParametros(ActionEvent event) {
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

    private void inicializarTabla(TableView<Row> tblTabla) 
    {
        tblTabla.setEditable(true);
        
                

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
        
        nroSemana1.setCellValueFactory(new PropertyValueFactory("nroSemana1"));
        nroSemana1.prefWidthProperty().bind(tblTabla.widthProperty().divide(4));
        stockInicial1.setCellValueFactory(new PropertyValueFactory("stockInicial1"));
        stockInicial1.prefWidthProperty().bind(tblTabla.widthProperty().divide(4));
        rndDemanda1.setCellValueFactory(new PropertyValueFactory("rndDemanda1"));
        rndDemanda1.prefWidthProperty().bind(tblTabla.widthProperty().divide(4));
        demanda1.setCellValueFactory(new PropertyValueFactory("demanda1"));
        demanda1.prefWidthProperty().bind(tblTabla.widthProperty().divide(4));
        cantVendida1.setCellValueFactory(new PropertyValueFactory("cantVendida1"));
        cantVendida1.prefWidthProperty().bind(tblTabla.widthProperty().divide(4));
        stockFinal1.setCellValueFactory(new PropertyValueFactory("stockFinal1"));
        stockFinal1.prefWidthProperty().bind(tblTabla.widthProperty().divide(4));
        rndDemora1.setCellValueFactory(new PropertyValueFactory("rndDemora1"));
        rndDemora1.prefWidthProperty().bind(tblTabla.widthProperty().divide(4));
        semanasRestantesP1.setCellValueFactory(new PropertyValueFactory("semanasRestantesP1"));
        semanasRestantesP1.prefWidthProperty().bind(tblTabla.widthProperty().divide(4));
        cPed1.setCellValueFactory(new PropertyValueFactory("cPed1"));
        cPed1.prefWidthProperty().bind(tblTabla.widthProperty().divide(4));
        acumCP1.setCellValueFactory(new PropertyValueFactory("acumCP1"));
        acumCP1.prefWidthProperty().bind(tblTabla.widthProperty().divide(4));
        cMan1.setCellValueFactory(new PropertyValueFactory("cMan1"));
        cMan1.prefWidthProperty().bind(tblTabla.widthProperty().divide(4));
        acumCMan1.setCellValueFactory(new PropertyValueFactory("acumCMan1"));
        acumCMan1.prefWidthProperty().bind(tblTabla.widthProperty().divide(4));
        cFalt1.setCellValueFactory(new PropertyValueFactory("cFalt1"));
        cFalt1.prefWidthProperty().bind(tblTabla.widthProperty().divide(4));
        acumCFalt1.setCellValueFactory(new PropertyValueFactory("acumCFalt1"));
        acumCFalt1.prefWidthProperty().bind(tblTabla.widthProperty().divide(4));
        cTAcum.setCellValueFactory(new PropertyValueFactory("cTAcum"));
        cTAcum.prefWidthProperty().bind(tblTabla.widthProperty().divide(4));



        tblTabla.getColumns().addAll(nroSemana1, stockInicial1, rndDemanda1, demanda1, cantVendida1, stockFinal1, rndDemora1, semanasRestantesP1, cPed1, acumCP1, cMan1, acumCMan1, cFalt1, acumCFalt1,cTAcum);
        tblTabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    private void agregarFila(boolean pedido) 
    {
        
        String nroSemana1 = String.valueOf(instanciaActual.getSemana());
        String stockInicial1 = String.valueOf(instanciaActual.getStockInicial());
        String rndDemanda1 = String.valueOf(instanciaActual.getRndDemanda());
        String demanda1 = String.valueOf(instanciaActual.getDemanda());
        String cantVendida1 = String.valueOf(instanciaActual.getCuantoVende());
        String stockFinal1 = String.valueOf(instanciaActual.getStockFinal());
        String rndDemora1;
        if (pedido)
        {     rndDemora1 = String.valueOf(instanciaActual.getRndDemora());}
        else    {rndDemora1 = "-";}
        
        String semanasRestantesP1;
        if(pedido || instanciaActual.getSemanasRestantes()!=0)
        {   semanasRestantesP1= String.valueOf(instanciaActual.getSemanasRestantes());}
        else    {semanasRestantesP1 = "-";}
        
        String cPed1 = String.valueOf(instanciaActual.getcPed1());
        String acumCP1 = String.valueOf(instanciaActual.getAcumCP1());
        String cMan1 = String.valueOf(instanciaActual.getcMan1());
        String acumCMan1 = String.valueOf(instanciaActual.getAcumCMan1());
        String cFalt1 = String.valueOf(instanciaActual.getcFalt1());
        String acumCFalt1 = String.valueOf(instanciaActual.getAcumCFalt1());
        String cTAcum = String.valueOf(instanciaActual.getcT());
        System.out.println(nroSemana1 + "  " + stockInicial1 + "  " + rndDemanda1 + "  " + demanda1 + "  " + cantVendida1 + "  " + stockFinal1 + "  " + rndDemora1 + "  " + semanasRestantesP1 + "  " + cPed1 + "  " + acumCP1 + "  " + cMan1 + "  " + acumCMan1 + "  " + cFalt1 + "  " + acumCFalt1 + "  " + cTAcum);

        Row r = new Row(nroSemana1, stockInicial1, rndDemanda1, demanda1, cantVendida1, stockFinal1, rndDemora1, semanasRestantesP1, cPed1, acumCP1, cMan1, acumCMan1, cFalt1, acumCFalt1, cTAcum);
        data.add(r);
    }
    
    

}

    
    
    

