package model;

public class PostalModule {

    private int postalId;
    private String form;
    private String referenceNumber;
    private String formAddress;
    private String note;
    private String toName;
    private String date;
    private boolean isADispatchPostal;
    private String attachedDocument;

    public PostalModule(int postalId, String form, String referenceNumber, String formAddress, String note,
                        String toName, String date, boolean isADispatchPostal, String attachedDocument) {
        this.postalId = postalId;
        this.form = form;
        this.referenceNumber = referenceNumber;
        this.formAddress = formAddress;
        this.note = note;
        this.toName = toName;
        this.date = date;
        this.isADispatchPostal = isADispatchPostal;
        this.attachedDocument = attachedDocument;
    }

    public int getPostalId() {
        return postalId;
    }

    public void setPostalId(int postalId) {
        this.postalId = postalId;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getFormAddress() {
        return formAddress;
    }

    public void setFormAddress(String formAddress) {
        this.formAddress = formAddress;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isADispatchPostal() {
        return isADispatchPostal;
    }

    public void setADispatchPostal(boolean ADispatchPostal) {
        isADispatchPostal = ADispatchPostal;
    }

    public String getAttachedDocument() {
        return attachedDocument;
    }

    public void setAttachedDocument(String attachedDocument) {
        this.attachedDocument = attachedDocument;
    }
}
