package com.csm.LibraryManagementim.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, message = "Name must have more than 3 characters")
    @Pattern(regexp = "^[a-zA-Z]{3}$", message = "Name must contain only alphabetic characters")
    private String name;

    private String email;
    private String mobilenumber;
    private String gender;
    private LocalDate birthday;
    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;
    public LocalDateTime getRegistrationTime() {
        return registrationTime;
    }
    @CreationTimestamp
    private LocalDateTime registrationTime;
    private String image;

    public User()
    {

    }
    // getters
    // setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public void setRegistrationTime(LocalDateTime registrationTime) {
        this.registrationTime = registrationTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    // override toString()


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobilenumber='" + mobilenumber + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", library=" + library +
                ", registrationTime=" + registrationTime +
                ", image='" + image + '\'' +
                '}';
    }
}

