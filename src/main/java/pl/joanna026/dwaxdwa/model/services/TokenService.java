package pl.joanna026.dwaxdwa.model.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.joanna026.dwaxdwa.model.entities.User;
import pl.joanna026.dwaxdwa.model.entities.VerificationToken;
import pl.joanna026.dwaxdwa.model.repositories.TokenRepository;
import pl.joanna026.dwaxdwa.model.repositories.UserRepository;
import pl.joanna026.dwaxdwa.model.DTO.TokenDTO;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class TokenService {

    private final TokenRepository tokenRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public TokenService(TokenRepository tokenRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.tokenRepository = tokenRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    public void createToken(User user, String token) {
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setUser(user);
        verificationToken.setToken(token);
        tokenRepository.save(verificationToken);
    }

    public void findUserByTokenAndEnable(String token) {
        VerificationToken userToken = tokenRepository.findByToken(token);
        Optional<User> optionalUser = userRepository.findById(userToken.getUser().getId());
        optionalUser.ifPresent(user -> {
            user.setEnabled(true);
            userRepository.save(user);
        });
    }


    private TokenDTO toDto(VerificationToken verificationToken) {
        return modelMapper.map(verificationToken, TokenDTO.class);
    }

    private VerificationToken toEntity(TokenDTO tokenDTO) {
        return modelMapper.map(tokenDTO, VerificationToken.class);
    }
}
