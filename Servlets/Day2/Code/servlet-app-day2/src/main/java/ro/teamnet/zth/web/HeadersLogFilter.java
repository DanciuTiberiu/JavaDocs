package ro.teamnet.zth.web;

import ro.teamnet.zth.file.LogFileWriter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Tiberiu.Danciu on 7/19/2017.
 */
public class HeadersLogFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {


        LogFileWriter log = new LogFileWriter();
        log.logHeader("Head", "Trust");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
