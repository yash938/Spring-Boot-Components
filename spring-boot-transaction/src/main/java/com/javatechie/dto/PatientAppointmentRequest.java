package com.javatechie.dto;

import com.javatechie.entity.Appointment;
import com.javatechie.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientAppointmentRequest {

    private Patient patient;

    private Appointment appointment;
}
