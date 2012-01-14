package pw.inz.pd.domain;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.io.Serializable;

@ManagedBean(name="patientBean")
@SessionScoped
public class Patient implements Serializable{
	
	private static final long serialVersionUID = -4967710614033489718L;
	private int age;
	private int sex;
	private String personalNum;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getPersonalNum() {
		return personalNum;
	}

	public void setPersonalNum(String personalNum) {
		this.personalNum = personalNum;
	}

}
