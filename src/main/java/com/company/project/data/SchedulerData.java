package com.company.project.data;

import com.company.project.models.PatientAppointment;
import com.company.project.models.ProviderAppointment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

public class SchedulerData {
    public static Map<LocalDate, Map<String, Map<LocalDateTime, ProviderAppointment>>> providerAppointments;
    public static Map<String, PatientAppointment> patientAppointments;

}
