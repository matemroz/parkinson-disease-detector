package pw.inz.pd.db.dao;

import pw.inz.pd.domain.Patient;

public interface PatientDAO {
	boolean isExistPatient(Patient p);
	boolean addPatient(Patient p);
}
