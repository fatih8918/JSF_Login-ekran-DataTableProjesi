package com.egitim.util;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoggerProducer {

	//produces anatasyonu logdan kaynak üretmeye yarar.
	//Bu sınıfı konsolda log basmak için kullanmaktayız.
	//log basmanın kendi metodunu görüyoruz.
	//injection : Context içine kullanmak istediğimiz yapıyı enjekte etmeye yarar.Bu yapı CDI beanlerle alakalıdır.
	
	    @Produces  
	    public Logger produceLogger(InjectionPoint injectionPoint) {  
	        return LogManager.getLogger(injectionPoint.getMember().getDeclaringClass().getName());  
	    }  
}
