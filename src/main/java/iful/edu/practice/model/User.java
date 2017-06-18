package iful.edu.practice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	public static final String ROLE_ADMIN = "ADMIN";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false)
	private int id;

	/*
	 * @NotNull
	 * 
	 * @Size(min = 5, max = 20)
	 */
	private String login;

	@Column(name = "user_name", nullable = false)
	/*
	 * @NotNull
	 * 
	 * @Size(min = 5, max = 20)
	 */
	private String name;

	/*
	 * @NotNull
	 * 
	 * @Size(min = 5, max = 20)
	 */
	private String password;

	/*
	 * @NotNull
	 * 
	 * @Size(min = 5, max = 20)
	 */
	private String email;

	private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
