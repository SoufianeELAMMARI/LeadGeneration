package com.project.dto.Facebook;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class posts {
	
	       public List<data> data;
	       @JsonIgnore
	       public List<paging> paging;
	       }
