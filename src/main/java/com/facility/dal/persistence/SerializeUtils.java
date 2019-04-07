package com.facility.dal.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeUtils {

    public static void save(Object object) {
        try {
            //save object to file
            FileOutputStream fileOut = new FileOutputStream("save.db");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(object);
            objectOut.close();
            System.out.println("Object successfully processed to file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Object load() {
        try {
            // read object from file
            FileInputStream fis = new FileInputStream("save.db");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object result = ois.readObject();
            ois.close();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
