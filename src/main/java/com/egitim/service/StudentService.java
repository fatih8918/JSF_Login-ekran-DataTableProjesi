package com.egitim.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.egitim.model.Student;

@Named("studentService")
@SessionScoped
public class StudentService implements Serializable{
	
	//Başlangıçta kurucu fonksiyon ile listenin doldurulmasını sağlar.
	private static final long serialVersionUID = 840277619631764557L;
	//List tipinde Student sınıfının tipinde students nesnesi oluşturuluyor.
	private List<Student> students = new ArrayList<Student>();
	
	public void initStudents() {
		students.add(new Student("Ahmet","Bilgiç",getRandomDate()));
		students.add(new Student("Ahmet","Saygılı",getRandomDate()));
		students.add(new Student("Fatih","Dikilitaş",getRandomDate()));
		students.add(new Student("Fikri","Eş",getRandomDate()));
		students.add(new Student("Gökhan","Günay",getRandomDate()));
		students.add(new Student("İlhan","Kıyak",getRandomDate()));
		students.add(new Student("Kürşatalp","Zararsızsoy",getRandomDate()));
		students.add(new Student("Merve","Benli",getRandomDate()));
		students.add(new Student("Mustafa","Demirkan",getRandomDate()));
		students.add(new Student("Önder","Diri",getRandomDate()));
		students.add(new Student("Semir","Aydın",getRandomDate()));
		students.add(new Student("Sevan","Nerse",getRandomDate()));
		students.add(new Student("Şeyda","Dökme",getRandomDate()));
		students.add(new Student("Süha","Sülün",getRandomDate()));
		students.add(new Student("Umut","Ateş",getRandomDate()));
		students.add(new Student("Umut","Sezen",getRandomDate()));
		students.add(new Student("Volkan","Tunç",getRandomDate()));
	}
	
	public Date getRandomDate() {
		Date birthdate = new Date((long) (Math.random()*1000000000000L + 315536461000L));
		return birthdate;
	}
	
	//öğrenci ekleme metodu
	public void addStudent(Student student) {
		students.add(student);
	}
	
	
	//Students getter metodu
	public List<Student> getStudents() {
		return students;
	}

	//öğrenci silme 
	public void removeStudent(Student student) {
		students.remove(student);
	}
}
