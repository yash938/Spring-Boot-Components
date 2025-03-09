package com.javatechie.controller;

import com.javatechie.dto.PatientAppointmentRequest;
import com.javatechie.service.PractoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/practo")
public class PractoController {

    @Autowired
    private PractoService service;

    @PostMapping("/bookAppointment")
    public String bookDoctorsAppointment(@RequestBody PatientAppointmentRequest request){
        return service.bookAppointment(request);
    }
}
