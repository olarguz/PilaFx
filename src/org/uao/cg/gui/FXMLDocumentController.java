package org.uao.cg.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.uao.cg.data.core.OperacionesPilas;
import org.uao.cg.data.core.Pila;
import org.uao.cg.data.Valor;

/**
 *
 * @author oarcila
 */
public class FXMLDocumentController implements Initializable
{

    @FXML
    private MenuItem bSalir;
    @FXML
    private MenuItem bAgregar;
    @FXML
    private WebView web;

    private WebEngine engine;
    private Pila<Valor> p;
    private int contador;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        engine = web.getEngine();

        contador = 0;
        p = new Pila<>();

        engine.loadContent(Tools.convertirPilaAHtml(p));
    }

    @FXML
    private void handleButtonSalir(ActionEvent event)
    {
        Platform.exit();
    }
    
    @FXML
    private void handleButtonAgregar(ActionEvent event)
    {
        String texto = " --- " + contador + " --- ";
        contador++;
        p.apilar(new Valor(texto));
        String html = Tools.convertirPilaAHtml(p);
        engine.loadContent(html);
    }

    @FXML
    private void handleButtonRetirar(ActionEvent event)
    {
        if ( !p.estaVacio())
        {
            Valor e = p.desapilar();
            engine.loadContent(Tools.convertirPilaAHtml(p,e.getTexto()));
        }
        else
        {
            engine.loadContent(Tools.convertirPilaAHtml(p));
        }
    }

}
