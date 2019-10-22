package pl.joanna026.dwaxdwa.model.services;

import pl.joanna026.dwaxdwa.model.entities.User;

import java.security.Principal;

public interface UserService {

    User findByUsername(String username);
    void saveUser(User username);
    void addToAvailableCollections(Principal principal, Long collectionId);
    void save(User user);

    void removeFromAvailableCollections(Principal principal, Long collectionId);
}

