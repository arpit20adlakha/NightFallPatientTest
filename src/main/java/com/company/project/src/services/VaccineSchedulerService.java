package com.company.project.src.services;

import com.company.project.data.SchedulerData;
import com.company.project.models.PatientAppointment;
import com.company.project.models.ProviderAppointment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class VaccineSchedulerService {

    public void addAppointment(String providerID, LocalDateTime appointmentTime) {
        ProviderAppointment  providerAppointment = new ProviderAppointment(appointmentTime);
        LocalDate date = appointmentTime.toLocalDate();
        if (SchedulerData.providerAppointments.get(date) == null) {
            SchedulerData.providerAppointments.put(date, new HashMap());
        }

        if (SchedulerData.providerAppointments.get(date).get(providerID) == null) {
            SchedulerData.providerAppointments.put(date, new HashMap());
        }

        Map<LocalDateTime, ProviderAppointment> providerMapLocalDateTime =  SchedulerData.providerAppointments.get(date).get(providerID);

        if (providerMapLocalDateTime.get(appointmentTime) != null) {
            System.out.println("Appointment already present");
            return;
        }
        providerMapLocalDateTime.put(appointmentTime, providerAppointment);
    }

    // remove even when it is booked
    public void removeAppointment(String providerID, LocalDateTime appointmentTime) {
        LocalDate date = appointmentTime.toLocalDate();

        if (SchedulerData.providerAppointments.get(date) != null
                && SchedulerData.providerAppointments.get(date).get(providerID) != null
                && SchedulerData.providerAppointments.get(date).get(providerID).get(appointmentTime) != null) {

            ProviderAppointment providerAppointment = SchedulerData.providerAppointments.get(date).get(providerID).get(appointmentTime);
            String patientId = providerAppointment.patientID;
            if (patientId != null && SchedulerData.patientAppointments.get(patientId) != null) {
                SchedulerData.patientAppointments.remove(patientId);
            }
            SchedulerData.providerAppointments.get(date).get(providerID).remove(appointmentTime);
        }
    }

    public void scheduleAppointment(String patientID, String providerID, LocalDateTime appointmentTime) {
        LocalDate date = appointmentTime.toLocalDate();
        if (SchedulerData.patientAppointments.get(patientID) != null) {
            System.out.println("Patient already has an appointment");
            return;
        }

        if (SchedulerData.providerAppointments.get(date) != null
                && SchedulerData.providerAppointments.get(date).get(providerID) != null
                && SchedulerData.providerAppointments.get(date).get(providerID).get(appointmentTime) != null) {
            ProviderAppointment provider = SchedulerData.providerAppointments.get(date).get(providerID).get(appointmentTime);

            if (provider.patientID == null) {
                provider.patientID = patientID;
            }

            PatientAppointment patientAppointment = new PatientAppointment(appointmentTime, providerID);

            SchedulerData.patientAppointments.put(patientID, patientAppointment);
        }
    }

    public void cancelAppointment(String patientID) {
        if (SchedulerData.patientAppointments.get(patientID) != null) {
            PatientAppointment patientAppointment = SchedulerData.patientAppointments.get(patientID);
            String providerID = patientAppointment.providerID;
            LocalDateTime appointmentTime = patientAppointment.appointmentTime;
            LocalDate date = appointmentTime.toLocalDate();

            ProviderAppointment provider = SchedulerData.providerAppointments.get(date).get(providerID).get(appointmentTime);
            provider.patientID = null;

            SchedulerData.patientAppointments.remove(patientID);
        }



    }

}
