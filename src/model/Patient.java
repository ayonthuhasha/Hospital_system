package model;

public class Patient extends Admin{

    private String bloodGroup;
    private String allergies;

    public Patient(int userId, String userName, String name, boolean gender, String phoneNumber, String idCardNumber,
                   String dateOfBirth, String address, boolean maritalStatus, String bloodGroup, String allergies) {
        super(userId, userName, name, gender, phoneNumber, idCardNumber, dateOfBirth, address, maritalStatus);
        this.bloodGroup = bloodGroup;
        this.allergies = allergies;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }
}
