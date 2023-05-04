package com.AAIT.Service.Impl;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.AAIT.Entity.CitizenPlan;
import com.AAIT.Repository.CitizenPlanRepository;
import com.AAIT.Request.SearchRequest;
import com.AAIT.Service.ReportsService;
import com.AAIT.Utils.EmailUtils;
import com.AAIT.Utils.ExcelGenerator;
import com.AAIT.Utils.PdfGenerator;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportServiceImpl implements ReportsService {

	@Autowired
	private CitizenPlanRepository cpRepo;
	
	@Autowired
	private EmailUtils emailUtils;
	
	@Autowired
	private PdfGenerator pdfGenerator;
	
	@Autowired
	private ExcelGenerator exlGenerator;

		
	@Override
	public List<String> getPlanNames() {
		// TODO Auto-generated method stub
		List<String> planNames = cpRepo.getPlanName(); 
		return planNames;
	}

	@Override
	public List<String> getPlanStatuses() {
		// TODO Auto-generated method stub
		List<String> planStatus = cpRepo.getPlanStatus();
		return planStatus;
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		// TODO Auto-generated method stub
		CitizenPlan entity = new CitizenPlan();
		if(null != request.getPlanName() && !"".equals(request.getPlanName()))
		{
			entity.setPlanName(request.getPlanName());
		}
		if(null != request.getPlanStatus() && !"".equals(request.getPlanStatus()))
		{
			entity.setPlanStatus(request.getPlanStatus());
		}
		if(null != request.getGender() && !"".equals(request.getGender()))
		{
			entity.setGender(request.getGender());
		}
		if(null != request.getStartDate() && !"".equals(request.getStartDate()))
		{
			//To convert the date format
			String startDate = request.getStartDate();
			//Date Time formatter in Java
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			//To convert String to Local date
			LocalDate localDate = LocalDate.parse(startDate, formatter);
						
			entity.setStartDate(localDate);
		}
		
		//returns all the records without any filter
		//return cpRepo.findAll();
		
		//return selected fields or records only by applying filter using Example.of() method
		return cpRepo.findAll(Example.of(entity));
	}

	@Override
	public boolean exportToExcel(HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		List<CitizenPlan> records = cpRepo.findAll();
		File file=new File("plans.xls");
		
		exlGenerator.generate(response, records,file);
				
		String subject="Test mail subject";
		String body="<h1>Test mail Body</h1>";
		String to="nishant8064@gmail.com";
		
		
		emailUtils.sandMail(subject, body, to,file);
		
		file.delete();
		
		return true;	
	}

	@Override
	public boolean exportToPdf(HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		File file=new File("plans.pdf");
		List<CitizenPlan> records = cpRepo.findAll();

		pdfGenerator.generate(response, records,file);
		
		String subject="Test mail subject";
		String body="<h1>Test mail Body</h1>";
		String to="nishant8064@gmail.com";
				
		emailUtils.sandMail(subject, body, to,file);
		
		file.delete();
		
		return true;	}

	

}
