package com.example.student.fgscleaningservices;

public class Customer {

    int id;
    String surname;
    String initials;
    String phone;
    String email;
    String username;
    String password;

    public Customer()
    {

    }
    public Customer(int id, String surname, String initials, String phoneNumber, String email, String username, String password)
    {

        this.surname = surname;
        this.initials =initials;
        this.email =email;
        this.username =username;
        this.password =password;
        this.id= id;
        this.phone= phoneNumber;
    }
    public Customer(String surname, String initials, String phoneNumber, String email, String username, String password){

        this.surname = surname;
        this.initials =initials;
        this.email = email;
        this.username =username;
        this.password =password;
        this.phone= phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }
    public String getInitials() {
        return initials;
    }
    public String getEmail() {
        return email;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getPhone() {
        return phone;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setInitials(String initials) {this.initials = initials; }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
