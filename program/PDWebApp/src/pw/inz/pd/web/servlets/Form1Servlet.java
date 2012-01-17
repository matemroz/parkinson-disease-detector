package pw.inz.pd.web.servlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

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
import pw.inz.pd.domain.MedExamination;
import pw.inz.pd.domain.Patient;
import pw.inz.pd.web.util.MultipartMap;

@WebServlet(urlPatterns = { "C:\\uploadedFiles" })
@MultipartConfig(location = "C:\\uploadedFiles", maxFileSize = 10485760L)
public class Form1Servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3585417387655032901L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc
				.getRequestDispatcher("/WEB-INF/WebEXForm1.jsp");
		rd.forward(req, resp);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		MultipartMap map = new MultipartMap(request, this);
		String personalNum = map.getParameter("personalNum");
		File voiceFile = map.getFile("voiceFile");

		
		try {
			String line;
			Process p = Runtime.getRuntime().exec("cmd /c praatcon");
			BufferedReader bri = new BufferedReader(new InputStreamReader(
					p.getInputStream()));
			BufferedReader bre = new BufferedReader(new InputStreamReader(
					p.getErrorStream()));
			while ((line = bri.readLine()) != null) {
				System.out.println(line);
			}
			bri.close();
			while ((line = bre.readLine()) != null) {
				System.out.println(line);
			}
			bre.close();
			p.waitFor();
			System.out.println("Done.");
		} catch (Exception err) {
			err.printStackTrace();
		}

		/*
		 * String personalNum = request.getParameter("personalNum"); if
		 * (ServletFileUpload.isMultipartContent(request)) { FileItemFactory
		 * factory = new DiskFileItemFactory(); ServletFileUpload upload = new
		 * ServletFileUpload(factory);
		 * 
		 * try { List<FileItem> fileItems = upload.parseRequest(request); if
		 * (!fileItems.isEmpty()) { Iterator iter = fileItems.iterator(); while
		 * (iter.hasNext()) { iter.next(); FileItem fileItem = (FileItem)
		 * iter.next(); if (fileItem.isFormField()) {
		 * System.out.println(fileItem.getFieldName());
		 * System.out.println(fileItem.getName());
		 * System.out.println(fileItem.getContentType());
		 * System.out.println(fileItem.isInMemory());
		 * System.out.println(fileItem.getSize()); } else { System.err
		 * .println("Pole z plikiem nie zostało uzupełnione w formularzu!"); } }
		 * } else { System.err
		 * .println("W formularzu nie występują żadne pliki!"); } } catch
		 * (FileUploadException e) { e.printStackTrace(); }
		 * 
		 * } else {
		 * System.err.println("Zawartość zapytania nie jest ytypu Mutlipart"); }
		 * 
		 * // TODO: upload pliku na serwer
		 * 
		 * // TODO: analiza przesłanego pliku z dźwiękiem
		 * 
		 * // TODO: zapisanie wyników analizy do pliku
		 * 
		 * // TODO: Zapisać do bazy nowego pacjenta
		 */
		/*
		 * Patient patient = new Patient(); patient.setPersonalNum(personalNum);
		 * patient.setAge(0); patient.setSex(-1); PatientDAO pDAO = new
		 * DB2PatientDAO(); pDAO.addPatient(patient);
		 * 
		 * //TODO: Zapisać do bazy wynik badania MedExamination medEx = new
		 * MedExamination(); medEx.setHnr(hnr); medEx.setJitter_ddp(jitter_ddp);
		 * medEx.setMedExDate(medExDate); medEx.setPersonalNum(personalNum);
		 * medEx.setShimmer_apq3(shimmer_apq3); medEx.getShimmer_apq5();
		 * medEx.getShimmer_dda(); MedExaminationDAO medExDAO = new
		 * DB2MedExaminationDAO(); medExDAO.addMedExamination(medEx);
		 * 
		 * response.setContentType("text/html"); PrintWriter writer =
		 * response.getWriter();
		 */
	}
}
