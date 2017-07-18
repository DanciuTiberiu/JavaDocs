package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.awt.SystemColor.text;

/**
 * Created by Tiberiu.Danciu on 7/18/2017.
 */
public class ZeroToHeroServlet extends HttpServlet {
    private String  handleRequest(HttpServletRequest req){
        String response = "Hello " + req.getParameter("firstName") + " " + req.getParameter("lastName") + "! Enjoy Zero To Hero!!!";

        return  response;

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        ZeroToHeroServlet n = new ZeroToHeroServlet();
        resp.getWriter().write(n.handleRequest(req));
    }
}
