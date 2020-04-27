package pl.joanna026.dwaxdwa.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.joanna026.dwaxdwa.common.BusinessException;
import pl.joanna026.dwaxdwa.persistence.dto.UserDto;
import pl.joanna026.dwaxdwa.persistence.entity.User;
import pl.joanna026.dwaxdwa.persistence.mapper.UserMapper;
import pl.joanna026.dwaxdwa.persistence.repository.UserRepository;
import pl.joanna026.dwaxdwa.persistence.service.UserService;
import pl.joanna026.dwaxdwa.persistence.validator.UserValidator;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private UserMapper userMapper;

    private UserValidator userValidator;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, UserValidator userValidator) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userValidator = userValidator;
    }

    @Override
    public List<UserDto> findAll() {
        return userMapper.mapToDto(userRepository.findAll());
    }

    @Override
    public UserDto findById(Long id) {
        if(id == null) {
            throw new BusinessException("Given id cannot be null");
        }
        User user = userRepository.findById((id))
        .orElseThrow(() -> new BusinessException(
                "User with id " + id + "not found in repository"
        ));
        return userMapper.mapToDto(user);
    }

    @Override
    public UserDto save(UserDto userDto) {
        userValidator.validate(userDto);
        User user = userMapper.mapToEntity(userDto);
        return userMapper.mapToDto(user);
    }

    @Override
    public UserDto update(UserDto userDto) {
        return save(userDto);
    }

    @Override
    public void delete(Long id) {
        if(id == null) {
            throw new BusinessException("Given id cannot be null");
        }
        User user = userRepository.findById((id))
                .orElseThrow(() -> new BusinessException(
                        "User with id " + id + "not found in repository"
                ));
        userRepository.deleteById(user.getId());
    }
}
