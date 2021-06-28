package controllers;

import model.UserModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class loginController {
    private String userName;
    private int userID;
    private String userType;
    private String userPass;

    public loginController(String[] dataRow) {
        this(dataRow[0], Integer.parseInt(dataRow[1]), dataRow[2], dataRow[3]);
    }

    public loginController(String userName, String userType, String userPass) {
        setUserName(userName);
        setUserType(userType);
    }

    public loginController(String commaSeparatedString) {
        String[] dataRow = commaSeparatedString.split(",");
        setUserName(dataRow[0]);
        setUserID(Integer.parseInt(dataRow[1]));
        setUserType(dataRow[2]);
        setUserPass(dataRow[3]);
    }

    public loginController(String userName, int userID, String userType, String userPass) {
        setUserName(userName);
        setUserID(userID);
        setUserType(userType);
        setUserPass(userPass);
    }

    public int getNextIdNo() {
        int nextID = 1001;
        BufferedReader br = null;
        try {
            String sCurrentLine;
            String lastLine = "";

            File file = new File("userDetails\\loginDetails.txt");
            if (file.length() != 0) {
                br = new BufferedReader(new FileReader("userDetails\\loginDetails.txt"));
                while ((sCurrentLine = br.readLine()) != null) {
                    lastLine = sCurrentLine;
                }
            }
            String[] dataRow = lastLine.split(",");
            nextID = Integer.parseInt(dataRow[1]);
        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();

        } finally {
            try {

                if (br != null)
                    br.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }

        return nextID;

    }

    public void storeNewuserDetails() {
        String userDetails = getUserName() + "," + (getNextIdNo() + 1) + "," + getUserType() + "," + getUserPass();
        UserModel.writingTXT(userDetails);

    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    private void setUserName(String userName) {
        this.userName = userName;
    }

    private void setUserType(String userType) {
        this.userType = userType;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserType() {
        return userType;
    }

    public String getUserPass() {
        return userPass;
    }

    @Override
    public String toString() {
        return getUserName() + "," + getUserID() + "," + getUserType() + "," + getUserPass();
    }

    public boolean objectMatcher(loginController matchObj) {

        return matchObj.toString().equals(this.toString());

    }

}
