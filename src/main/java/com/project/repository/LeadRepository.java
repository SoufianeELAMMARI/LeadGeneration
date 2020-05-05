
package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.entity.Lead;
import java.lang.String;

public interface LeadRepository extends JpaRepository<Lead,Long> {

	Lead findByIdYoutube(String idyoutube);

	Lead findByIdFacebook(String idfacebook);
}

