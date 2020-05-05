package com.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Source implements Serializable {
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="type",length=30)
	private int type;
	
	@Column(name="scoreEmail",length=11)
	private int scoreEmail;
	
	@Column(name="scorePhone",length=11)
	private int scorePhone;
	
	@Column(name="mentionJaimeScore",length=11)
	private int mentionJaimeScore;
	
	@Column(name="CommentaireFacebookScore",length=11)
	private int CommentaireFacebookScore;
	
	@Column(name="CommentaireYoutubeScore",length=11)
	private int CommentaireYoutubeScore;
	
	
	
}
