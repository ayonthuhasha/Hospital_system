package model;

public class Appointments {

    private int appointmentId;
    private int patientId;
    private String appointmentDate;
    private String appointmentTime;
    private String symptoms;
    private int medicalOfficerId;

    public Appointments(int appointmentId, int patientId, String appointmentDate, String appointmentTime,
                        String symptoms, int medicalOfficerId) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.symptoms = symptoms;
        this.medicalOfficerId = medicalOfficerId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public int getMedicalOfficerId() {
        return medicalOfficerId;
    }

    public void setMedicalOfficerId(int medicalOfficerId) {
        this.medicalOfficerId = medicalOfficerId;
    }
}
