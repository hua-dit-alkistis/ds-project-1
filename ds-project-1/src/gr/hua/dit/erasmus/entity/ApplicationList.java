package gr.hua.dit.erasmus.entity;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.stereotype.Component;

@XmlRootElement(name="ApplicationList")
@Component
public class ApplicationList {
	
	List<Application> applicationList;

	public List<Application> getApplicationList() {
		return applicationList;
	}

	public void setApplicationList(List<Application> applicationList) {
		this.applicationList = applicationList;
	}

}
