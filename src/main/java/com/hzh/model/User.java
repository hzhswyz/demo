package com.hzh.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9]{10,12}$")
    @Size(min=12,max=12,message = "{name.size}")
    private String name;
    @Size(min=6,max=12,message = "{password.size}")
    @NotNull
    private String password;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
