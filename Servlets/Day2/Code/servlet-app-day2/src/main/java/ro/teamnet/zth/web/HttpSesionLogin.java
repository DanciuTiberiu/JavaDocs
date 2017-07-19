package ro.teamnet.zth.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by Tiberiu.Danciu on 7/19/2017.
 */
public class HttpSesionLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();

        Cookie[] cookie = req.getCookies();
        if (username.equals("admin") && password.equals("admin")){

            resp.getWriter().write("Welcome back " + username + " !!");

            for (Cookie cok: cookie) {
                resp.getWriter().write(String.valueOf(cok + "\n"));
            }

            resp.getWriter().write("SesionId is: " + session.getId());
        } else {
            req.getSession().setAttribute("user", username);
            req.getSession().setAttribute("session", session );
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/loginFail.jsp");
            requestDispatcher.forward(req, resp);

        }

    }
}
