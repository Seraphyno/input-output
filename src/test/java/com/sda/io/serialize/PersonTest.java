package com.sda.io.serialize;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertNotNull;

public class PersonTest {

    private Person person = new Person("Dan", "Popescu");

    @Test
    public void testWrite() {
        File file = new File(PersonTest.class.getClassLoader()
                .getResource("person.txt").getPath());
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream =
                     new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Person readPerson;
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream =
                     new ObjectInputStream(fileInputStream)) {
            readPerson = (Person) objectInputStream.readObject();
            assertNotNull(readPerson);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}