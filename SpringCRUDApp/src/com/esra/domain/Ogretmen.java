package com.esra.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Ogretmen")
public class Ogretmen {
	@Id
	@Column(name="id")
	@SequenceGenerator(name = "ogretmen_seq", sequenceName = "SEQ_OGRETMEN", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ogretmen_seq")
	private Integer ogrId;
	
	@Column(name = "FIRST_NAME")
	private String ogretmenName;
	
	@Column(name = "LAST_NAME")
	private String ogretmenSoyad;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "OGRETMENDETAY_ID")
	private Integer ogretmenDetayId;

	public Integer getOgrId() {
		return ogrId;
	}

	public void setOgrId(Integer ogrId) {
		this.ogrId = ogrId;
	}

	public String getOgretmenName() {
		return ogretmenName;
	}

	public void setOgretmenName(String ogretmenName) {
		this.ogretmenName = ogretmenName;
	}

	public String getOgretmenSoyad() {
		return ogretmenSoyad;
	}

	public void setOgretmenSoyad(String ogretmenSoyad) {
		this.ogretmenSoyad = ogretmenSoyad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getOgretmenDetayId() {
		return ogretmenDetayId;
	}

	public void setOgretmenDetayId(Integer ogretmenDetayId) {
		this.ogretmenDetayId = ogretmenDetayId;
	}

	public Ogretmen(String ogretmenName, String ogretmenSoyad, String email, Integer ogretmenDetayId) {
		super();
		this.ogretmenName = ogretmenName;
		this.ogretmenSoyad = ogretmenSoyad;
		this.email = email;
		this.ogretmenDetayId = ogretmenDetayId;
	}

	public Ogretmen() {
		super();
	}

}
