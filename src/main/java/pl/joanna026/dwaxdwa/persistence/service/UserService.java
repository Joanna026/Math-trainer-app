package pl.joanna026.dwaxdwa.persistence.service;

import pl.joanna026.dwaxdwa.persistence.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();

    UserDto findById(Long id);

    UserDto save(UserDto userDto);

    UserDto update(UserDto userDto);

    void delete(Long id);
}
