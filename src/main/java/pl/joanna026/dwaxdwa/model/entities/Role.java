package pl.joanna026.dwaxdwa.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Embeddable
@Entity
@Table(name = "roles")
@Getter @Setter
public class Role extends BaseEntity{

    @Column(nullable = false)
    private String authority;

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
