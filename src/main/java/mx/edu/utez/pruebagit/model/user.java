package mx.edu.utez.pruebagit.model;

import java.io.Serializable;

public class user implements Serializable {
    private String user_name;
    private String pass;
    private String email;
    private String cody;


public user() {
    }

    public String getUser_name() {
    return user_name;
    }
    public void setUser_name(String user_name) {
    this.user_name = user_name;
    }
    public String getPass() {
    return pass;
    }
    public void setPass(String pass) {
    this.pass = pass;
    }
    public String getEmail() {
    return email;
    }
    public void setEmail(String email) {
    this.email = email;
    }
    public String getCody() {
    return cody;
    }
    public void setCody(String cody) {
    this.cody = cody;
    }

}

