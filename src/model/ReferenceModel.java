package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReferenceModel {
    public static void writingDepartment(String newDepartment) {
        String filePath = "userDetails\\departments.txt";
        BufferedWriter bw = null;
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                file.createNewFile();
                new IOException("File is not found!");
            }

            FileWriter fw = new FileWriter(file, true);

            bw = new BufferedWriter(fw);
            bw.write(newDepartment);
            bw.newLine();

        } catch (IOException ioe) {
            System.out.println(ioe);
            ioe.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    public static void writingSpecializedArea(String newArea) {
        String filePath = "userDetails\\specializedArea.txt";
        BufferedWriter bw = null;
        try {

            File file = new File(filePath);

            if (!file.exists()) {
                file.createNewFile();
                new IOException("File is not found!");
            }

            FileWriter fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            bw.write(newArea);
            bw.newLine();

        } catch (IOException ioe) {
            System.out.println(ioe);
            ioe.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    public static void deleteRefRecord(int referenceeState, String selectedItem) throws FileNotFoundException {
        String filePath = "userDetails\\";
        if (referenceeState == 1) {
            filePath = "userDetails\\departments.txt";
        } else if (referenceeState == 2) {
            filePath = "userDetails\\specializedArea.txt";

        }
        File file = new File(filePath);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            Object[] tableLines = br.lines().toArray();
            String[] stringArray = Arrays.copyOf(tableLines, tableLines.length, String[].class);
            ArrayList<String> list = new ArrayList<String>(Arrays.asList(stringArray));
            for (int i = 0; i < stringArray.length; i++) {
                String line = stringArray[i].toString().trim();
                if (line.equals(selectedItem)) {
                    list.remove(selectedItem);
                }
            }
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
            for (String loopObj : list) {
                if (referenceeState == 1) {
                    writingDepartment(loopObj);
                } else if (referenceeState == 2) {
                    writingSpecializedArea(loopObj);
                }
                br.close();
            }

        } catch (Exception ex) {
            Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
