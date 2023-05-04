package com.AAIT.Runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.AAIT.Entity.CitizenPlan;
import com.AAIT.Repository.CitizenPlanRepository;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private CitizenPlanRepository cpRepo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
		//To delete all existing records
		cpRepo.deleteAll();
		
		//Cash Plan data
		CitizenPlan c1= new CitizenPlan();
		c1.setCitizenName("AAA");
		c1.setGender("Male");
		c1.setPlanName("Cash");
		c1.setPlanStatus("Approved");
		c1.setStartDate(LocalDate.now());
		c1.setEndDate(LocalDate.now().plusWeeks(6));
		c1.setBenifitAmount(5000.00);
		
		CitizenPlan c2= new CitizenPlan();
		c2.setCitizenName("BBB");
		c2.setGender("Male");
		c2.setPlanName("Cash");
		c2.setPlanStatus("Denined");
		c2.setDenialReason("Rental Income");
		
		CitizenPlan c3= new CitizenPlan();
		c3.setCitizenName("CCC");
		c3.setGender("Female");
		c3.setPlanName("Cash");
		c3.setPlanStatus("Terminated");
		c3.setStartDate(LocalDate.now().minusMonths(4));
		c3.setEndDate(LocalDate.now().plusWeeks(6));
		c3.setBenifitAmount(6000.00);
		c3.setTerminatedDate(LocalDate.now());
		c3.setTerminationReason("Employeed");
		
		//Food Plan data
		CitizenPlan c4= new CitizenPlan();
		c4.setCitizenName("DDD");
		c4.setGender("Male");
		c4.setPlanName("Food");
		c4.setPlanStatus("Approved");
		c4.setStartDate(LocalDate.now());
		c4.setEndDate(LocalDate.now().plusWeeks(6));
		c4.setBenifitAmount(7000.00);
		
		CitizenPlan c5= new CitizenPlan();
		c5.setCitizenName("EEE");
		c5.setGender("Male");
		c5.setPlanName("Food");
		c5.setPlanStatus("Denined");
		c5.setDenialReason("Capital Income");
		
		CitizenPlan c6= new CitizenPlan();
		c6.setCitizenName("FFF");
		c6.setGender("Female");
		c6.setPlanName("Food");
		c6.setPlanStatus("Terminated");
		c6.setStartDate(LocalDate.now().minusMonths(3));
		c6.setEndDate(LocalDate.now().plusWeeks(6));
		c6.setBenifitAmount(8000.00);
		c6.setTerminatedDate(LocalDate.now());
		c6.setTerminationReason("Pensioner");
		
		
		//Medical Plan details 
		CitizenPlan c7= new CitizenPlan();
		c7.setCitizenName("GGG");
		c7.setGender("Female");
		c7.setPlanName("Medical");
		c7.setPlanStatus("Approved");
		c7.setStartDate(LocalDate.now());
		c7.setEndDate(LocalDate.now().plusWeeks(6));
		c7.setBenifitAmount(4000.00);
		
		CitizenPlan c8= new CitizenPlan();
		c8.setCitizenName("HHH");
		c8.setGender("Male");
		c8.setPlanName("Medical");
		c8.setPlanStatus("Denined");
		c8.setDenialReason("No proper documents submitted");
		
		CitizenPlan c9= new CitizenPlan();
		c9.setCitizenName("III");
		c9.setGender("Female");
		c9.setPlanName("Medical");
		c9.setPlanStatus("Terminated");
		c9.setStartDate(LocalDate.now().minusMonths(4));
		c9.setEndDate(LocalDate.now().plusWeeks(6));
		c9.setBenifitAmount(6000.00);
		c9.setTerminatedDate(LocalDate.now());
		c9.setTerminationReason("Having another plan");
		
		//Employment Plan data
		CitizenPlan c10= new CitizenPlan();
		c10.setCitizenName("JJJ");
		c10.setGender("Male");
		c10.setPlanName("Employment");
		c10.setPlanStatus("Approved");
		c10.setStartDate(LocalDate.now());
		c10.setEndDate(LocalDate.now().plusWeeks(6));
		c10.setBenifitAmount(7000.00);
		
		CitizenPlan c11= new CitizenPlan();
		c11.setCitizenName("KKK");
		c11.setGender("Female");
		c11.setPlanName("Employment");
		c11.setPlanStatus("Denined");
		c11.setDenialReason("Gov Employee");
		
		CitizenPlan c12= new CitizenPlan();
		c12.setCitizenName("LLL");
		c12.setGender("Female");
		c12.setPlanName("Employment");
		c12.setPlanStatus("Terminated");
		c12.setStartDate(LocalDate.now().minusMonths(5));
		c12.setEndDate(LocalDate.now().plusWeeks(6));
		c12.setBenifitAmount(8000.00);
		c12.setTerminatedDate(LocalDate.now());
		c12.setTerminationReason("Not a Perminent Job");

		List<CitizenPlan> lst = Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);
		cpRepo.saveAll(lst);
	}

}
