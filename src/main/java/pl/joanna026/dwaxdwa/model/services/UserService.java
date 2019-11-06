package pl.joanna026.dwaxdwa.model.services;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.joanna026.dwaxdwa.model.DTO.ExerciseCollectionDTO;
import pl.joanna026.dwaxdwa.model.DTO.LearntCollectionsWithUsersDTO;
import pl.joanna026.dwaxdwa.model.DTO.UserDTO;
import pl.joanna026.dwaxdwa.model.entities.ExerciseCollection;
import pl.joanna026.dwaxdwa.model.entities.Role;
import pl.joanna026.dwaxdwa.model.entities.User;
import pl.joanna026.dwaxdwa.model.repositories.RoleRepository;
import pl.joanna026.dwaxdwa.model.repositories.UserRepository;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final ExerciseCollectionService exerciseCollectionService;
    private final EmailService emailService;
    private final TokenService tokenService;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, ModelMapper modelMapper, ExerciseCollectionService exerciseCollectionService, EmailService emailService, TokenService tokenService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
        this.exerciseCollectionService = exerciseCollectionService;
        this.emailService = emailService;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder();
    }


    public void saveUser(UserDTO userDTO) {
        User user = toEntity(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setEnabled(false);
        Role studentRole = roleRepository.findByAuthority("ROLE_STUDENT");
        user.setAuthority(studentRole);
        userRepository.save(user);

        String token = UUID.randomUUID().toString();
        tokenService.createToken(user, token);

        emailService.sendSimpleMessage(userDTO.getEmail(), "Aktywacja konta",
                "Aby dokończyć proces rejestracji, kliknij w poniższy link: \n " +
                        "https://dwaxdwa.herokuapp.com/activate?token=" + token);

    }

    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


    public UserDTO findByUsername(String username) {
        return toDto(userRepository.findByUsername(username));
    }

    public void addToAvailableCollections(Principal principal, Long collectionId) {
        UserDTO userDTO = toDto(userRepository.findByUsername(principal.getName()));
        List<ExerciseCollectionDTO> availableExerciseCollection = userDTO.getAvailableExerciseCollection();
        List<LearntCollectionsWithUsersDTO> learntCollections = userDTO.getLearntCollections();
        ExerciseCollectionDTO collectionToAdd = exerciseCollectionService.findById(collectionId);

            if (!availableExerciseCollection.contains(collectionToAdd) && !learntCollections.contains(collectionToAdd)) {
                availableExerciseCollection.add(collectionToAdd);
                userDTO.setAvailableExerciseCollection(availableExerciseCollection);
                userRepository.save(toEntity(userDTO));
            }
    }


    public void removeFromAvailableCollections(Principal principal, Long collectionId) {
        User user = userRepository.findByUsername(principal.getName());
        List<ExerciseCollection> availableExerciseCollection = user.getAvailableExerciseCollection();
        ExerciseCollectionDTO collectionToRemove = exerciseCollectionService.findById(collectionId);

            availableExerciseCollection.remove(collectionToRemove);
            user.setAvailableExerciseCollection(availableExerciseCollection);
            userRepository.save(user);

            String token = UUID.randomUUID().toString();
            tokenService.createToken(user, token);

            emailService.sendSimpleMessage(user.getEmail(), "Aktywacja konta",
                    "Aby dokończyć proces rejestracji, kliknij w poniższy link: \n " +
                            "https://dwaxdwa.herokuapp.com/activate?token=" + token);
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
