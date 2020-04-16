package pl.joanna026.dwaxdwa.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class User extends AbstractEntity {

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String email;

	@Column
	private char[] password;
}
