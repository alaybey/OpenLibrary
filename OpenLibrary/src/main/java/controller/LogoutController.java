package controller;

import sessionutil.SessionUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class LogoutController implements IController, Serializable {


    public String logout() {
        HttpSession session = SessionUtil.getSession();
        session.invalidate();
        return "login.xhtml";
    }
}
