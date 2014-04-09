/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.isti.ctt.model.response;
/**
 *
 * @author Marco
 */
public class SaveResponse {

    private ResponseStatus status;
    private String response;  
    private String error;

    public SaveResponse() {
        status = ResponseStatus.OK;        
        error = "No Error";
    }
    
    public ResponseStatus getStatus() {
        return status;
    }

    public String getResponse() {
        return response;
    }

    public String getError() {
        return error;
    }

    public void setResponse(String response) {
        this.response = response;
    }
        
    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public void setError(String error) {
        this.error = error;
    }
}
