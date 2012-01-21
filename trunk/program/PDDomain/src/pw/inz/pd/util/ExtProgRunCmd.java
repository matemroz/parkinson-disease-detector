package pw.inz.pd.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExtProgRunCmd {
	
	public final static String RUN_CMD = "cmd /c";
	
	public static String run(String cmd) {
		cmd = RUN_CMD + " " + cmd;
		System.out.println("Running command: " + cmd);
		StringBuilder output = new StringBuilder();
		try {
			Process p = Runtime.getRuntime().exec(cmd);
			BufferedReader bri = new BufferedReader(new InputStreamReader(
					p.getInputStream()));
			BufferedReader bre = new BufferedReader(new InputStreamReader(
					p.getErrorStream()));
			String line = "";
			while ((line = bri.readLine()) != null){
				output.append(line);
				System.out.println(line);
			}
			bri.close();
			while ((line = bre.readLine()) != null){
				output.append(line);
				System.err.println(line);
			}
			bre.close();
			p.waitFor();
			System.out.println("Command Completed.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return output.toString();
	}
}