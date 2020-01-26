package com.k15t.pat.registration;

import javax.persistence.*;

@Entity
@Table(name = "registration")
public class RegistrationForm {

    private long id;
    private String name;
    private String password;
    private String address;
    private String email;
    private String phoneNumber;

    public RegistrationForm(){

    }

    public RegistrationForm(String name,String password,String address,String email,String phoneNumber){
       this.name=name;
       this.password=password;
       this.address=address;
       this.email=email;
       this.phoneNumber=phoneNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name.trim();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    @Column(name = "password", nullable = false)
    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address.trim();
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email.trim();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "phoneNumber", nullable = false)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
