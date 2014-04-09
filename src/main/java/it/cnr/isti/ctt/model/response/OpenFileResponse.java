/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.isti.ctt.model.response;

import it.cnr.isti.giove.ctt.TaskModel;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Marco
 */
public class OpenFileResponse {

    private ResponseStatus status;
    private TaskModel tasks;   
    private String error;

    public OpenFileResponse() {
        status = ResponseStatus.OK;        
        error = "No Error";
    }
    
    public ResponseStatus getStatus() {
        return status;
    }

    public TaskModel getTasks() {
        return tasks;
    }

    public String getError() {
        return error;
    }
    
    public void setTasks(TaskModel tasks) {
        this.tasks = tasks;
    }
    
    public void setStatus(ResponseStatus status) {
        this.status = status;
    }
    
    public void setError(String error) {
        this.error = error;
    }
}
