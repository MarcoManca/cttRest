package it.cnr.isti.xmlUtils;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import it.cnr.isti.giove.ctt.COOPConcurTaskTrees;
import it.cnr.isti.giove.ctt.Task;
import it.cnr.isti.giove.ctt.TaskModel;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author Marco
 */
public class XmlManager {

    private DocumentBuilderFactory dbf;
    private JAXBContext jaxbContext;
    private Unmarshaller unmarshaller;
    private Marshaller marshaller;
    DocumentBuilder db;

    public XmlManager() {
        instantiateMarshaller();
    }

    private void instantiateMarshaller() {
        dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        try {
            db = dbf.newDocumentBuilder();
            jaxbContext = JAXBContext.newInstance("it.cnr.isti.giove.ctt");
            unmarshaller = jaxbContext.createUnmarshaller();
            marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);            
        } catch (JAXBException ex) {
            Logger.getLogger(XmlManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException pEx) {
            Logger.getLogger(XmlManager.class.getName()).log(Level.SEVERE, null, pEx);
        }
    }

    public TaskModel unmarshallTaskModel(File f) {
        Document doc;
        JAXBElement<TaskModel> taskObj;
        try {
            doc = db.parse(f);
            taskObj = unmarshaller.unmarshal(doc, TaskModel.class);
            return taskObj.getValue();
        } catch (JAXBException ex) {
            Logger.getLogger(XmlManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (SAXException sEx) {
            Logger.getLogger(XmlManager.class.getName()).log(Level.SEVERE, null, sEx);
            return null;
        } catch (IOException ioEx) {
            Logger.getLogger(XmlManager.class.getName()).log(Level.SEVERE, null, ioEx);
            return null;
        }
    }

    public COOPConcurTaskTrees unmarshallTaskModelCoop(File f) {
        Document doc;
        JAXBElement<COOPConcurTaskTrees> taskObj;
        try {
            doc = db.parse(f);
            taskObj = unmarshaller.unmarshal(doc, COOPConcurTaskTrees.class);
            return taskObj.getValue();
        } catch (JAXBException ex) {
            Logger.getLogger(XmlManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (SAXException sEx) {
            Logger.getLogger(XmlManager.class.getName()).log(Level.SEVERE, null, sEx);
            return null;
        } catch (IOException ioEx) {
            Logger.getLogger(XmlManager.class.getName()).log(Level.SEVERE, null, ioEx);
            return null;
        }
    }
    
    
    public void writeToFile(String filePath, String json) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
            out.write(json);
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(XmlManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean saveTM(TaskModel tm, File f) {
        try {                        
            this.marshaller.marshal(tm, f);
            return true;
        } catch (JAXBException ex) {
            ex.printStackTrace();
            System.out.println("exception "+ex.getLocalizedMessage());
            return false;
        }        
    }
}
