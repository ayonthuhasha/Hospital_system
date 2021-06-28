package controllers;


public class loginUserController {
    private String userName;
    private String userType;

    public loginUserController(String userName, String userPass) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public String getUserName() {
        return userName;
    }

    public String loginLogNewRecord() {
        dateController loggedDate = new dateController();
        timeController loggedTime = new timeController();
        return getUserName() + "|" + getUserType() + "|" + loggedDate.toString() + "|" + loggedTime.toString();

    }
}
