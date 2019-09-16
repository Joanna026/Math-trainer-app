package pl.joanna026.dwaxdwa.model.utils;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class TeacherUpdateDTO {

    @Id
    @NotNull
    private Long id;
    @NotNull
    private String username;
    @NotNull
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

    public void setPassword(String password) {
        this.password = password;
    }
}
