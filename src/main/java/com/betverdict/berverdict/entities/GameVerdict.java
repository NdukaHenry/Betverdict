package com.betverdict.berverdict.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class GameVerdict {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long gameVerdictId;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;

	private String team1Name;
	private String team2Name;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image1;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image2;
	@OneToMany(targetEntity = VerdictAnalysis.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "gameAnalysisId", referencedColumnName = "gameVerdictId")
	private List<VerdictAnalysis> analysis;
	private String verdict;

	public GameVerdict() {
		super();
	}

	public GameVerdict(Date date, String team1Name, String team2Name, String image1, String image2,
			List<VerdictAnalysis> analysis, String verdict) {
		super();
		this.date = date;
		this.team1Name = team1Name;
		this.team2Name = team2Name;
		this.image1 = image1;
		this.image2 = image2;
		this.analysis = analysis;
		this.verdict = verdict;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getGameVerdictId() {
		return gameVerdictId;
	}

	public void setGameVerdictId(Long id) {
		gameVerdictId = id;
	}

	public String getTeam1Name() {
		return team1Name;
	}

	public void setTeam1Name(String team1Name) {
		this.team1Name = team1Name;
	}

	public String getTeam2Name() {
		return team2Name;
	}

	public void setTeam2Name(String tean2Name) {
		this.team2Name = tean2Name;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public List<VerdictAnalysis> getAnalysis() {
		return analysis;
	}

	public void setAnalysis(List<VerdictAnalysis> analysis) {
		this.analysis = analysis;
	}

	public String getVerdict() {
		return verdict;
	}

	public void setVerdict(String verdict) {
		this.verdict = verdict;
	}
}
