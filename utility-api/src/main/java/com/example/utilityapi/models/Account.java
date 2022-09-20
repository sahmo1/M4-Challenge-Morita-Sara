package com.example.utilityapi.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Account {

    @NotEmpty(message = "No duplicate usernames")
    private String username;
    @NotEmpty(message = "Must enter a valid password")
    @Size(min=0, max=10, message = "Password for newly created Account is capped at 10 characters.")
    private String password;
    private int id;

    public Account() { }

    public Account(String username, String password, int id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return getId() == account.getId() &&
                Objects.equals(getUsername(), account.getUsername()) &&
                Objects.equals(getPassword(), account.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getPassword(), getId());
    }
}
