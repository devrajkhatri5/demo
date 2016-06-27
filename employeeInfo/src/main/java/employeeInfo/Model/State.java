package employeeInfo.Model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class State {
	private String StateID;
	private String StateName;
	public String getStateID() {
		return StateID;
	}
	public String getStateName() {
		return StateName;
	}
	public void setStateID(String stateID) {
		StateID = stateID;
	}
	public void setStateName(String stateName) {
		StateName = stateName;
	}
	

}
