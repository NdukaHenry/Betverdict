package com.betverdict.berverdict.dto;

import java.util.ArrayList;
import java.util.List;

import com.betverdict.berverdict.entities.VerdictAnalysis;

public class VerdictAnalysisListCompiler {
	private List<VerdictAnalysis> analysisList = new ArrayList<>();

	public VerdictAnalysisListCompiler() {
		super();
	}

	public VerdictAnalysisListCompiler(List<VerdictAnalysis> analysisList) {
		super();
		this.analysisList = analysisList;
	}

	public List<VerdictAnalysis> getAnalysisList() {
		return analysisList;
	}

	public void setAnalysisList(List<VerdictAnalysis> analysisList) {
		this.analysisList = analysisList;
	}

	public void addAnalysisToList(VerdictAnalysis verdictAnalysis) {

		this.analysisList.add(verdictAnalysis);

	}
}
