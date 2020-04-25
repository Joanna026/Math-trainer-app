package pl.joanna026.dwaxdwa.persistence.service;

import java.util.List;

import pl.joanna026.dwaxdwa.persistence.dto.GroupDto;

public interface GroupService {

	GroupDto findById(Long id);

	List<GroupDto> findAll();

	GroupDto save(GroupDto groupDto);

	GroupDto update(GroupDto groupDto);

	void delete(Long id);

}
