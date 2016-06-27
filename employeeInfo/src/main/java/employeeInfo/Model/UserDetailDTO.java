package employeeInfo.Model;



public class UserDetailDTO {
	
	private String UserID;
	private String Firstname;
	private String LastName;
	private String Email;
	private int Age;
	private String sex;
	private String StateName;
	private String DistrictName;
	public String getUserID() {
		return UserID;
	}
	public String getFirstname() {
		return Firstname;
	}
	public String getLastName() {
		return LastName;
	}
	
	public String getEmail() {
		return Email;
	}
	public int getAge() {
		return Age;
	}
	public String getSex() {
		return sex;
	}
	public String getStateName() {
		return StateName;
	}
	public String getDistrictName() {
		return DistrictName;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	
	public void setEmail(String email) {
		Email = email;
	}
	public void setAge(int age) {
		Age = age;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setStateName(String stateName) {
		StateName = stateName;
	}
	public void setDistrictName(String districtName) {
		DistrictName = districtName;
	}
	
	
	
	

}
