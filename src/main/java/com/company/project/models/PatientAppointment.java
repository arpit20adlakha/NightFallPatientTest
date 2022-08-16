package com.company.project.models;

import java.time.LocalDateTime;

public class PatientAppointment {
    public PatientAppointment(LocalDateTime appointmentTime, String providerID) {
        this.appointmentTime = appointmentTime;
        this.providerID = providerID;
    }

    public LocalDateTime appointmentTime;
    public String providerID;


    public void printData() {

        System.out.println("Data processed here");
    }


}
