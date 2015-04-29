package com.egitim.beans;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.apache.logging.log4j.Logger;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.UploadedFile;

import com.egitim.model.Student;
import com.egitim.service.StudentService;

@Named("dataTable")
@SessionScoped
public class DataTableBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1596272662226363387L;
	
	@Inject
	private transient Logger log;
	//bir loglama kütüphanesidir. (logging framework). Log4j kullanmak için log4j.jar dosyasında ve log4j tanımlarının yapıldığı properties dosyasına ihtiyaç bulunmaktadır. 
	//Bu properties dosyası standart olarak log4j.properties  yada log4j.xml dosyaları olabilir. 
	
	/*Kod içerisinde bulunan System.out.println leri kaldırmak için kodda düzenleme yapmak gerekir. Sysout sistem kaynaklarını kullanarak sistem log dosyasına yazar ve 
	 *  her yazma işlemi sırasında standart I/O yapar.
	 *  log4j kadar performanslı değildir. İstenildiği zaman kapatılamaz.

Log4j ile loglama bir anda tamamen kapatılabilir yada seviyesiyle bir anda değiştirilebilir.*/

	
	@Inject
	private StudentService studentService;
	//List tipinde Student sınıfının tipinde students nesnesi oluşturuluyor.
	private List<Student> students;
	
	private Student selectedStudent;
	
	@NotNull
    @Pattern(regexp = "([a-zA-Z]+)")
    	private String name;

	@NotNull
	private String surname;
	
	@Past
	private Date birthdate;
	
	SimpleDateFormat sf = new SimpleDateFormat("d.M.yyyy");
	
	//StudentService sınıfından initStudents metodu çağrılıyor
	//StudentService nesnesiyle bu öğrenciler getiriliyor.
	//ve log atıyor.
	@PostConstruct
	public void init() {
		studentService.initStudents();
		students  = studentService.getStudents();
		log.info("Data Table initialized.");
	}
	
	//öğrenci ekleme metodu
	//studentservice nesnesiyle addStudent metoduna ulaşılıyor.
	//studentservice nesnesiyle getStudents metoduyla öğrenciler getiriliyor.
	//return success bir anahtar kelime,faces-configde tanımladığımız navigation rule icindeki outcame
	public String addStudent() {
		studentService.addStudent(new Student(name,surname,birthdate));
		students  = studentService.getStudents();
		return "success";
	}
	
	//öğrenci silme metodu
	//studentsservice nesnesiyle studentService sınıfının remove metoduna erişiriz.
	//Bu nesneyle studentService sınıfının get metoduyla öğrencilere getiriyoruz ve studentsa atıyoruz.
	
	public String removeStudent(Student std) {
		studentService.removeStudent(std);
		students  = studentService.getStudents();
		return "success";
	}
	//satır seçimi yapıldığında kullanılan metod
	public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Student Selected", ((Student) event.getObject()).getSurname());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
//upload kısmından dosya eklemeyi sağlar
	public void handleFileUpload(FileUploadEvent event) {
		log.info("File name:"+event.getFile().getFileName());
		UploadedFile file = event.getFile();
		String line;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputstream()));
			while ((line = reader.readLine()) != null) {
				String[] studentData = line.split(";");
				studentService.addStudent(new Student(studentData[0],studentData[1],sf.parse(studentData[2])));
	        }
		} catch (Exception e) {
			log.error("Dosya okuma hatası.",e);
		} 
		students  = studentService.getStudents();
	}
	
	//------Get ve set metodları
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	//--------------------

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
//--------------------
	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
//---------------------
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
//----------------------------
	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
//--------------------------------
	public Student getSelectedStudent() {
		return selectedStudent;
	}

	public void setSelectedStudent(Student selectedStudent) {
		this.selectedStudent = selectedStudent;
	}
//-----------------------
}
