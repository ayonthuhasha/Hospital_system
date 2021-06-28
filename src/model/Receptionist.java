package model;

public class Receptionist extends Admin{

    private String staffId;
    private String staffEmail;
    private String dateOfJoining;
    private String staffPhotograph;
    private String attachedDocument;

    public Receptionist(int userId, String userName, String name, boolean gender, String phoneNumber,
                        String idCardNumber, String dateOfBirth, String address, boolean maritalStatus, String staffId,
                        String staffEmail, String dateOfJoining, String staffPhotograph, String attachedDocument) {
        super(userId, userName, name, gender, phoneNumber, idCardNumber, dateOfBirth, address, maritalStatus);
        this.staffId = staffId;
        this.staffEmail = staffEmail;
        this.dateOfJoining = dateOfJoining;
        this.staffPhotograph = staffPhotograph;
        this.attachedDocument = attachedDocument;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getStaffPhotograph() {
        return staffPhotograph;
    }

    public void setStaffPhotograph(String staffPhotograph) {
        this.staffPhotograph = staffPhotograph;
    }

    public String getAttachedDocument() {
        return attachedDocument;
    }

    public void setAttachedDocument(String attachedDocument) {
        this.attachedDocument = attachedDocument;
    }
}
