package model;

import controllers.appointmentController;
import controllers.dateController;
import controllers.timeController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppointmentModel {


    private static String filePath = "userDetails\\appointment.txt";

    public static void writingTXT(String appointmentString) {
        BufferedWriter bw = null;
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
                new IOException("File is not found!");
            }
            FileWriter fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            bw.write(appointmentString);
            bw.newLine();


        } catch (IOException ioe) {
            System.out.println(ioe);
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

    public static void deleteAppointment(appointmentController deleteObj) {
        File file = new File(filePath);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            ArrayList<appointmentController> appObjList = new ArrayList<appointmentController>();
            appointmentController currAppObj;
            Object[] tableLines = br.lines().toArray();

            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                currAppObj = new appointmentController(dataRow[0], dataRow[1], new dateController(dataRow[2]),
                        new timeController(dataRow[3]), dataRow[4], dataRow[5], Integer.parseInt(dataRow[6]));
                appObjList.add(currAppObj);
            }
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
            int deleteIndexNo = 0;
            for (appointmentController loopObj : appObjList) {
                if (deleteObj.objectMatcher(loopObj)) {
                    break;
                }
                deleteIndexNo += 1;
            }
            appObjList.remove(deleteIndexNo);
            deleteIndexNo = 0;
            for (appointmentController loopObj : appObjList) {
                writingTXT(loopObj.toString());
            }
            br.close();

        } catch (IOException | NumberFormatException ex) {
            Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public static void viewAppointment(JTable appointmentViewTable) {
        File file = new File(filePath);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            DefaultTableModel model = (DefaultTableModel) appointmentViewTable.getModel();
            model.setRowCount(0);
            Object[] tableLines = br.lines().toArray();

            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                model.addRow(dataRow);
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updateAppointment(int deleteRowNumber, String updatedString) {
        File file = new File(filePath);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            ArrayList<appointmentController> appObjList = new ArrayList<appointmentController>();
            appointmentController currAppObj;
            appointmentController updatedObj = new appointmentController(updatedString);
            Object[] tableLines = br.lines().toArray();

            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                currAppObj = new appointmentController(line);
                appObjList.add(currAppObj);
            }
            appObjList.set(deleteRowNumber, updatedObj);
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();

            for (appointmentController loopObj : appObjList) {
                writingTXT(loopObj.toString());
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void viewAppointmentByUser(JTable appointmentViewTable, String userName, int userType) {
        File file = new File(filePath);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            DefaultTableModel model = (DefaultTableModel) appointmentViewTable.getModel();
            model.setRowCount(0);
            Object[] tableLines = br.lines().toArray();

            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");

                if (userType == 1) {
                    if (dataRow[0].equals(userName)) {
                        model.addRow(dataRow);
                    }
                }
                if (userType == 2) {
                    if (dataRow[1].equals(userName)) {
                        model.addRow(dataRow);
                    }
                }
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int getNextAppRefNo() {
        int nextID = 1001;
        BufferedReader br = null;
        try {
            String sCurrentLine;
            String lastLine = "";
            File file = new File(filePath);
            if (file.length() != 0) {
                br = new BufferedReader(new FileReader(filePath));
                while ((sCurrentLine = br.readLine()) != null) {
                    lastLine = sCurrentLine;
                }
            }
            String[] dataRow = lastLine.split(",");
            nextID = Integer.parseInt(dataRow[6]) + 1;
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {

                if (br != null)
                    br.close();

            } catch (IOException ex) {
            }
        }
        return nextID;
    }

    public static void updateAppointmentByRefID(int referID, String updatedString) {
        File file = new File(filePath);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            ArrayList<appointmentController> lineObjList = new ArrayList<appointmentController>();
            appointmentController currAppObj;
            appointmentController updatedObj = new appointmentController(updatedString);
            Object[] tableLines = br.lines().toArray();
            int matchedObjNo = 0;
            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                currAppObj = new appointmentController(line);
                if (currAppObj.getAppRefNo() == referID) {
                    matchedObjNo = i;
                }
                lineObjList.add(currAppObj);
            }

            lineObjList.set(matchedObjNo, updatedObj);
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
            for (appointmentController loopObj : lineObjList) {
                writingTXT(loopObj.toString());
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updateAppointmentState(String relevantString, String newState) throws FileNotFoundException {
        File file = new File(filePath);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            ArrayList<appointmentController> appObjList = new ArrayList<appointmentController>();
            appointmentController currAppObj;
            Object[] tableLines = br.lines().toArray();

            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                currAppObj = new appointmentController(line);
                if (currAppObj.objectMatcher(new appointmentController(relevantString))) {
                    currAppObj.setAppStatus(newState);
                }
                appObjList.add(currAppObj);
            }

            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();

            for (appointmentController loopObj : appObjList) {
                writingTXT(loopObj.toString());
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int[] appointmentCounter(String mediCalOffiFullName) throws FileNotFoundException {
        int[] finalCount = { 0, 0, 0 };
        File file = new File(filePath);
        try {

            BufferedReader br = new BufferedReader(new FileReader(file));
            ArrayList<appointmentController> appObjList = new ArrayList<appointmentController>();
            appointmentController currAppObj;
            Object[] tableLines = br.lines().toArray();

            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                currAppObj = new appointmentController(line);
                if (currAppObj.getMedicalOfficersFullName().equals(mediCalOffiFullName)) {
                    appObjList.add(currAppObj);
                }
            }
            br.close();
            int finished = 0, incoming = 0, approved = 0;
            for (appointmentController loopObj : appObjList) {
                if (loopObj.getAppStatus().equals("Pending")) {
                    incoming += 1;
                }
                if (loopObj.getAppStatus().equals("Approved")) {
                    approved += 1;
                }
                if (loopObj.getAppStatus().equals("finished")) {
                    finished += 1;
                }
            }
            finalCount[0] = approved;
            finalCount[1] = finished;
            finalCount[2] = incoming;
        } catch (IOException ex) {
            Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return finalCount;
    }

    public static ArrayList<appointmentController> medicalOffierAppoinmentSelector(String mediCalOffiFullName)
            throws FileNotFoundException {
        ArrayList<appointmentController> appObjList = new ArrayList<appointmentController>();
        File file = new File(filePath);

        try {

            BufferedReader br = new BufferedReader(new FileReader(file));
            appointmentController currAppObj;
            Object[] tableLines = br.lines().toArray();
            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                currAppObj = new appointmentController(line);
                if (currAppObj.getMedicalOfficersFullName().equals(mediCalOffiFullName)) {
                    appObjList.add(currAppObj);
                }
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return appObjList;
    }
}