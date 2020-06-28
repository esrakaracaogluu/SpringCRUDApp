package com.esra.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "MUSTERI")
public class Kullanici {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@NotEmpty(message = "L�tfen kullan�c� ad� giriniz!")
	@Column(name = "username")
	private String username;
	
	@NotEmpty(message = "L�tfen �ifre giriniz!")
	@Column(name = "password")
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Kullanici(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Kullanici() {
		super();
	}

}
