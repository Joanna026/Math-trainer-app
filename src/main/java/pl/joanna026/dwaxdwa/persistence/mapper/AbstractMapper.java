package pl.joanna026.dwaxdwa.persistence.mapper;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractMapper<D, T> {

	public abstract D mapToDto(T t);

	public abstract T mapToEntity(D d);

	public List<D> mapToDto(List<T> list) {
		return list.stream().map(this::mapToDto).collect(Collectors.toList());
	}

	public List<T> mapToEntity(List<D> list) {
		return list.stream().map(this::mapToEntity).collect(Collectors.toList());
	}
}
