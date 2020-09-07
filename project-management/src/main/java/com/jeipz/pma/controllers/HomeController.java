package com.jeipz.pma.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeipz.pma.dao.EmployeeRepository;
import com.jeipz.pma.dao.ProjectRepository;
import com.jeipz.pma.dto.ChartData;
import com.jeipz.pma.dto.EmployeeProject;
import com.jeipz.pma.entities.Project;

@Controller
public class HomeController {

	@Autowired
	ProjectRepository proRepo;

	@Autowired
	EmployeeRepository empRepo;

	@GetMapping("/")
	public String displayHomePage(Model model) throws JsonProcessingException {
		
		Map<String, Object> map = new HashMap<>();
		
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projectsList", projects);
		
		List<ChartData> projectData = proRepo.getProjectStatus();

		// Convert project Data to jason structure for use in javascript
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectData);
		
		model.addAttribute("projectStatusCount", jsonString);
		
		List<EmployeeProject> employeesProjectCount = empRepo.getEmployeeProjects();
		model.addAttribute("employeesListProjectsCount", employeesProjectCount);
		return "main/home";
	}

}
