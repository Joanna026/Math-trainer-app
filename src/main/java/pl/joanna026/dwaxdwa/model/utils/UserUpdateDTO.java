package pl.joanna026.dwaxdwa.model.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class UserUpdateDTO {

    @Id
    @NotNull
    private Long id;
    @NotNull
    private String username;
    @JsonIgnore
    private String password;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
