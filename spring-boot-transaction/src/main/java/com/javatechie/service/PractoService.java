package com.javatechie.service;

import com.javatechie.dto.PatientAppointmentRequest;
import com.javatechie.entity.Appointment;
import com.javatechie.entity.Patient;
import com.javatechie.respository.AppointmentRepository;
import com.javatechie.respository.PatientRepository;
import com.javatechie.util.PromocodeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PractoService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Transactional
    public String bookAppointment(PatientAppointmentRequest request) {
        //SAVE Patient
        Patient patient = request.getPatient();
        long patientId = patientRepository.save(patient).getPatientId();
        //SAVE Appointment
        Appointment appointment = request.getAppointment();

        //rateHospitality(ratingInfo)

        //validate user promocode
        if (appointment.getPromoCode() != null) {
            PromocodeValidator.validatePromoCode(appointment.getPromoCode());
        }
        appointment.setPatientId(patientId);

        String appointmentNo = appointmentRepository.save(appointment).getAppointmentId();
        return "Hi " + patient.getName() +
                " Your appointment booked successfully & appointment number is "
                + appointmentNo;
    }

//    public void addDoctorRating() {
//        //save to db
//    }
//
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void rateHospitality() {
        //save to db
    }

}
