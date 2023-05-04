package com.AAIT.Service;

import java.util.List;

import com.AAIT.Entity.CitizenPlan;
import com.AAIT.Request.SearchRequest;

import jakarta.servlet.http.HttpServletResponse;

public interface ReportsService {

	//1. Method to get plan Name DropDowm
	public List<String> getPlanNames();
	
	//2. Method to get plan Status DropDowm
	public List<String> getPlanStatuses();
	
	//3. Method to perform search operation
	public List<CitizenPlan> search(SearchRequest request);
	
	//4. Method to generate/Export Excel File
	public boolean exportToExcel(HttpServletResponse response) throws Exception;
	
	//5. Method to generate/Export PDF File
	public boolean exportToPdf(HttpServletResponse response)throws Exception;


	
}
