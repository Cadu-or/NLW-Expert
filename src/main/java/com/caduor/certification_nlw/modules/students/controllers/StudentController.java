package com.caduor.certification_nlw.modules.students.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.caduor.certification_nlw.modules.students.dto.VerifyHasCertificationDTO;
import com.caduor.certification_nlw.modules.students.useCases.VerifyIfHasCertificationUseCase;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;


    @PostMapping("/verifyIfHasCertification")
    public String verifyIfHasCertification(@RequestBody VerifyHasCertificationDTO verifyHasCertificationDTO) {
        
        var result = this.verifyIfHasCertificationUseCase.execute(verifyHasCertificationDTO);

        if(result){ 
            return "Usuário já fez a prova";
        }

        return "Usuário pode fazer a prova";
    }   
}
