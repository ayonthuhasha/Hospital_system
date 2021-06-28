package model;

import controllers.loginController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserModel {
    private static String filePath = "userDetails\\loginDetails.txt";

    public static void writingTXT(String AddNewUserDetail) {
        BufferedWriter bw = null;
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                file.createNewFile();
                new IOException("File is not found!");
            }

            FileWriter fw = new FileWriter(file, true);

            bw = new BufferedWriter(fw);

            bw.write(AddNewUserDetail);
            bw.newLine();

        } catch (IOException ioe) {
            System.out.println(ioe);
            ioe.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (Exception ex)

            {
                System.out.println(ex);
            }
        }
    }

    public static void viewLoginDetails(JTable loginViewTable) {
        File file = new File(filePath);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            DefaultTableModel model = (DefaultTableModel) loginViewTable.getModel();
            model.setRowCount(0);
            Object[] tableLines = br.lines().toArray();

            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                model.addRow(dataRow);
            }
            br.close();

        } catch (Exception ex) {
            Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public static void deleteUser(loginController deleteObj) {
        File file = new File(filePath);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            ArrayList<loginController> loginObjList = new ArrayList<loginController>();
            loginController currAppObj;
            Object[] tableLines = br.lines().toArray();

            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                currAppObj = new loginController(dataRow);
                loginObjList.add(currAppObj);
            }

            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();

            int deleteIndexNo = 0;
            for (loginController loopObj : loginObjList) {

                if (deleteObj.objectMatcher(loopObj)) {
                    break;
                }
                deleteIndexNo += 1;

            }

            loginObjList.remove(deleteIndexNo);
            deleteIndexNo = 0;
            for (loginController loopObj : loginObjList) {

                writingTXT(loopObj.toString());

            }
            br.close();

        } catch (Exception ex) {
            Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public static void updateUser(int deleteRowNumber, String updatedString) {

        File file = new File(filePath);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            ArrayList<loginController> lineObjList = new ArrayList<loginController>();
            loginController currAppObj;
            loginController updatedObj = new loginController(updatedString);
            Object[] tableLines = br.lines().toArray();

            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();

                currAppObj = new loginController(line);

                lineObjList.add(currAppObj);

            }

            lineObjList.set(deleteRowNumber, updatedObj);

            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();

            for (loginController loopObj : lineObjList) {

                writingTXT(loopObj.toString());

            }
            br.close();
        } catch (Exception ex) {
            Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public static void updatePasswordByUser(String userName, String newPass) {

        File file = new File(filePath);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            ArrayList<loginController> lineObjList = new ArrayList<loginController>();
            loginController currAppObj;
            Object[] tableLines = br.lines().toArray();

            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();

                currAppObj = new loginController(line);
                if (currAppObj.getUserName().equals(userName)) {
                }
                lineObjList.add(currAppObj);

            }

            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();

            for (loginController loopObj : lineObjList) {

                writingTXT(loopObj.toString());

            }
            br.close();
        } catch (Exception ex) {
            Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public static void writeNewLog(String AddNewUserDetail) {
        String filePath = "userDetails\\loginLog.txt";

        BufferedWriter bw = null;
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                file.createNewFile();
                new IOException("File is not found!");

            }

            FileWriter fw = new FileWriter(file, true);

            bw = new BufferedWriter(fw);

            bw.write(AddNewUserDetail);
            bw.newLine();

        } catch (IOException ioe) {
            System.out.println(ioe);
            ioe.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (Exception ex)

            {
                System.out.println(ex);
            }
        }
    }

    public static boolean userNameChecker(String userName) {
        boolean mathchState = false;
        File file = new File(filePath);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            Object[] tableLines = br.lines().toArray();

            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                if (userName.equals(dataRow[0])) {
                    mathchState = true;
                }
            }
            br.close();
        } catch (Exception ex) {
            Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);

        }
        return mathchState;

    }

    public static void patientView(JTable loginViewTable) {

        File file = new File(filePath);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            DefaultTableModel model = (DefaultTableModel) loginViewTable.getModel();

            model.setRowCount(0);

            Object[] tableLines = br.lines().toArray();

            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                if (dataRow[2].equals("PAT")) {
                    model.addRow(dataRow);
                }

            }
            br.close();

        } catch (Exception ex) {
            Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public static void patientPassReset(String rowString) {

        String[] PatientUserName = rowString.split(",");
        File file = new File(filePath);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            ArrayList<loginController> lineObjList = new ArrayList<loginController>();
            loginController currAppObj;
            Object[] tableLines = br.lines().toArray();

            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                currAppObj = new loginController(line);
                lineObjList.add(currAppObj);
            }
            for (loginController loopObj : lineObjList) {

                if (loopObj.getUserName().equals(PatientUserName[0])) {
                }

            }

            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();

            for (loginController loopObj : lineObjList) {

                writingTXT(loopObj.toString());

            }
            br.close();
        } catch (Exception ex) {
            Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public static void medicalPassReset(String rowString) {

        String[] medicalUserDetail = rowString.split(",");

        updatePasswordByUser(medicalUserDetail[3], medicalUserDetail[7]);
    }

    public static void receptionistPassReset(String rowString) {

        String[] receptionistUserDetail = rowString.split(",");

        updatePasswordByUser(receptionistUserDetail[2], receptionistUserDetail[6]);
    }
}