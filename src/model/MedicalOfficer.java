package model;

public class MedicalOfficer extends Admin{

    private String specialtyArea;

    public MedicalOfficer(int userId, String userName, String name, boolean gender, String phoneNumber,
                          String idCardNumber, String dateOfBirth, String address, boolean maritalStatus, String specialtyArea) {
        super(userId, userName, name, gender, phoneNumber, idCardNumber, dateOfBirth, address, maritalStatus);
        this.specialtyArea = specialtyArea;
    }

    public String getSpecialtyArea() {
        return specialtyArea;
    }

    public void setSpecialtyArea(String specialtyArea) {
        this.specialtyArea = specialtyArea;
    }
}
