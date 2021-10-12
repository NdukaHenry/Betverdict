package com.betverdict.berverdict.entities;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class SpecialMarketRating {
	@Id
	private String userId;
	private Integer ratingInde;
	private String marketTpe;

	public SpecialMarketRating(String userId) {
		super();
		this.userId = userId;
	}

	public SpecialMarketRating(String userId, Integer ratingInde, String marketTpe) {
		super();
		this.userId = userId;
		this.ratingInde = ratingInde;
		this.marketTpe = marketTpe;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getRatingInde() {
		return ratingInde;
	}

	public void setRatingInde(Integer ratingInde) {
		this.ratingInde = ratingInde;
	}

	public String getMarketTpe() {
		return marketTpe;
	}

	public void setMarketTpe(String marketTpe) {
		this.marketTpe = marketTpe;
	}

}