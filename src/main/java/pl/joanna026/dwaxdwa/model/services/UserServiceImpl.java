package pl.joanna026.dwaxdwa.model.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.joanna026.dwaxdwa.model.entities.ExerciseCollection;
import pl.joanna026.dwaxdwa.model.entities.Role;
import pl.joanna026.dwaxdwa.model.entities.User;
import pl.joanna026.dwaxdwa.model.repositories.ExerciseCollectionRepository;
import pl.joanna026.dwaxdwa.model.repositories.RoleRepository;
import pl.joanna026.dwaxdwa.model.repositories.UserRepository;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ExerciseCollectionRepository exerciseCollectionRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder, ExerciseCollectionRepository exerciseCollectionRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.exerciseCollectionRepository = exerciseCollectionRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
       user.setEnabled(true);
        Role studentRole = roleRepository.findByAuthority("ROLE_STUDENT");
        user.setAuthority(studentRole);
        userRepository.save(user);
    }

    @Override
    public void addToAvailableCollections(Principal principal, Long collectionId) {
        User user = userRepository.findByUsername(principal.getName());
        List<ExerciseCollection> availableExerciseCollection = user.getAvailableExerciseCollection();
        Optional<ExerciseCollection> collectionToAdd = exerciseCollectionRepository.findById(collectionId);
        collectionToAdd.ifPresent(collection -> {
            availableExerciseCollection.add(collection);
            user.setAvailableExerciseCollection(availableExerciseCollection);
            userRepository.save(user);
        });
    }


    @Override
    public void removeFromAvailableCollections(Principal principal, Long collectionId) {
        User user = userRepository.findByUsername(principal.getName());
        List<ExerciseCollection> availableExerciseCollection = user.getAvailableExerciseCollection();
        Optional<ExerciseCollection> collectionToRemove = exerciseCollectionRepository.findById(collectionId);
        collectionToRemove.ifPresent(collection -> {
            availableExerciseCollection.remove(collection);
            user.setAvailableExerciseCollection(availableExerciseCollection);
            userRepository.save(user);
        });
    }
}
