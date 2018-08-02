package com.authorskn;

import com.authorskn.servlets.AllRequestServletsServlet;
import com.authorskn.servlets.TestMirrorServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.ServletContext;

public class App {

    private static int PORT = 8088;

    public static void main(String[] args) throws Exception {
        AllRequestServletsServlet allRequestServletsServlet = new AllRequestServletsServlet();
        TestMirrorServlet testMirrorServlet = new TestMirrorServlet();

        Server server = new Server(PORT);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(allRequestServletsServlet), "/*");
        context.addServlet(new ServletHolder(testMirrorServlet), "/mirror");
        server.setHandler(context);

        server.start();
        java.util.logging.Logger.getGlobal().info("Server started");
        server.join();
    }

}
