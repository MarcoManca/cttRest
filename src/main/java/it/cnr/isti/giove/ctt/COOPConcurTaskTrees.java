//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.09.17 at 01:02:19 PM CEST 
//


package it.cnr.isti.giove.ctt;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.codehaus.jackson.map.annotate.JsonDeserialize;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://giove.isti.cnr.it/cttcoop}TaskModelCOOP"/>
 *         &lt;element ref="{http://giove.isti.cnr.it/ctt}TaskModel" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "taskModelCOOP",
    "taskModel"
})
@XmlRootElement(name = "COOPConcurTaskTrees", namespace = "http://giove.isti.cnr.it/cttcoop")
public class COOPConcurTaskTrees {

    @XmlElement(name = "TaskModelCOOP", namespace = "http://giove.isti.cnr.it/cttcoop", required = true)
    protected TaskModelCOOP taskModelCOOP;
    @JsonDeserialize(contentAs=TaskModel.class)
    @XmlElement(name = "TaskModel", required = true)
    protected List<TaskModel> taskModel;

    /**
     * Gets the value of the taskModelCOOP property.
     * 
     * @return
     *     possible object is
     *     {@link TaskModelCOOP }
     *     
     */
    public TaskModelCOOP getTaskModelCOOP() {
        return taskModelCOOP;
    }

    /**
     * Sets the value of the taskModelCOOP property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskModelCOOP }
     *     
     */
    public void setTaskModelCOOP(TaskModelCOOP value) {
        this.taskModelCOOP = value;
    }

    /**
     * Gets the value of the taskModel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taskModel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaskModel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaskModel }
     * 
     * 
     */
    public List<TaskModel> getTaskModel() {
        if (taskModel == null) {
            taskModel = new ArrayList<TaskModel>();
        }
        return this.taskModel;
    }

}
