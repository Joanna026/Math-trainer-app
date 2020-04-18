package pl.joanna026.dwaxdwa.persistence.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import pl.joanna026.dwaxdwa.persistence.dto.GroupDto;
import pl.joanna026.dwaxdwa.persistence.entity.Group;

@Component
public class GroupMapper extends AbstractMapper<GroupDto, Group> {

	private final ModelMapper modelMapper = new ModelMapper();

	@Override
	public GroupDto mapToDto(Group group) {
		return modelMapper.map(group, GroupDto.class);
	}

	@Override
	public Group mapToEntity(GroupDto dto) {
		return modelMapper.map(dto, Group.class);
	}

}
