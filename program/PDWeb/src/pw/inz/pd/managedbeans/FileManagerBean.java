package pw.inz.pd.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.apache.myfaces.trinidad.model.UploadedFile;

@ManagedBean(name = "fmBean")
@SessionScoped
public class FileManagerBean {

	private UploadedFile _file;

	public UploadedFile getFile() {
		return _file;
	}

	public void setFile(UploadedFile file) {
		_file = file;
	}

	public String doUpload() {
		UploadedFile file = getFile();
		return file.toString();
	}
}
