package com.example.vocabularybook.chapter8.hints;

import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.WebInfConfiguration;
import org.eclipse.jetty.webapp.WebXmlConfiguration;

public class Hint2 {
    public static void main(String[] args) throws Exception {
        WebAppContext context = new WebAppContext();
        // コンテキストルートの設定<1>
        context.setContextPath("/");
        // JSP など、外部に公開するファイルの置き場所を設定<2>
        context.setWar("src/main/java/webapp");
        // web.xml ファイルの場所を設定<3>
        context.setDescriptor("src/main/java/webapp/WEB-INF/web.xml");
        context.setConfigurations(new Configuration[]{
                new WebXmlConfiguration(),
                new AnnotationConfiguration(),
                new WebInfConfiguration()
        });
        // ポート番号を指定<4>
        Server server = new Server(8080);
        server.setHandler(context);
        server.start();
        server.join();
    }
}
