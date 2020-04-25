package pl.joanna026.dwaxdwa.persistence.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import pl.joanna026.dwaxdwa.common.BusinessException;
import pl.joanna026.dwaxdwa.persistence.dto.GroupDto;
import pl.joanna026.dwaxdwa.persistence.entity.Group;
import pl.joanna026.dwaxdwa.persistence.mapper.GroupMapper;
import pl.joanna026.dwaxdwa.persistence.repository.GroupRepository;
import pl.joanna026.dwaxdwa.persistence.service.GroupService;
import pl.joanna026.dwaxdwa.persistence.validator.GroupValidator;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {

	private GroupRepository groupRepository;

	private GroupMapper groupMapper;

	private GroupValidator groupValidator;

	public GroupServiceImpl(GroupRepository groupRepository, GroupMapper groupMapper,
			GroupValidator groupValidator) {
		this.groupRepository = groupRepository;
		this.groupMapper = groupMapper;
		this.groupValidator = groupValidator;
	}

	@Override
	public GroupDto findById(Long id) throws BusinessException {
		if (id == null) {
			throw new BusinessException("Given id cannot be null");
		}
		Group group = groupRepository.findById(id)
				.orElseThrow(() -> new BusinessException(
						"Group with id " + id + "not found in repository"));
		return groupMapper.mapToDto(group);
	}

	@Override
	public List<GroupDto> findAll() {
		return groupMapper.mapToDto(groupRepository.findAll());
	}

	@Override
	public GroupDto save(GroupDto groupDto) {
		groupValidator.validate(groupDto);
		Group group = groupMapper.mapToEntity(groupDto);
		return groupMapper.mapToDto(groupRepository.save(group));
	}

	@Override
	public GroupDto update(GroupDto groupDto) {
		return save(groupDto);
	}

	@Override
	public void delete(Long id) {
		if (id == null) {
			throw new BusinessException("Given id cannot be null");
		}
		Group group = groupRepository.findById(id)
				.orElseThrow(() -> new BusinessException(
						"Group with id " + id + "not found in repository"));
		groupRepository.deleteById(group.getId());
	}

}
