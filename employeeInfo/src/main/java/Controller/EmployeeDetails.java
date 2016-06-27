package Controller;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

import employeeInfo.Model.UserDetail;
import employeeInfo.Model.UserDetailDTO;
import System.DAO.UserDetailDAO;

@ManagedBean(name = "employeeDetails", eager = true)
@RequestScoped
public class EmployeeDetails {
	@ManagedProperty(value = "#{userDetail}")
	private UserDetail userDetails;
	
 
private String deleteID;

	public String getDeleteID() {
	return deleteID;
}


public void setDeleteID(String deleteID) {
	
	this.deleteID = deleteID;
}


	private static  Map<String, String> districtList = new HashMap<String, String>();
	
	private static  Map<String, String> states = new HashMap<String, String>();

	public  Map<String, String> getStates() {
		UserDetailDAO user = new UserDetailDAO();
		states=user.getStateList();
		return states;
	}


	public Map<String, String> getDistrictList() {
		return districtList;
	}

	public UserDetail getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetail userDetails) {
		this.userDetails = userDetails;
	}

	public String AddEmployee() {
		UserDetailDAO user = new UserDetailDAO();
		try {
			if (user.addUser(userDetails)) {
				return "UserDetail";
			} else {
				return "AddEmployee";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public List<UserDetailDTO> getUsers() {
		UserDetailDAO user = new UserDetailDAO();
		return (user.getUserDetail());

	}

	public void remove() {
		UserDetailDAO user=new UserDetailDAO();
		user.deleteUser(deleteID);
			
	}


	public void valueChanged(ValueChangeEvent e) {

		userDetails.setStateID(e.getNewValue().toString());
		UserDetailDAO user = new UserDetailDAO();
		districtList.putAll(user.getDistrictList(userDetails.getStateID()));

	}

}
