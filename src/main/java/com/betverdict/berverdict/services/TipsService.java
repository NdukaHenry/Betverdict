package com.betverdict.berverdict.services;

import java.util.List;

import com.betverdict.berverdict.entities.Tips;

public interface TipsService {
	void createTip(Tips tips);

	List<Tips> getAllTips();

	Tips getTipById(Long id);

	List<Tips> getCurrentTips();

	List<Tips> getPastTips();

	List<Tips> getFutureTips();
	void deleteTipById(Long id);

	void updateTip(Long id, Tips tips);
}
