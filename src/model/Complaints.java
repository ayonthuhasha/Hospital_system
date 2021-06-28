package model;

public class Complaints {

    private int complaintsId;
    private int complaintsType;
    private String complaintBy;
    private String phoneNumber;
    private String date;
    private String description;
    private String actionTaken;
    private String note;
    private String attachedDocument;


    public Complaints(int complaintsId, int complaintsType, String complaintBy, String phoneNumber, String date,
                      String description, String actionTaken, String note, String attachedDocument) {
        this.complaintsId = complaintsId;
        this.complaintsType = complaintsType;
        this.complaintBy = complaintBy;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.description = description;
        this.actionTaken = actionTaken;
        this.note = note;
        this.attachedDocument = attachedDocument;
    }

    public int getComplaintsId() {
        return complaintsId;
    }

    public void setComplaintsId(int complaintsId) {
        this.complaintsId = complaintsId;
    }

    public int getComplaintsType() {
        return complaintsType;
    }

    public void setComplaintsType(int complaintsType) {
        this.complaintsType = complaintsType;
    }

    public String getComplaintBy() {
        return complaintBy;
    }

    public void setComplaintBy(String complaintBy) {
        this.complaintBy = complaintBy;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActionTaken() {
        return actionTaken;
    }

    public void setActionTaken(String actionTaken) {
        this.actionTaken = actionTaken;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAttachedDocument() {
        return attachedDocument;
    }

    public void setAttachedDocument(String attachedDocument) {
        this.attachedDocument = attachedDocument;
    }
}
