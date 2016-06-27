package Controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import System.DAO.LoginDAO;
import employeeInfo.Model.Login;

@ManagedBean
public class AuthorizeController {
	@ManagedProperty(value = "#{login}")
	private Login login;

	public Login getLogin() {
		return login;

	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String validateUsernamePassword() {

		if (LoginDAO.validateUser(login.getUserID(), login.getPassword())) {
			return "UserDetail";
		}
		else
		{
		return "Index";
		}
		
	}

}
