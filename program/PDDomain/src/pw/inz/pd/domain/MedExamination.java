package pw.inz.pd.domain;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

public class MedExamination implements Serializable{

	private static final long serialVersionUID = 5436431624056441238L;
	private String medExDate;
	private String personalNum;
	private String voiceFileName;
	private double jitter_ddp;
	private double shimmer_apq3;
	private double shimmer_apq5;
	private double shimmer_dda;
	private double hnr;

	public String getPersonalNum() {
		return personalNum;
	}

	public void setPersonalNum(String personalNum) {
		this.personalNum = personalNum;
	}

	public String getVoiceFileName() {
		return voiceFileName;
	}

	public void setVoiceFileName(String voiceFileName) {
		this.voiceFileName = voiceFileName;
	}

	public String getMedExDate() {
		return medExDate;
	}

	public void setMedExDate(String medExDate) {
		this.medExDate = medExDate;
	}

	public double getJitter_ddp() {
		return jitter_ddp;
	}

	public void setJitter_ddp(double jitter_ddp) {
		this.jitter_ddp = jitter_ddp;
	}

	public double getShimmer_apq3() {
		return shimmer_apq3;
	}

	public void setShimmer_apq3(double shimmer_apq3) {
		this.shimmer_apq3 = shimmer_apq3;
	}

	public double getShimmer_apq5() {
		return shimmer_apq5;
	}

	public void setShimmer_apq5(double shimmer_apq5) {
		this.shimmer_apq5 = shimmer_apq5;
	}

	public double getShimmer_dda() {
		return shimmer_dda;
	}

	public void setShimmer_dda(double shimmer_dda) {
		this.shimmer_dda = shimmer_dda;
	}

	public double getHnr() {
		return hnr;
	}

	public void setHnr(double hnr) {
		this.hnr = hnr;
	}
}
