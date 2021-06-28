package controllers;

public class appointmentController {
    private String appointmentPatientName;
    private dateController appointmentDate;
    private timeController appointmentTime;
    private String appointmentSymptoms;
    private String appointmentStatus;
    private String medicalOfficersFullName;
    private int appointmentRefNo;

    public appointmentController(String appPatientName, String medicalOfficersFullName, dateController appDate, timeController appTime,
            String appSymptoms, String appStatus, int appRefNo) {
        this.appointmentPatientName = appPatientName;
        this.medicalOfficersFullName = medicalOfficersFullName;
        this.appointmentDate = appDate;
        this.appointmentTime = appTime;
        this.appointmentSymptoms = appSymptoms;
        this.appointmentStatus = appStatus;
        setAppRefNo(appRefNo);
    }

    public appointmentController(String commaSeparatedString) {
        String[] dataRow = commaSeparatedString.split(",");
        setAppPatientName(dataRow[0]);
        setMedicalOfficersFullName(dataRow[1]);
        setAppDate(new dateController(dataRow[2]));
        setAppTime(new timeController(dataRow[3]));
        setAppSymptoms(dataRow[4]);
        setAppStatus(dataRow[5]);
        setAppRefNo(Integer.parseInt(dataRow[6]));
    }

    public boolean objectMatcher(appointmentController matchObj) {
        return matchObj.toString().equals(this.toString());
    }

    public String getMedicalOfficersFullName() {
        return medicalOfficersFullName;
    }

    public void setMedicalOfficersFullName(String medicalOfficersFullName) {
        this.medicalOfficersFullName = medicalOfficersFullName;
    }

    @Override
    public String toString() {
        return getAppPatientName() + "," + getMedicalOfficersFullName() + "," + appointmentDate.toString() + ","
                + appointmentTime.toString() + "," + getAppSymptoms() + "," + getAppStatus() + "," + getAppRefNo();
    }

    public String getAppPatientName() {
        return appointmentPatientName;
    }

    public void setAppPatientName(String appPatientName) {
        this.appointmentPatientName = appPatientName;
    }

    public dateController getAppDate() {
        return appointmentDate;
    }

    public void setAppDate(dateController appDate) {
        this.appointmentDate = appDate;
    }

    public timeController getAppTime() {
        return appointmentTime;
    }

    public void setAppTime(timeController appTime) {
        this.appointmentTime = appTime;
    }

    public String getAppSymptoms() {
        return this.appointmentSymptoms;
    }

    public void setAppSymptoms(String appSymptoms) {
        this.appointmentSymptoms = appSymptoms;
    }

    public String getAppStatus() {
        return appointmentStatus;
    }

    public void setAppStatus(String appStatus) {
        this.appointmentStatus = appStatus;
    }

    public int getAppRefNo() {
        return appointmentRefNo;
    }

    public void setAppRefNo(int appRefNo) {
        this.appointmentRefNo = appRefNo;
    }

}
