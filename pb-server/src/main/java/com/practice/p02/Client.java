package com.practice.p02;

import com.practice.pb.AddressBookProto.Person;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.send();
    }

    public void send() throws IOException {

        Person.Builder builder = Person.newBuilder();
        Person john = builder
                .setId(1234)
                .setName("鈴木 太郎")
                .setEmail("john@practice.com")
                .addPhone(
                        Person.PhoneNumber.newBuilder()
                                .setNumber("555-1234")
                                .setType(Person.PhoneType.HOME))
                .build();

        Socket socket = new Socket("localhost", 9999);
        OutputStream fos = socket.getOutputStream();
        john.writeTo(fos);
        fos.close();
    }
}
