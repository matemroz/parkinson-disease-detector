package pw.inz.pd.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class AnalyzeVoiceFileReader {

	private File analyzedVoiceFile;
	private HashMap<String, String> voiceParamsMapResult;
	public static final String PARSE_DELIMITER = "[	]";
	public static final int PD_VARIABLES_AMOUNT = 5;
	
	public AnalyzeVoiceFileReader(File analyzedVoiceFile) {
		this.analyzedVoiceFile = analyzedVoiceFile;
	}

	public HashMap<String, String> getVoiceParamsMapResult(){
		addVoiceParamsResult();
		return this.voiceParamsMapResult;
	}
	
	private void addVoiceParamsResult() {
		String[] voiceParamsResult = readVoiceParamsResult();
		voiceParamsMapResult = new HashMap<String, String>();
		if(voiceParamsMapResult != null && voiceParamsResult != null 
				&& voiceParamsResult.length == PD_VARIABLES_AMOUNT){
			voiceParamsMapResult.put("jitter_ddp", voiceParamsResult[0]);
			voiceParamsMapResult.put("shimmer_apq3", voiceParamsResult[1]);
			voiceParamsMapResult.put("shimmer_apq5", voiceParamsResult[2]);
			voiceParamsMapResult.put("shimmer_dda", voiceParamsResult[3]);
			voiceParamsMapResult.put("hnr", voiceParamsResult[4]);
		}
	}

	private String[] readVoiceParamsResult() {
		if (!analyzedVoiceFile.exists()) {
			System.err.println("Plik " + analyzedVoiceFile.getName()
					+ " z wynikami analizy nie istnieje");
			return null;
		}

		try {
			BufferedReader in = new BufferedReader(new FileReader(
					analyzedVoiceFile));
			String line;
			String[] tokens = null;
			while ((line = in.readLine()) != null)
				tokens = line.split(PARSE_DELIMITER);
			return tokens;
		} catch (IOException e) {
			System.err.println("Problem z otwarciem pliku "
					+ analyzedVoiceFile.getName() + " do czytania.");
			e.printStackTrace();
		}
		return null;
	}
}
