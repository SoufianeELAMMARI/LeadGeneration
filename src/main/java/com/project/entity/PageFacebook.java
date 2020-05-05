package com.project.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class PageFacebook implements Serializable {
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="titre",length=30)
	private String titre;
	
	@Column(name="description",length=60)
	private String description;
	
	@Column(name="url",length=100)
	private String url;
	
	@Column(name="accessToken",length=255)
	private String accessToken;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateCreation;
	
}
