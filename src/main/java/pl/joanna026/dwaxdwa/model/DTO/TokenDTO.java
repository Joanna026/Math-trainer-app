package pl.joanna026.dwaxdwa.model.DTO;

import lombok.Data;
import pl.joanna026.dwaxdwa.model.entities.User;

import java.util.Date;

@Data
public class TokenDTO {
    private String token;
    private User user;
    private Date expiryDate;
}
