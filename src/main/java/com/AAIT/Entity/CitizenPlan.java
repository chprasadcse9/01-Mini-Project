package com.AAIT.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Citizen_Plan_Info")
public class CitizenPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer citezenId;
	private String citizenName;
	private String gender;
	private String planName;
	private String planStatus;
	private LocalDate startDate;
	private LocalDate endDate;
	private Double benifitAmount;
	private String denialReason;
	private LocalDate terminatedDate;
	private String terminationReason;
	
	public CitizenPlan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CitizenPlan(Integer citezenId, String citizenName, String gender, String planName, String planStatus,
			LocalDate startDate, LocalDate endDate, Double benifitAmount, String denialReason, LocalDate terminatedDate,
			String terminationReason) {
		super();
		this.citezenId = citezenId;
		this.citizenName = citizenName;
		this.gender = gender;
		this.planName = planName;
		this.planStatus = planStatus;
		this.startDate = startDate;
		this.endDate = endDate;
		this.benifitAmount = benifitAmount;
		this.denialReason = denialReason;
		this.terminatedDate = terminatedDate;
		this.terminationReason = terminationReason;
	}

	@Override
	public String toString() {
		return "CitizenPlan [citezenId=" + citezenId + ", citizenName=" + citizenName + ", gender=" + gender
				+ ", planName=" + planName + ", planStatus=" + planStatus + ", startDate=" + startDate + ", endDate="
				+ endDate + ", benifitAmount=" + benifitAmount + ", denialReason=" + denialReason + ", terminatedDate="
				+ terminatedDate + ", terminationReason=" + terminationReason + "]";
	}
	
	
		
}