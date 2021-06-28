package model;

public class Admin {

    private int userId;
    private String userName;
    private String name;
    private boolean gender;
    private String phoneNumber;
    private String idCardNumber;
    private String dateOfBirth;
    private String address;
    private boolean maritalStatus;


    public Admin(int userId, String userName, String name, boolean gender, String phoneNumber, String idCardNumber,
                 String dateOfBirth, String address, boolean maritalStatus) {
        this.userId = userId;
        this.userName = userName;
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.idCardNumber = idCardNumber;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.maritalStatus = maritalStatus;
    }

    public int getUserId() {

        return userId;
    }

    public void setUserId(int userId) {

        this.userId = userId;
    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public boolean isGender() {

        return gender;
    }

    public void setGender(boolean gender) {

        this.gender = gender;
    }

    public String getPhoneNumber() {

        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;
    }

    public String getIdCardNumber() {

        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {

        this.idCardNumber = idCardNumber;
    }

    public String getDateOfBirth() {

        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {

        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public boolean isMaritalStatus() {

        return maritalStatus;
    }

    public void setMaritalStatus(boolean maritalStatus) {

        this.maritalStatus = maritalStatus;
    }
}
