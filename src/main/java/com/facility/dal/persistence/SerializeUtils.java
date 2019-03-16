package com.facility.dal.persistence;

import com.facility.model.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeUtils {

    public static void saveFacility(FacilityObject facilityObject) {
        try {
            //save object to file
            FileOutputStream fileOut = new FileOutputStream("save.db");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(facilityObject);
            objectOut.close();
            System.out.println("Object successfully processed to file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static FacilityObject loadFacility() {
        try {
            // reading object from file
            FileInputStream fis = new FileInputStream("save.db");
            ObjectInputStream ois = new ObjectInputStream(fis);
            FacilityObject result = (FacilityObject) ois.readObject();
            ois.close();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
