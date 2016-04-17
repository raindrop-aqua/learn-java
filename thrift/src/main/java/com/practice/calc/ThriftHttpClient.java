package com.practice.calc;


import com.practice.calc.thrift.Calc;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;

public class ThriftHttpClient {

    public static void main(String[] args) throws Exception {
        THttpClient transport = new THttpClient("http://localhost:8080/");
        TProtocol protocol = new TBinaryProtocol(transport);
        Calc.Client client = new Calc.Client(protocol);

        try {
            transport.open();
            int sum = client.add(100, 200);
            System.out.println(sum);
            transport.close();
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}
