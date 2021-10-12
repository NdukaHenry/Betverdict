package com.betverdict.berverdict.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String teamName;
	private String teamLeague;

	public Team(String teamName) {
		super();
		this.teamName = teamName;
	}

	public Team(Long id, String teamName, String teamLeague) {
		super();
		this.id = id;
		this.teamName = teamName;
		this.teamLeague = teamLeague;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamLeague() {
		return teamLeague;
	}

	public void setTeamLeague(String teamLeague) {
		this.teamLeague = teamLeague;
	}

}
