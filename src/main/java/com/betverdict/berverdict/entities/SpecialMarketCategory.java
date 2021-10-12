package com.betverdict.berverdict.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author USER
 * 
 * @Entity
 * @Table(name = "specialmarketcartegory")
 * @XmlRootElement public class SpecialMarketCategory implements Serializable {
 * 
 *                 private static final long serialVersionUID = 1L;
 * @Id
 * @Basic(optional = false)
 * @NotNull
 * @Size(min = 1, max = 45)
 * @Column(name = "MarketName") private String marketName;
 * @Size(max = 45)
 * @Column(name = "RatingAvg") private String ratingAvg;
 * 
 *              public SpecialMarketCategory() { }
 * 
 *              public SpecialMarketCategory(String marketName) {
 *              this.marketName = marketName; }
 * 
 *              public String getMarketName() { return marketName; }
 * 
 *              public void setMarketName(String marketName) { this.marketName =
 *              marketName; }
 * 
 *              public String getRatingAvg() { return ratingAvg; }
 * 
 *              public void setRatingAvg(String ratingAvg) { this.ratingAvg =
 *              ratingAvg; }
 * 
 * @Override public int hashCode() { int hash = 0; hash += (marketName != null ?
 *           marketName.hashCode() : 0); return hash; }
 * 
 * @Override public boolean equals(Object object) { // TODO: Warning - this
 *           method won't work in the case the id fields are not set if
 *           (!(object instanceof SpecialMarketCategory)) { return false; }
 *           final SpecialMarketCategory other = (SpecialMarketCategory) object;
 *           if ((this.marketName == null && other.marketName != null) ||
 *           (this.marketName != null &&
 *           !this.marketName.equals(other.marketName))) { return false; }
 *           return true; }
 * 
 * @Override public String toString() { return "entities.SpecialMarketCategory[
 *           marketName=" + marketName + " ]"; }
 * 
 *           }
 **/
@Entity
public class SpecialMarketCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String marketName;
	private Integer ratingAverage;

	public SpecialMarketCategory() {
		super();
	}

	public SpecialMarketCategory(String marketName) {
		super();
		this.marketName = marketName;
	}

	public SpecialMarketCategory(Long id, String marketName, Integer ratingAverage) {
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
}
