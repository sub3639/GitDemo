package resources;

import java.util.ArrayList;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {

	

	public Object addPlacePayload(String name, String language, String address) {
		// TODO Auto-generated method stub
		
		AddPlace p= new AddPlace();
		p.setAccuracy(50);
		p.setAddress(address);
		p.setLanguage(language);
		p.setPhone_number("+33170936366");
		p.setWebsite("https//www.rahulshettyacademy.com");
		p.setName(name);
		ArrayList<String> mlist=new ArrayList<String>();
		
		mlist.add("Shoe park");
		mlist.add("dog house");
		p.setTypes(mlist);
		Location l= new  Location();
		l.setLan(-38.383494);
		l.setLon(33.427362);
		p.setLocation(l);
		return p;
	}

	public Object addPlacePayload1(String name, String language, String address) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
	


