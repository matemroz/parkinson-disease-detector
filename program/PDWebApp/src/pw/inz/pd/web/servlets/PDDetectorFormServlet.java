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

@WebServlet(name="PDDetectorFormServlet", urlPatterns="/pDDetectorFormServlet", asyncSupported=true)
@MultipartConfig(location = "C:\\pd_analyzer\\uploaded_voices", fileSizeThreshold=1024*1024*2, maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class PDDetectorFormServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3585417387655032901L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/WebEXForm.jsp");
		rd.forward(req, resp);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		MultipartMap map = new MultipartMap(request, this);
		if (map != null) {
			String personalNum = map.getParameter("personalNum");
			String age = map.getParameter("age");
			String sex = map.getParameter("sex");
			File voiceFile = map.getFile("voiceFile");
			if (age != null && sex != null && personalNum != null && voiceFile != null) {
				if (age != "" && sex != "" && personalNum != "" && voiceFile.exists()) {
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
								String nhr = paramsVoiceMap.get("nhr");
								
								System.out.println(paramsVoiceMap.get("jitter_ddp"));
								System.out.println(paramsVoiceMap.get("shimmer_apq3"));
								System.out.println(paramsVoiceMap.get("shimmer_apq5"));
								System.out.println(paramsVoiceMap.get("shimmer_dda"));
								System.out.println(paramsVoiceMap.get("hnr"));
								
								 
								Patient patient = new Patient(); 
								patient.setPersonalNum(personalNum);
								patient.setAge(Integer.parseInt(age)); 
								patient.setSex(Integer.parseInt(sex)); 
								PatientDAO pDAO = new DB2PatientDAO(); 

								if(!pDAO.isExistPatient(patient))
									pDAO.addPatient(patient);
								else
									System.out.println("Pacjent znajduje się już w bazie");
								 
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
								
								String neuralNetworkCmd = "C:\\pd_analyzer\\sn\\sn.exe " + 
										jitter_ddp + " " + shimmer_apq3 + " " + shimmer_apq5 + " "  + shimmer_dda 
										+ " " +hnr + " " + nhr;
								String commandNNOutput = ExtProgRunCmd.run(neuralNetworkCmd);
								response.setContentType("text/html");
								if(commandNNOutput != ""){
									String medExStatus =  NNAnalyzer.getPatientStatus(
											commandNNOutput);
									writer.write("<h3>Stan badanego: <b>" + medExStatus + "</b></h3>");
								}
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
