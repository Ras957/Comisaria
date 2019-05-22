/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author dj_ra
 */
public class CargarXML {
    

    public static void ConexionXML(Conexion con, String archivo) {
        File file=new File(archivo);
        DocumentBuilder dBuilder = null;
        try {
            dBuilder = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(CargarXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        Document doc = null;
        try {
            doc = dBuilder.parse(file);
        } catch (SAXException ex) {
            Logger.getLogger(CargarXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CargarXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (doc.hasChildNodes()) {
            NodeList nodeList = doc
                    .getDocumentElement()
                    .getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    switch (node.getNodeName()) {
                        case "host":
                            con.setHost(node.getTextContent());
                            break;
                        case "nombre":
                            con.setBbdd(node.getTextContent());
                            break;
                        case "login":
                            con.setLogin(node.getTextContent());
                            break;
                        case "password":
                            con.setPassword(node.getTextContent());
                            break;
                    }
                }
            }
        }
    }
    
}



