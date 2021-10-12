package com.betverdict.berverdict.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VerdictAnalysis {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long AnalysisId;
	private String statName;
	private String statCategory;
	private Integer team1Point;
	private Integer team2Point;

	public VerdictAnalysis() {
		super();
	}

	public VerdictAnalysis(String statName, Integer team1Point, Integer team2Point) {

		this.statName = statName;
		this.team1Point = team1Point;
		this.team2Point = team2Point;
	}

	public VerdictAnalysis(String statName, String statCategory,
			Integer team1Point, Integer team2Point) {
		super();


		this.statName = statName;
		this.statCategory = statCategory;
		this.team1Point = team1Point;
		this.team2Point = team2Point;
	}

	public Long getAnalysisId() {
		return AnalysisId;
	}

	public void setAnalysisId(Long analysisId) {
		AnalysisId = analysisId;
	}

	public String getStatName() {
		return statName;
	}

	public void setStatName(String statName) {
		this.statName = statName;
	}

	public String getStatCategory() {
		return statCategory;
	}

	public void setStatCategory(String statCategory) {
		this.statCategory = statCategory;
	}

	public Integer getTeam1Point() {
		return team1Point;
	}

	public void setTeam1Point(Integer team1Point) {
		this.team1Point = team1Point;
	}

	public Integer getTeam2Point() {
		return team2Point;
	}

	public void setTeam2Point(Integer team2Point) {
		this.team2Point = team2Point;
	}


}
