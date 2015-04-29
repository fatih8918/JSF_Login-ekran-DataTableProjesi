package com.egitim.beans;

import java.io.Serializable;
import java.util.Locale;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("user")
@SessionScoped
public class UserBean implements Serializable{

	/*İng-Türkçe dil ayarlamalarının yapıldığı sınıf 
	 */
	//Locale sınıfından locale nesnesi ürettik.
	private static final long serialVersionUID = 5816079194808611291L;
	private Locale locale = new Locale("tr");
	
	public String changeLocaleTr() {
		locale = new Locale("tr");
		FacesContext.getCurrentInstance().getViewRoot()
		.setLocale(locale);
		return null;
	}

	public String changeLocaleEn() {
		locale = new Locale("en");
		FacesContext.getCurrentInstance().getViewRoot()
		.setLocale(locale);
		return null;
	}
	
	//Locale değişkeninin get ve set metodları

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
	
}
