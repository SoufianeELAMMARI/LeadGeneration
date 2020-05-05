package com.project.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Lead implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="nom",length=30)
	private String nom;
	
	@Column(name="prenom",length=30)
	private String prenom;
	
	@Column(name="photo",length=200)
	private String photo;
	
	@Column(name="email",length=30)
	private String email;
	
	@Column(name="phone",length=30)
	private String phone ;

	@Column(name="mobile",length=30)
	private String mobile;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateCreation;
	
	@Column(name="statut",length=50)
	private String statut;
	
	@Column(name="idFacebook",length=50)
	private String idFacebook;
	
	@Column(name="idYoutube",length=50)
	private String idYoutube;
	
	@Column(name="scoreFacebook",length=5)
	private int scoreFacebook;
	
	@Column(name="scoreYoutube",length=5)
	private int scoreYoutube;
	
	@Column(name="scoreTotal",length=5)
	private int score;
	
	@Column(name="adresse",length=50)
	private String adresse;
	
	@Column(name="ville",length=50)
	private String ville;
	
	@Column(name="pays",length=50)
	private String pays;
	
	@Column(name="latitude",length=50)
	private float latitude;
	
	@Column(name="longitude",length=50)
	private float longitude;

	
	public Lead() {
		super();
	}


	public Lead( String nom, String prenom, String photo, String email, String phone, String mobile,
			Date dateCreation, String statut, String idFacebook, String idYoutube, int scoreFacebook, int scoreYoutube,
			int score, String adresse, String ville, String pays, float latitude, float longitude) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.photo = photo;
		this.email = email;
		this.phone = phone;
		this.mobile = mobile;
		this.dateCreation = dateCreation;
		this.statut = statut;
		this.idFacebook = idFacebook;
		this.idYoutube = idYoutube;
		this.scoreFacebook = scoreFacebook;
		this.scoreYoutube = scoreYoutube;
		this.score = score;
		this.adresse = adresse;
		this.ville = ville;
		this.pays = pays;
		this.latitude = latitude;
		this.longitude = longitude;
	}


	public long getId() {
		return id;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getIdFacebook() {
		return idFacebook;
	}

	public void setIdFacebook(String idFacebook) {
		this.idFacebook = idFacebook;
	}

	public String getIdYoutube() {
		return idYoutube;
	}

	public void setIdYoutube(String idYoutube) {
		this.idYoutube = idYoutube;
	}

	public int getScoreFacebook() {
		return scoreFacebook;
	}

	public void setScoreFacebook(int scoreFacebook) {
		this.scoreFacebook = scoreFacebook;
	}

	public int getScoreYoutube() {
		return scoreYoutube;
	}

	public void setScoreYoutube(int scoreYoutube) {
		this.scoreYoutube = scoreYoutube;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
	
}
