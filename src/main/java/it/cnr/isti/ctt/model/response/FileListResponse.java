/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.isti.ctt.model.response;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Marco
 */
public class FileListResponse {

    private ResponseStatus status;    
    private List<String> fileList;
    private String error;

    public FileListResponse() {
        status = ResponseStatus.OK;
        fileList = new LinkedList<String>();
        error = "No Error";
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public List<String> getFileList() {
        return fileList;
    }

    public String getError() {
        return error;
    }
    
    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public void setFileList(List<String> fileList) {
        this.fileList = fileList;
    }

    public void setError(String error) {
        this.error = error;
    }
}
