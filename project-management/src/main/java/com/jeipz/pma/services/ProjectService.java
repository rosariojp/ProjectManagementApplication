package com.jeipz.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeipz.pma.dao.ProjectRepository;
import com.jeipz.pma.dto.ChartData;
import com.jeipz.pma.entities.Project;

@Service
public class ProjectService {

	@Autowired
	ProjectRepository proRepo;
	
	public Project save(Project project) {
		return proRepo.save(project);
	}
	
	public List<Project> getAll() {
		return proRepo.findAll();
	}
	
	public List<ChartData> getProjectStatus() {
		return proRepo.getProjectStatus();
	}

	public Project findByProjectId(long id) {
		return proRepo.findByProjectId(id);
	}
	
}
