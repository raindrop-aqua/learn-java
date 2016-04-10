package com.practice.p02;


import com.practice.pb.AddressBookProto.Person;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start();
    }

    /**
     * <a href="http://devlights.hatenablog.com/entry/20130704/p1">see</a>
     * @throws IOException
     */
    public void start() throws IOException {

        try (ServerSocket server = new ServerSocket(9999)) {

            System.out.println("server started...");

            try (Socket client = server.accept()) {

                System.out.println("got client connection...");

                try (InputStream is = client.getInputStream()) {

                    while (is.available() == 0) {
                        //
                        // 利用可能になるまで待機
                        //
                    }

                    byte[] bytes = new byte[is.available()];
                    is.read(bytes);

                    Person p = Person.parseFrom(bytes);
                    System.out.println(p);
                }
            }
        }
    }
}
