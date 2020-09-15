package com.jeipz.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jeipz.pma.dto.ChartData;
import com.jeipz.pma.entities.Project;

@RepositoryRestResource(collectionResourceRel = "apiprojects", path = "apiprojects")
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {

	@Override
	public List<Project> findAll();
	
	@Query(nativeQuery = true, value = "SELECT stage AS label, COUNT(*) AS value " + 
			"FROM project " + 
			"GROUP BY stage")
	public List<ChartData> getProjectStatus(); 
	
}
