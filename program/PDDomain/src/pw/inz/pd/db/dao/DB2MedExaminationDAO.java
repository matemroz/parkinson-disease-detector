package pw.inz.pd.db.dao;

import java.util.ArrayList;

import pw.inz.pd.db.utils.DB2DBUtils;
import pw.inz.pd.db.utils.FormatConverter;
import pw.inz.pd.domain.MedExamination;

public class DB2MedExaminationDAO implements MedExaminationDAO{

	@Override
	public boolean addMedExamination(MedExamination mEx) {
		String schemaName = "PDDBSCH";
		String tableName = "MEDEXAMINATION";
		ArrayList<String> columnNames = new ArrayList<String>();
		ArrayList<String> values = new ArrayList<String>();

		columnNames.add("MEDEXDATE");
		columnNames.add("PERSONALNUM");
		columnNames.add("JITTERDDP");
		columnNames.add("SHIMMERAPQ3");
		columnNames.add("SHIMMERAPQ5");
		columnNames.add("SHIMMERDDA");
		columnNames.add("HNR");
		
		values.add("'" + mEx.getMedExDate() + "'");
		values.add("'" + mEx.getPersonalNum() + "'");
		values.add("'" + mEx.getJitter_ddp() + "'");
		values.add("'" + mEx.getShimmer_apq3() + "'");
		values.add("'" + mEx.getShimmer_apq5() + "'");
		values.add("'" + mEx.getShimmer_dda() + "'");
		values.add("'" + mEx.getHnr() + "'");

		return DB2DBUtils.insertCommand(schemaName, tableName, columnNames, values);
	}

	public static void main(String[] args){
		MedExaminationDAO mExDAO = new DB2MedExaminationDAO();
		MedExamination mEx = new MedExamination();
		mEx.setMedExDate(FormatConverter.createTimeStamp());
		mEx.setPersonalNum("59120500511");
		mEx.setJitter_ddp(0.42600);
		mEx.setShimmer_apq3(0.02211);
		mEx.setShimmer_apq5(0.04314);
		mEx.setShimmer_dda(0.04314);
		mEx.setHnr(22.929);
		mExDAO.addMedExamination(mEx);
	}
}
