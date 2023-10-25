package com.jrp.pma.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.dto.ChartData;
import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.entities.Project;
import com.jrp.pma.services.EmployeeService;
import com.jrp.pma.services.ProjectService;

@Controller
public class HomeController {
	
	@Value("${version}")
	private String ver;
	
	@Autowired
	ProjectService proService;
	
	@Autowired
	EmployeeService empService;
	
	//model interact with view. send and receive data from view
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		
		model.addAttribute("versionNumber", ver);
		
		Map<String, Object> map = new HashMap<>();
		
		// query the database for projects
		List<Project> projects = proService.getAll();
		model.addAttribute("projectsList", projects);
		
		//project status
		List<ChartData> projectData = proService.getProjectsStatus();
		
		// Covert projectData object into a JSON structure for use in JAVASCRIPT
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectData);
		//should like["NOTSTARTED", 1], ["INPROGERESS",2],["COMPLETED",1] label, value
		
		model.addAttribute("projectStatusCnt", jsonString);
		
		
		
		// query the database for employees
		List<EmployeeProject> employeesProjectCnt = empService.employeeProjects();
		model.addAttribute("employeesListProjectsCnt", employeesProjectCnt);
		
		
		return "main/home";
 	}
	
	
}
