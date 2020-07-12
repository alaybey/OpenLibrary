package controller;

import service.RegisterService;
import service.RegisterServiceImpl;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class RegisterController implements IController, Serializable {

    RegisterService registerService = new RegisterServiceImpl();

    private String username;
    private String password;

    public String registerMe(){
        if(registerService.registerUser(this.username,this.username)){
            return "register";
        }
        return "login";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
