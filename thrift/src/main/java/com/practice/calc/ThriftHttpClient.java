package com.practice.calc;

import com.practice.calc.thrift.Calc;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;

public class ThriftHttpClient {

    public static void main(String[] args) throws Exception {

        try (THttpClient transport = new THttpClient("http://localhost:8080/")) {
            TProtocol protocol = new TBinaryProtocol(transport);
            Calc.Client client = new Calc.Client(protocol);

            transport.open();
            perform(client);

        } catch (TException e) {
            e.printStackTrace();
        }
    }

    private static void perform(Calc.Client client) throws TException {
        int result = client.add(10, 30);
        System.out.println(result);
    }
}
