package com.AAIT.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AAIT.Entity.CitizenPlan;


public interface CitizenPlanRepository extends JpaRepository<CitizenPlan, Integer> {

	//using findAll() predefined method to display entire data
	
	//To Display Distinct Plan Names
	@Query("SELECT DISTINCT c.planName FROM CitizenPlan c")
	//@Query("Select distinct(planName) from CitizenPaln")
	public List<String> getPlanName();
	
	//To display Distinct Plan Status
	@Query("SELECT DISTINCT c.planStatus FROM CitizenPlan c")
	//@Query("Select distinct(planStatus) from CitizenPlan")
	public List<String> getPlanStatus();
}
