package com.practice.calc;

import com.practice.calc.thrift.Calc;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class Client {

    public static void main(String[] args) {
        TTransport transport;
        transport = new TSocket("localhost", 8080);
        try {
            transport.open();

            TProtocol protocol = new TBinaryProtocol(transport);
            Calc.Client client = new Calc.Client(protocol);

            perform(client);
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            transport.close();
        }
    }

    private static void perform(Calc.Client client) throws TException {
        int result = client.add(10, 30);
        System.out.println(result);
    }
}
