package com.egitim.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;

@Named("demoBean")
@SessionScoped
public class DemoBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7845617698865063163L;
	private String name;
	private String surname;
	private String age;
	private String gender;
	private List<SelectItem> genders;
	private String address;
	private String city;
	private List<SelectItem> cities;
	private String county;
	private List<SelectItem> counties;
	private Boolean showCounty=false;

	//İlk değerler hazırlanıyor
	public DemoBean() {
		genders = new ArrayList<SelectItem>();
		genders.add(new SelectItem("0","erkek"));
		genders.add(new SelectItem("1","kadin"));
		cities = new ArrayList<SelectItem>();
		cities.add(new SelectItem("0","seciniz"));
		cities.add(new SelectItem("34","istanbul"));
		cities.add(new SelectItem("35","izmir"));
		cities.add(new SelectItem("06","ankara"));
		cities.add(new SelectItem("42","konya"));
		counties = new ArrayList<SelectItem>();
	}
	
	//event handler : değişikliği dinleyen metod
	public void valueChangeMethod(ValueChangeEvent event) {
		showCounty = true;
		counties.clear();
		System.out.println("old value:"+event.getOldValue()+" new value:"+event.getNewValue());
		if (event.getNewValue().equals("34")) {
			counties.add(new SelectItem("1", "sisli"));
			counties.add(new SelectItem("2", "besiktas"));
			counties.add(new SelectItem("3", "sariyer"));
		} else if (event.getNewValue().equals("35")) {
			counties.add(new SelectItem("1","Karsiyaka"));
			counties.add(new SelectItem("2","Bornova"));
		}
	}
	
	//Get ve set metodları
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	//---------------------

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
//----------------------
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
//---------------------
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	//------------------------------
	public List<SelectItem> getGenders() {
		return genders;
	}

	public void setGenders(List<SelectItem> genders) {
		this.genders = genders;
	}
	//----------------------
	//Butonun kullandığı kaydet metodu
	//Bu sınıftaki tüm bilgileri alıyor,stringe çeviriyor
	public String kaydet() {
		System.out.println(this.toString());
		return null;
	}

	//-----------------------
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	//-----------------------
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	//----------------------------
	public List<SelectItem> getCities() {
		return cities;
	}

	public void setCities(List<SelectItem> cities) {
		this.cities = cities;
	}

	//---------------------
	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	//-----------------------
	public List<SelectItem> getCounties() {
		return counties;
	}

	public void setCounties(List<SelectItem> counties) {
		this.counties = counties;
	}

	//------------------------
	public Boolean getShowCounty() {
		return showCounty;
	}

	public void setShowCounty(Boolean showCounty) {
		this.showCounty = showCounty;
	}

	//String sınıfının toString metodunu alıp ezeriz ve içini doldururuz.
	@Override
	public String toString() {
		return "DemoBean [name=" + name + ", surname=" + surname + ", age="
				+ age + ", gender=" + gender + ", genders=" + genders
				+ ", address=" + address + ", city=" + city + ", county="
				+ county + "]";
	}


}
