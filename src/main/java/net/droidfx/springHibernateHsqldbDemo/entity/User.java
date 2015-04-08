package net.droidfx.springHibernateHsqldbDemo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "USER_INFO", uniqueConstraints = {
		@UniqueConstraint(columnNames = "ID"),
		@UniqueConstraint(columnNames = "USERNAME"),
		@UniqueConstraint(columnNames = "EMAIL") })
@SequenceGenerator(name = "UserSeq", sequenceName = "USER_SEQ", allocationSize = 1)
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2117354794757002462L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserSeq")
	@Column(unique = true, nullable = false)
	private Integer id;
	@Column(unique = true, nullable = false, length = 100)
	private String username;
	@Column(unique = true, nullable = false, length = 100)
	private String email;
	@Column(nullable = false, length = 100)
	private String firstName;
	@Column(nullable = false, length = 100)
	private String lastName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email
				+ ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
