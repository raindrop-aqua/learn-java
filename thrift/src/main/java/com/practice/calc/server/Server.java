package com.practice.calc.server;

import com.practice.calc.thrift.Calc;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

public class Server {

    public static CalcHandler handler;
    public static Calc.Processor processor;

    public static void main(String[] args) {
        try {
            handler = new CalcHandler();
            processor = new Calc.Processor(handler);

            Runnable server = new Runnable() {
                @Override
                public void run() {
                    calcServer(processor);
                }
            };
            new Thread(server).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void calcServer(Calc.Processor processor) {
        try {
            TServerTransport transport = new TServerSocket(8080);
            TServer server = new TSimpleServer(new TServer.Args(transport).processor(processor));

            System.out.println("Starting the calc server...");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
