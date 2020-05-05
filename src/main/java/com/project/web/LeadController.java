package com.project.web;


import com.project.Service.LeadService;
import com.project.entity.Lead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class LeadController {

    @Autowired
    LeadService leadService;

    @RequestMapping(value = "/leads", method = RequestMethod.GET)
    public List<Lead> getAllLeads() {
        return leadService.getAllLeads();
    }


}
	    
	    
	   


