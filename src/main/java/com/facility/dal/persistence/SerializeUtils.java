package com.facility.dal.persistence;

import com.facility.model.Facility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeUtils {

    public static void saveFacility(Facility facility) {
        try {
            //save object to file
            FileOutputStream fileOut = new FileOutputStream("save.db");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(facility);
            objectOut.close();
            System.out.println("Object successfully processed to file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Facility loadFacility() {
        try {
            // read object from file
            FileInputStream fis = new FileInputStream("save.db");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Facility result = (Facility) ois.readObject();
            ois.close();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
