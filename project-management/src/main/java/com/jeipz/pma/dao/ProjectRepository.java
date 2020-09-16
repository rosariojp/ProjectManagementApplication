package com.jeipz.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jeipz.pma.dto.ChartData;
import com.jeipz.pma.dto.TimeChartData;
import com.jeipz.pma.entities.Project;

@RepositoryRestResource(collectionResourceRel = "apiprojects", path = "apiprojects")
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {

	@Override
	public List<Project> findAll();

	public Project findByProjectId(long id);
	
	@Query(nativeQuery = true, value = "SELECT stage AS label, COUNT(*) AS value " + 
			"FROM project " + 
			"GROUP BY stage")
	public List<ChartData> getProjectStatus();

	@Query(nativeQuery = true, value = "SELECT name AS projectName, start_date AS startDate, end_date AS endDate " +
			"FROM project " +
			"WHERE start_date IS NOT NULL")
	public List<TimeChartData> getTimeData();
	
}
