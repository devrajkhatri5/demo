package employeeInfo.Model;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;


@ManagedBean
@RequestScoped
public class District {
	private String DistrictID;
	private String DistrictName;
	public String getDistrictID() {
		return DistrictID;
	}
	public String getDistrictName() {
		return DistrictName;
	}
	public void setDistrictID(String districtID) {
		DistrictID = districtID;
	}
	public void setDistrictName(String districtName) {
		DistrictName = districtName;
	}
	

}
