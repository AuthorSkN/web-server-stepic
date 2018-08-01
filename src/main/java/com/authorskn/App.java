package com.authorskn;

import com.authorskn.servlets.AllRequestServletsServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.ServletContext;

public class App {

    private static int PORT = 8080;

    public static void main(String[] args) throws Exception {
        AllRequestServletsServlet allRequestServletsServlet = new AllRequestServletsServlet();

        Server server = new Server(PORT);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(allRequestServletsServlet), "/*");
        server.setHandler(context);

        server.start();
        server.join();
    }

}
