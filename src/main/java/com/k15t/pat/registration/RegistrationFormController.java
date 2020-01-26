package com.k15t.pat.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RegistrationFormController {

    @Autowired
    private RegistrationResource registrationResource;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute RegistrationForm registrationForm) {
        return registrationResource.save(registrationForm);
    }
}
