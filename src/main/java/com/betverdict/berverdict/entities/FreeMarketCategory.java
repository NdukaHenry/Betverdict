package com.betverdict.berverdict.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FreeMarketCategory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String marketName;
	private Integer ratingAverage;

	public FreeMarketCategory() {
		super();
	}

	public FreeMarketCategory(String marketName) {
		super();
		this.marketName = marketName;
	}

	public FreeMarketCategory(Long id, String marketName, Integer ratingAverage) {
		super();
		this.id = id;
		this.marketName = marketName;
		this.ratingAverage = ratingAverage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public Integer getRatingAverage() {
		return ratingAverage;
	}

	public void setRatingAverage(Integer ratingAverage) {
		this.ratingAverage = ratingAverage;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof FreeMarketCategory)) {
			return false;
		}
		final FreeMarketCategory other = (FreeMarketCategory) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

}
