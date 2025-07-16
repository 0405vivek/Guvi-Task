package in.dp.main.entity;

public class Emp {

	
	private int empcode;
	private String empname;
	private int empage;
	private int esalary;
	
	
	public Emp(int empcode, String empname,int empage,int esalary) {
		
		this.empcode=empcode;
		this.empname=empname;
		this.empage=empage;
		this.esalary=esalary;
		
	}
	
	public int getEmpcode() {
		return empcode;
	}
	public void setEmpcode(int empcode) {
		this.empcode = empcode;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public int getEmpage() {
		return empage;
	}
	public void setEmpage(int empage) {
		this.empage = empage;
	}
	public int getEsalary() {
		return esalary;
	}
	public void setEsalary(int esalary) {
		this.esalary = esalary;
	}

	
}
