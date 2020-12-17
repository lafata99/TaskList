package com.todo.TaskList.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="user")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // Username with unique constraint
    @Column(name = "username")
    private String username;
    
    @Column(name="last_name")
	private String lastName;
	
	@Column(name="first_name")
	private String firstName;
    
    @Column(name="email")
	private String email;

    @Column(name = "password")
    private String password;
    
    @Transient //used for validation, not to be persisted to database
	private String repeatpass;

    @Column(name = "role")
    private String role;
    
    @Transient
	MultipartFile file;
	private String image;
    
    public User() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepeatpass() {
		return repeatpass;
	}

	public void setRepeatpass(String repeatpass) {
		this.repeatpass = repeatpass;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", email=" + email + ", password=" + password + ", repeatpass=" + repeatpass + ", role=" + role
				+ ", file=" + file + ", image=" + image + "]";
	}

	
}
