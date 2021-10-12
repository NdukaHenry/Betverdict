package com.betverdict.berverdict.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betverdict.berverdict.entities.Tips;
import com.betverdict.berverdict.repositories.TipsRepository;

@Service
public class TipsServiceImpl implements TipsService {

	@Autowired
	private TipsRepository tipsRepository;
	// Milliseconds in a day
	private static final long ONE_DAY_MILLI_SECONDS = 24 * 60 * 60 * 1000;

	@Override
	public void createTip(Tips tips) {
		this.tipsRepository.save(tips);
	}

	@Override
	public List<Tips> getAllTips() {

		return tipsRepository.findAll();
	}

	@Override
	public Tips getTipById(Long id) {
		final Optional<Tips> optional = tipsRepository.findById(id);
		Tips tips = null;
		if (optional.isPresent()) {
			tips = optional.get();
		} else {
			throw new RuntimeException("Tip not found");
		}
		return tips;
	}

	@Override
	public void deleteTipById(Long id) {
		tipsRepository.deleteById(id);


	}

	@Override
	public void updateTip(Long id, Tips tips) {
		for (int i = 0; i < tipsRepository.count(); i++) {

			Tips t = tipsRepository.getById((long) i);
			if (t.getId().equals(id)) {
				t = tips;
				tipsRepository.save(tips);
			}
		}

	}

	@Override
	public List<Tips> getCurrentTips() {
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date d = java.util.Calendar.getInstance().getTime();
		final String input = sdf.format(d);
		try {
			d = sdf.parse(input);
		} catch (final ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		final List<Tips> list = tipsRepository.findCurrentTips(d);


		return list;

	}

	@Override
	public List<Tips> getPastTips() {
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		final Date d = java.util.Calendar.getInstance().getTime();
		final long previousDayMilliSeconds = d.getTime() - ONE_DAY_MILLI_SECONDS;
		Date prevDate = new Date(previousDayMilliSeconds);
		final String input = sdf.format(prevDate);
		try {
			prevDate = sdf.parse(input);
		} catch (final ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final List<Tips> list = tipsRepository.findCurrentTips(prevDate);

		return list;
	}

	@Override
	public List<Tips> getFutureTips() {
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		final Date d = java.util.Calendar.getInstance().getTime();
		final long previousDayMilliSeconds = d.getTime() + ONE_DAY_MILLI_SECONDS;
		Date nextDate = new Date(previousDayMilliSeconds);
		final String input = sdf.format(nextDate);
		try {
			nextDate = sdf.parse(input);
		} catch (final ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final List<Tips> list = tipsRepository.findCurrentTips(nextDate);

		return list;
	}


}
