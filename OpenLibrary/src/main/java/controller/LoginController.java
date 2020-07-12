package controller;

import service.LoginService;
import service.LoginServiceImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.annotation.WebServlet;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class LoginController implements IController, Serializable {

    LoginService loginService = new LoginServiceImpl();

    private String username;
    private String password;

    private boolean isLogged = false;

    public String login() {
        this.isLogged = loginService.login(this.username, this.password);
        if (this.isLogged) {
            return "index?faces-redirect=true";
        }
        return "#";
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

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }
}
