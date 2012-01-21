package pw.inz.pd.web.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pw.inz.pd.db.dao.DB2MedExaminationDAO;
import pw.inz.pd.db.dao.DB2PatientDAO;
import pw.inz.pd.db.dao.MedExaminationDAO;
import pw.inz.pd.db.dao.PatientDAO;
import pw.inz.pd.db.utils.FormatConverter;
import pw.inz.pd.domain.MedExamination;
import pw.inz.pd.domain.Patient;
import pw.inz.pd.util.AnalyzeVoiceFileReader;
import pw.inz.pd.util.ExtProgRunCmd;
import pw.inz.pd.util.NNAnalyzer;
import pw.inz.pd.util.VoiceAnalyzer;
import pw.inz.pd.web.util.MultipartMap;

@WebServlet(urlPatterns = { "C:\\pd_analyzer\\uploaded_voices" })
@MultipartConfig(location = "C:\\pd_analyzer\\uploaded_voices", maxFileSize = 10485760L)
public class Form1Servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3585417387655032901L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/WebEXForm1.jsp");
		rd.forward(req, resp);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		MultipartMap map = new MultipartMap(request, this);
		if (map != null) {
			String personalNum = map.getParameter("personalNum");
			File voiceFile = map.getFile("voiceFile");
			if (personalNum != null && voiceFile != null) {
				if (personalNum != "" && voiceFile.exists()) {
					VoiceAnalyzer va = new VoiceAnalyzer(voiceFile);
					if (va != null) {
						va.makeVoiceAnalyze();
						String analyzedVoiceFileName = va.getAnalyzedVoiceFileName();
						if (analyzedVoiceFileName != null && analyzedVoiceFileName != "") {
							AnalyzeVoiceFileReader avf = new AnalyzeVoiceFileReader(
									new File(analyzedVoiceFileName));
							HashMap<String, String> paramsVoiceMap = avf.getVoiceParamsMapResult();
							if (paramsVoiceMap != null && !paramsVoiceMap.isEmpty()) {
								String jitter_ddp = paramsVoiceMap.get("jitter_ddp");
								String shimmer_apq3 = paramsVoiceMap.get("shimmer_apq3");
								String shimmer_apq5 = paramsVoiceMap.get("shimmer_apq5");
								String shimmer_dda = paramsVoiceMap.get("shimmer_dda");
								String hnr = paramsVoiceMap.get("hnr");
								
								System.out.println(paramsVoiceMap.get("jitter_ddp"));
								System.out.println(paramsVoiceMap.get("shimmer_apq3"));
								System.out.println(paramsVoiceMap.get("shimmer_apq5"));
								System.out.println(paramsVoiceMap.get("shimmer_dda"));
								System.out.println(paramsVoiceMap.get("hnr"));
								
								 
								Patient patient = new Patient(); 
								patient.setPersonalNum(personalNum);
								patient.setAge(0); 
								patient.setSex(-1); 
								PatientDAO pDAO = new DB2PatientDAO(); pDAO.addPatient(patient);
								 
								MedExamination medEx = new MedExamination(); 
								medEx.setHnr(Double.parseDouble(hnr)); 
								medEx.setJitter_ddp(Double.parseDouble(jitter_ddp));
								medEx.setMedExDate(FormatConverter.createTimeStamp()); 
								medEx.setPersonalNum(personalNum);
								medEx.setShimmer_apq3(Double.parseDouble(shimmer_apq3)); 
								medEx.setShimmer_apq5(Double.parseDouble(shimmer_apq5));
								medEx.setShimmer_dda(Double.parseDouble(shimmer_dda)); 
								MedExaminationDAO medExDAO = new DB2MedExaminationDAO(); 
								medExDAO.addMedExamination(medEx);
								
								String neuralNetworkCmd = "C:\\pd_analyzer\\sn\\nn_no_age_sex-1.exe " + 
										jitter_ddp + " " + shimmer_apq3 + " " + shimmer_apq5 + " "  + shimmer_dda 
										+ " " +hnr;
								String commandNNOutput = ExtProgRunCmd.run(neuralNetworkCmd);
								response.setContentType("text/html");
								if(commandNNOutput != "")
									writer.write("<h3>Stan badanego: <b>" + NNAnalyzer.getPatientStatus(
											commandNNOutput) + "</b></h3>");
								else
									writer.write("Nie można określić statusu badanego");
							} else
								writer.write("Brak wartości do przeanalizowania. Niepoprawny przebieg analizy dźwięku");
						} else
							writer.write("Niepoprawnie wczytany plik z danymi analizy głosu!");
					} else 
						writer.write("Niepoprawnie utworzona instancja obiektu VoiceAnalyzer");
				} else 
					writer.write("Nie wszystkie wartości w formularzu poprawnie uzupełniono");
			} else
				writer.write("Nie wszystkie wartości w formularzu uzupełniono!");
		} else
			writer.write("Niepoprawnie utworzona instancja obiektu MultiPartMap!");
	}
}
