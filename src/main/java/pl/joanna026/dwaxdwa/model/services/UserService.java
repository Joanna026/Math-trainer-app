package pl.joanna026.dwaxdwa.model.services;

import pl.joanna026.dwaxdwa.model.entities.User;

public interface UserService {

    User findByUsername(String username);
    void saveUser(User username);
}
