package com.company.project.models;

import java.time.LocalDateTime;

public class ProviderAppointment {
    public ProviderAppointment(LocalDateTime appointmentTime, String patientID) {
        this.appointmentTime = appointmentTime;
        this.patientID = patientID;
    }

    public ProviderAppointment(LocalDateTime localDateTime) {
        this.appointmentTime = localDateTime;
    }

    public ProviderAppointment(String patientID) {
        this.patientID = patientID;
    }
    public LocalDateTime appointmentTime;
    public String patientID;

}
