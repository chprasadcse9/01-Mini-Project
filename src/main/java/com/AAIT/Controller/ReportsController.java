package com.AAIT.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.AAIT.Entity.CitizenPlan;
import com.AAIT.Request.SearchRequest;
import com.AAIT.Service.ReportsService;

import jakarta.servlet.http.HttpServletResponse;


@Controller
public class ReportsController {

	@Autowired
	private ReportsService service;
	

	//Get the index page
	@GetMapping("/")
	public String indexPage(Model model)
	{
		//SearchRequest searchObj = new SearchRequest();
		model.addAttribute("search",new SearchRequest());
		init(model);
		return "index";
		
	}
	@PostMapping("/search")
	public String handleSearch(SearchRequest search, Model model)
	{
		//Print the output fields
		//System.out.println(request);
		
		List<CitizenPlan> plans = service.search(search);
		//to add plan details to UI
		model.addAttribute("plans",plans);
		//to add Search result to UI
		model.addAttribute("search",search);
		init(model);
		return "index";
		
	}

	
	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response) throws Exception {
		 
		response.setContentType("application/pdf");
		
		response.addHeader("Content-Disposition", "attachment;filename=plans.pdf");
		service.exportToPdf(response);
		
	}
	
	@GetMapping("/excel")
	public void excelExport(HttpServletResponse response) throws Exception {
		 
		response.setContentType("application/octet-stream");
		
		response.addHeader("Content-Disposition", "attachment;filename=plans.xls");
		service.exportToExcel(response);
		
	}
	
	private void init(Model model) {
		model.addAttribute("names",service.getPlanNames());
		model.addAttribute("statuses",service.getPlanStatuses());
	}
}
