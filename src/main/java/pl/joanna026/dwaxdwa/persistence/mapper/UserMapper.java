package pl.joanna026.dwaxdwa.persistence.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import pl.joanna026.dwaxdwa.persistence.dto.UserDto;
import pl.joanna026.dwaxdwa.persistence.entity.User;

@Component
public class UserMapper extends AbstractMapper<UserDto, User> {

	private final ModelMapper modelMapper = new ModelMapper();

	@Override
	public UserDto mapToDto(User user) {
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public User mapToEntity(UserDto dto) {
		return modelMapper.map(dto, User.class);
	}

}
