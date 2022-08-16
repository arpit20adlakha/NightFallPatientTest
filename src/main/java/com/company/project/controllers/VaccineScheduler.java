package com.company.project.controllers;

import com.company.project.models.PatientAppointment;
import com.company.project.models.ProviderAppointment;
import com.company.project.src.services.VaccineSchedulerService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.AbstractCollection;
import java.util.AbstractMap;

public class VaccineScheduler {
        VaccineSchedulerService vaccineSchedulerService;

        public VaccineScheduler() {
            this.vaccineSchedulerService = new VaccineSchedulerService();
        }

        /**
         * Reserve a patient appointment with this provider and appointment time
         * @param patientID A unique patient ID
         * @param providerID A unique provider ID
         * @param appointmentTime Appointment date and time
         */
        public void scheduleAppointment(String patientID, String providerID, LocalDateTime appointmentTime)
        {
                vaccineSchedulerService.scheduleAppointment(patientID, providerID, appointmentTime);
        }

        /**
         * Cancel an existing appointment for a patient. If this patient has no
         * appointment, do nothing.
         * @param patientID A unique patient ID
         */
        public void cancelAppointment(String patientID)
        {
        }

        /**
         * Get this patient's appointment information
         * @param patientID A unique patient ID
         * @return A PatientAppointment with this patient's appointment information, or
         *         null if this patient has no appointment reserved
         */
//        public PatientAppointment getPatientAppointment(String patientID)
//        {
//        }

        /**
         * Get open appointments on this day for patients to browse
         * @param day A calendar date
         * @return A mapping of appointment time to list of provider IDs
         *         indicating which providers have available appointments for each
         *         appointment time on this day
         */
//        public AbstractMap<LocalDateTime, AbstractCollection<String>> getAvailableAppointments(LocalDate day)
//        {
//        }

        /**
         * Make a new appointment with this provider available
         * @param providerID A unique provider ID
         * @param appointmentTime Appointment date and time
         */
        public void addAppointment(String providerID, LocalDateTime appointmentTime)
        {
            vaccineSchedulerService.addAppointment(providerID, appointmentTime);
        }

        /**
         * Remove an available appointment for a provider at this time. If this
         * provider has no appointment at this time, do nothing.
         * @param providerID A unique provider ID
         * @param appointmentTime Appointment date and time
         */
        public void removeAppointment(String providerID, LocalDateTime appointmentTime)
        {
                vaccineSchedulerService.removeAppointment(providerID, appointmentTime);
        }

        /**
         * Get this provider's patient schedule for this day
         * @param providerID A unique provider ID
         * @param day A calendar date
         * @return A list of ProviderAppointment objects (containing appointment
         *         times and patient IDs), sorted by appointment time, which
         *         represents the patient schedule for this provider on this day
         */
//        public AbstractCollection<ProviderAppointment> getProviderSchedule(String providerID, LocalDate day)
//        {
//
//        }
}
