/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.isti.ctt.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
/**
 *
 * @author munky
 */ 
@JsonIgnoreProperties
public class User {
 
    private String userName;
    private String password;
 
    //Important, when using JSON, used by Jackson Library
    public User() {
    }
 
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
 
    public String getUserName() {
        return userName;
    }
 
    public void setUserName(String userName) {
        this.userName = userName;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
}
