package test.dto;

public class MemberDto {
	private int empNum;
	private String name;
	private String dName;
	private String loc;
	
	public MemberDto() {}
	//���콺 ��Ŭ���ؼ� source�� ���� generate Constructor field
	public MemberDto(int empNum, String name, String dName, String loc) {
		super();
		this.empNum = empNum;
		this.name = name;
		this.dName = dName;
		this.loc=loc;	
	}
	//���콺 ��Ŭ���ؼ� source�� ���� generate getters, setters 
	public int getempNum() {
		return empNum;
	}
	public void setempNum(int empNum) {
		this.empNum = empNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public String getloc() {
		return loc;
	}
	public void setloc(String loc) {
		this.loc=loc;
	}
}
