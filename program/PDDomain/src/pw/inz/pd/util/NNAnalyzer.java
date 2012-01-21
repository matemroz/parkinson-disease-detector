package pw.inz.pd.util;

public class NNAnalyzer {
	
	public static final String PREDICTED_STATE_TOKEN="PredictedState=";
	
	public static String getPatientStatus(String commandNNOutput) {
		if(commandNNOutput.startsWith(PREDICTED_STATE_TOKEN))
			return commandNNOutput.substring(15);
		return null;
	}
}
