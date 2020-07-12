package filters;


import controller.LoginController;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = null;
        String path = req.getContextPath();
        String url = req.getRequestURI();


        try {
            session = req.getSession(false);
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
        }


        if (session == null || session.getAttribute("username") == null) {
            path = req.getContextPath();
            res.sendRedirect(path + "/login.xhtml");
        }else
            filterChain.doFilter(servletRequest,servletResponse);

    }


    /*
        if (session == null || !session.isLogged()) {
            if (url.contains("book") || url.contains("author") || url.contains("publisher"))
                res.sendRedirect(req.getContextPath() + "/login.xhtml");
        }else{
            if ( url.contains("logout")){
                try {
                    req.getSession().removeAttribute("session");
                } finally {
                    filterChain.doFilter(servletRequest,servletResponse);
                    res.sendRedirect(req.getContextPath() + "/login.xhtml");
                }

            }
        }

*/


    @Override
    public void destroy() {

    }
}
