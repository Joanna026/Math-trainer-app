package pl.joanna026.dwaxdwa.model.services;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.joanna026.dwaxdwa.model.entities.ExerciseCollection;
import pl.joanna026.dwaxdwa.model.entities.LearntCollectionsWithUsers;
import pl.joanna026.dwaxdwa.model.entities.Role;
import pl.joanna026.dwaxdwa.model.entities.User;
import pl.joanna026.dwaxdwa.model.repositories.ExerciseCollectionRepository;
import pl.joanna026.dwaxdwa.model.repositories.RoleRepository;
import pl.joanna026.dwaxdwa.model.repositories.UserRepository;
import pl.joanna026.dwaxdwa.model.utils.UserDTO;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final ExerciseCollectionRepository exerciseCollectionRepository;
    private final EmailService emailService;
    private final TokenService tokenService;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, ModelMapper modelMapper, ExerciseCollectionRepository exerciseCollectionRepository, EmailService emailService, TokenService tokenService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
        this.emailService = emailService;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder();
        this.exerciseCollectionRepository = exerciseCollectionRepository;
    }

    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    public void save(User user) {
        userRepository.save(user);
    }


    public UserDTO findByUsername(String username) {
        return toDto(userRepository.findByUsername(username));
    }


    public void saveUser(UserDTO userDTO) {
        User user = toEntity(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setEnabled(false);
        Role studentRole = roleRepository.findByAuthority("ROLE_STUDENT");
        user.setAuthority(studentRole);
        userRepository.save(user);
    }


    public void addToAvailableCollections(Principal principal, Long collectionId) {
        UserDTO userDTO = toDto(userRepository.findByUsername(principal.getName()));
        List<ExerciseCollection> availableExerciseCollection = userDTO.getAvailableExerciseCollection();
        List<LearntCollectionsWithUsers> learntCollections = userDTO.getLearntCollections();
        Optional<ExerciseCollection> collectionToAdd = exerciseCollectionRepository.findById(collectionId);
        collectionToAdd.ifPresent(collection -> {

            if (!availableExerciseCollection.contains(collection) && !learntCollections.contains(collection)) {
                availableExerciseCollection.add(collection);
                userDTO.setAvailableExerciseCollection(availableExerciseCollection);
                userRepository.save(toEntity(userDTO));
            }
        });
    }


    public void removeFromAvailableCollections(Principal principal, Long collectionId) {
        User user = userRepository.findByUsername(principal.getName());
        List<ExerciseCollection> availableExerciseCollection = user.getAvailableExerciseCollection();
        Optional<ExerciseCollection> collectionToRemove = exerciseCollectionRepository.findById(collectionId);
        collectionToRemove.ifPresent(collection -> {
            availableExerciseCollection.remove(collection);
            user.setAvailableExerciseCollection(availableExerciseCollection);
            userRepository.save(user);

            String token = UUID.randomUUID().toString();
            tokenService.createToken(user, token);

            emailService.sendSimpleMessage(user.getEmail(), "Aktywacja konta",
                    "Aby dokończyć proces rejestracji, kliknij w poniższy link: \n " +
                            "https://dwaxdwa.hakuroapp.com/activate?token=" + token);
        });
    }

    public void save(UserDTO userDTO) {
        userRepository.save(toEntity(userDTO));
    }


    public UserDTO toDto(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public User toEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
}
