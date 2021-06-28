package model;

public class Visitor {

    private int visitorId;
    private String purpose;
    private String name;
    private String phone;
    private String idCardNumberOfPerson;
    private String date;
    private String inTime;
    private String outTime;
    private String attachedDocument;


    public Visitor(int visitorId, String purpose, String name, String phone, String idCardNumberOfPerson,
                   String date, String inTime, String outTime, String attachedDocument) {
        this.visitorId = visitorId;
        this.purpose = purpose;
        this.name = name;
        this.phone = phone;
        this.idCardNumberOfPerson = idCardNumberOfPerson;
        this.date = date;
        this.inTime = inTime;
        this.outTime = outTime;
        this.attachedDocument = attachedDocument;
    }

    public int getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(int visitorId) {
        this.visitorId = visitorId;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCardNumberOfPerson() {
        return idCardNumberOfPerson;
    }

    public void setIdCardNumberOfPerson(String idCardNumberOfPerson) {
        this.idCardNumberOfPerson = idCardNumberOfPerson;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public String getAttachedDocument() {
        return attachedDocument;
    }

    public void setAttachedDocument(String attachedDocument) {
        this.attachedDocument = attachedDocument;
    }
}
