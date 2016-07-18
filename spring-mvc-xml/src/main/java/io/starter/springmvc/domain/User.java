package io.starter.springmvc.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

public class User {

    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 6)
    private String password;

    private long timestamp;

    private int age;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
