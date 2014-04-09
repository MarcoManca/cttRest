/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.isti.ctt.model.request;

import it.cnr.isti.giove.ctt.TaskModel;

/**
 *
 * @author Marco
 */
public class SaveRequest {
    private SaveType type;
    private String filename;
    private TaskModel task;
        
    public SaveType getType() {
        return type;
    }

    public void setType(SaveType type) {
        this.type = type;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public TaskModel getTask() {
        return task;
    }

    public void setTask(TaskModel task) {
        this.task = task;
    }    
}
