package com.example.vocabularybook.chapter8;

import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.WebInfConfiguration;
import org.eclipse.jetty.webapp.WebXmlConfiguration;

public class MainServer {
    public static void main(String[] args) throws Exception {
        WebAppContext context = new WebAppContext();
        context.setContextPath("/");
        context.setWar("src/main/java/webapp");
        context.setDescriptor("src/main/java/webapp/WEB-INF/web.xml");
        context.setConfigurations(new Configuration[]{
                new WebXmlConfiguration(),
                new AnnotationConfiguration(),
                new WebInfConfiguration()
        });
        Server server = new Server(8080);
        server.setHandler(context);
        server.start();
        server.join();
    }
}
