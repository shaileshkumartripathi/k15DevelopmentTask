package com.k15t.pat.registration;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.EntityManager;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationResourceTest {

    @Test
    public void getAllDataIfSingleData() {


        RegistrationResource registrationFormRepository = mock(RegistrationResource.class);
        when(registrationFormRepository.getAllData()).thenReturn(getListFindData());

        RegistrationResource registrationResource = new RegistrationResource();
        registrationResource=registrationFormRepository;

        List<RegistrationForm> data = registrationResource.getAllData();
        Assert.assertEquals("abc@gmail.com",data.get(0).getEmail());
        Assert.assertEquals("Asko",data.get(0).getName());
        Assert.assertEquals("12345678",data.get(0).getPhoneNumber());
        Assert.assertEquals("South-east",data.get(0).getAddress());
    }

    @Test
    public void getAllDataIfTwoDataSet() {


        RegistrationResource registrationFormRepository = mock(RegistrationResource.class);
        when(registrationFormRepository.getAllData()).thenReturn(getListFindDataTwoDataSet());

        RegistrationResource registrationResource = new RegistrationResource();
        registrationResource=registrationFormRepository;

        List<RegistrationForm> data = registrationResource.getAllData();
        Assert.assertEquals("abc@gmail.com",data.get(0).getEmail());
        Assert.assertEquals("Asko",data.get(0).getName());
        Assert.assertEquals("12345678",data.get(0).getPhoneNumber());
        Assert.assertEquals("South-east",data.get(0).getAddress());

        Assert.assertEquals("germany@gmail.com",data.get(1).getEmail());
        Assert.assertEquals("Rakesh",data.get(1).getName());
        Assert.assertEquals("84652436",data.get(1).getPhoneNumber());
        Assert.assertEquals("South-west",data.get(1).getAddress());
    }

    @Test
    public void hasNotSavedData() {

        RegistrationResource registrationFormRepository = mock(RegistrationResource.class);
        when(registrationFormRepository.hasDataSaved(getRegistrationForm())).thenReturn(false);

        RegistrationResource registrationResource = new RegistrationResource();
        registrationResource=registrationFormRepository;

        boolean data=registrationResource.hasDataSaved(getRegistrationForm());
        Assert.assertEquals(false,data);
    }

    @Test
    public void hasSavedData() {

        RegistrationResource registrationFormRepository = mock(RegistrationResource.class);
        when(registrationFormRepository.hasDataSaved(getRegistrationForm())).thenReturn(true);

        RegistrationResource registrationResource = new RegistrationResource();
        registrationResource=registrationFormRepository;

        boolean data=registrationResource.hasDataSaved(getRegistrationForm());
        Assert.assertEquals(false,data);
    }

    private RegistrationForm getRegistrationForm() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.setName("Jhon");
        registrationForm.setAddress("South-east");
        registrationForm.setEmail("abc@abc.com");
        registrationForm.setPhoneNumber("12345678");

        return registrationForm;
    }

    private List<RegistrationForm> getListFindData(){
        List<RegistrationForm> list= new ArrayList<RegistrationForm>();
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.setName("Asko");
        registrationForm.setAddress("South-east");
        registrationForm.setEmail("abc@gmail.com");
        registrationForm.setPhoneNumber("12345678");
        list.add(registrationForm);
        return list;
    }

    private List<RegistrationForm> getListFindDataTwoDataSet(){
        List<RegistrationForm> list= new ArrayList<RegistrationForm>();
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.setName("Asko");
        registrationForm.setAddress("South-east");
        registrationForm.setEmail("abc@gmail.com");
        registrationForm.setPhoneNumber("12345678");

        RegistrationForm registrationForm1 = new RegistrationForm();
        registrationForm1.setName("Rakesh");
        registrationForm1.setAddress("South-west");
        registrationForm1.setEmail("germany@gmail.com");
        registrationForm1.setPhoneNumber("84652436");

        list.add(registrationForm);
        list.add(registrationForm1);
        return list;
    }
}