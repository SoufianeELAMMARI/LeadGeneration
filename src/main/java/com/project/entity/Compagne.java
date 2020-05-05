package com.project.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

    @Entity
    public class Compagne implements Serializable {
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="titre",length=30)
	private String titre;
	
	@Column(name="description",length=30)
	private String description;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dateDebut;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dateFin;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateCreation;
	
	
	
	
}
