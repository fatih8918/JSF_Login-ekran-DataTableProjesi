package com.egitim.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//Karakter kodlama filtresi ile ilgili kısım.
//filter burada bir interfacedir.Filtre yapabilmem için benim filter interfaceinden implements almam gerekir.
//Filter arayüzünde içi boş metodlar bulunur.Ordan çağırılan metodlar bu sınıfda çağrılır.Ve burada istenen yapıya göre metodların içi doldurulur.


public class SetCharacterEncodingFilter implements Filter {

	protected String encoding = null;
	protected FilterConfig filterConfig = null;
	protected boolean ignore = true;

	//Servlet objesi bellekten remove edildiği zaman kullanılan metod
	public void destroy() {
		this.encoding = null;
		this.filterConfig = null;
	}

	/**
	 *Karakter kodlaması için request parametrelerini yorumlayan metod
	 * 
	 *Burada parametre isteği,parametre sonucu,servlet isteği,servlet sonucu ,
	 *Bir giriş çıkış hatası olursa onun kontrolü
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		// Conditionally select and set the character encoding to be used
		if (ignore || (request.getCharacterEncoding() == null)) {
			String encoding = selectEncoding(request);
			if (encoding != null)
				request.setCharacterEncoding(encoding);
		}

		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		// Pass control on to the next filter
		chain.doFilter(request, response);
	}

	//Hizmete oluşturulan filtreyi yerleştirme
	//filterConfig-->filtre yapılandırma nesnesi
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		this.encoding = filterConfig.getInitParameter("encoding");
		String value = filterConfig.getInitParameter("ignore");
		if (value == null)
			this.ignore = true;
		else if (value.equalsIgnoreCase("true"))
			this.ignore = true;
		else if (value.equalsIgnoreCase("yes"))
			this.ignore = true;
		else
			this.ignore = false;
	}

	//Uygun bir karakter kodlamadı seçimi
	//geçerli istek ve filtre başlatma özellikleri
	protected String selectEncoding(ServletRequest request) {
		return (this.encoding);
	}

}

