package pw.inz.pd.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class VoiceAnalyzer {

	public final static String VOICE_ANALYZER_SCRIPT = "C:\\pd_analyzer\\praat_scripts\\analyse_voice.praat";
	public final static String PRAAT_CMD = "C:\\pd_analyzer\\praat_scripts\\praatcon.exe";
	private File voiceFile;

	public VoiceAnalyzer(File voiceFile) {
		this.voiceFile = voiceFile;
	}

	public File getVoiceFile() {
		return voiceFile;
	}

	public void setVoiceFile(File voiceFile) {
		this.voiceFile = voiceFile;
	}

	public String getAnalyzedVoiceFileName(){
		return "" + this.voiceFile.getPath() + ".txt" + "";
	}
	
	public void makeVoiceAnalyze() {
		String analyzeVoiceCmd = createAnalyzedVoiceCmd();
		ExtProgRunCmd.run(analyzeVoiceCmd);
	}

	private String createAnalyzedVoiceCmd() {
		return PRAAT_CMD + " " + VOICE_ANALYZER_SCRIPT + " "
				+ this.voiceFile.getPath();
	}
}
