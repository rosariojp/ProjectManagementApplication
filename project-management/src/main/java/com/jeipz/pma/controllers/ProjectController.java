package com.jeipz.pma.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeipz.pma.entities.Employee;
import com.jeipz.pma.entities.Project;
import com.jeipz.pma.services.EmployeeService;
import com.jeipz.pma.services.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	ProjectService proService;
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projects = proService.getAll();
		model.addAttribute("projectsList", projects);
		return "projects/list-projects";
	}
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		Project aProject = new Project();
		List<Employee> employees = empService.getAll();
		model.addAttribute("project", aProject);
		model.addAttribute("allEmployees", employees);
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Model model, @Valid Project project, Errors errors) {
		if (errors.hasErrors()) {
			List<Employee> employees = empService.getAll();
			model.addAttribute("allEmployees", employees);
			return "projects/new-project";
		}
		proService.save(project);
		return "redirect:/projects";
	}
	
	@GetMapping("/update")
	public String displayProjectUpdateForm(Model model, @RequestParam("id") long id) {
		Project project = proService.findByProjectId(id);
		List<Employee> employees = empService.getAll();
		model.addAttribute("project", project);
		model.addAttribute("allEmployees", employees);
		return "projects/new-project";
	}
	
	@GetMapping("/delete")
	public String deleteProject(Model model, @RequestParam("id") long id) {
		Project project = proService.findByProjectId(id);
		proService.delete(project);
		return "redirect:/projects";
	}
	
}
