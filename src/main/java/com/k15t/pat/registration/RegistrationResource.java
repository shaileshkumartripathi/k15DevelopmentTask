package com.k15t.pat.registration;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import javax.validation.Valid;
import java.io.StringWriter;
import java.util.List;


@Service
public class RegistrationResource {

    @Autowired
    private RegistrationFormRepository registrationFormRepository;

    @Autowired private VelocityEngine velocityEngine;

    private boolean successFailure=true;

    public String save(@Valid @ModelAttribute RegistrationForm registrationForm)
    {
        successFailure=hasDataSaved(registrationForm);
        Template template = velocityEngine.getTemplate("templates/registration.vm");
        VelocityContext context = new VelocityContext();
        getVerifyDataSavedOrNot(registrationForm, context);
        StringWriter writer = new StringWriter();
        template.merge(context, writer);
        return writer.toString();
    }

    private void getVerifyDataSavedOrNot(@ModelAttribute @Valid RegistrationForm registrationForm, VelocityContext context) {
        if (successFailure) {
            saveData(registrationForm);
            context.put("status", "success");
            context.put("message", "Successfully Saved!");
            context.put("Name", registrationForm.getName());
            context.put("Address", registrationForm.getAddress());
            context.put("PhoneNo", registrationForm.getPhoneNumber());
            context.put("Email", registrationForm.getEmail());
        } else {
            context.put("status", "failure");
            context.put("Email", registrationForm.getEmail());
            context.put("message", "Data Not Saved!Email Address already present in the Database = ");
        }
    }

    public boolean hasDataSaved(RegistrationForm registrationForm) {
        if(getAllData().size() == 0) {
            successFailure = true;
            return successFailure;
        }
        for(RegistrationForm item: getAllData()) {
            // Can't persisted the  duplicate email.
            if(item.getEmail().equalsIgnoreCase(registrationForm.getEmail())){
                successFailure = false;
                return successFailure;
            }
        }
        return successFailure;
    }
    public List<RegistrationForm> getAllData() {
        return registrationFormRepository.findAll();
    }

    private void saveData(RegistrationForm registrationForm){
        registrationFormRepository.save(registrationForm);
    }

}
