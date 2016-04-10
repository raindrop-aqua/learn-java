package com.practice.p01;

import com.practice.pb.AddressBookProto.Person;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteAndRead {

    public static void main(String[] args) {

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
// or
//        Person john = Person.newBuilder()
//                .setId(1234)
//                .setName("鈴木 太郎")
//                .setEmail("john@practice.com")
//                .addPhone(
//                        Person.PhoneNumber.newBuilder()
//                                .setNumber("555-1234")
//                                .setType(Person.PhoneType.HOME))
//                .build();

        try {
            File f = new File("john.dat");

            FileOutputStream fos = new FileOutputStream(f);
            john.writeTo(fos);
            fos.close();

            Person j = Person.parseFrom(new FileInputStream(f));
            System.out.println(j);

            f.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
