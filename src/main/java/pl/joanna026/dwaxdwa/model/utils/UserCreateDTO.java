package pl.joanna026.dwaxdwa.model.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;

public class UserCreateDTO {

    @NotNull
    private String username;
    @NotNull
    private String password;

    @JsonIgnore
    private final boolean logEnable = false;

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

    public boolean isLogEnable() {
        return logEnable;
    }
}
