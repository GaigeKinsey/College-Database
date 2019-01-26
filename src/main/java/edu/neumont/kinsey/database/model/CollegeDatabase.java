package edu.neumont.kinsey.database.model;

import java.util.ArrayList;
import java.util.Collections;

public class CollegeDatabase extends ArrayList<Person> implements Savable{
	
	private static final long serialVersionUID = 1L;
	
	private StudentList students = new StudentList();
	private FacultyList faculty = new FacultyList();
	private StaffList staff = new StaffList();

	public void sort() {
		Collections.sort(this);
	}

	public StudentList getStudents() {
		return students;
	}

	public void setStudents(StudentList students) {
		this.students = students;
	}

	public FacultyList getFaculty() {
		return faculty;
	}

	public void setFaculty(FacultyList faculty) {
		this.faculty = faculty;
	}

	public StaffList getStaff() {
		return staff;
	}

	public void setStaff(StaffList staff) {
		this.staff = staff;
	}
	
	@Override
	public boolean add(Person p) {
		if (p instanceof Student) {
			getStudents().add((Student) p);
		} else if (p instanceof Faculty) {
			getFaculty().add((Faculty) p);
		} else {
			getStaff().add((Staff) p);
		}
		return false;
	}
	
	@Override
	public String getFileName() {
		return "database.txt";
	}

	@Override
	public String toSaveFormat() {
		return students.toSaveFormat() + "\r\n" + faculty.toSaveFormat() + "\r\n" + staff.toSaveFormat();
	}

	@Override
	public void fromLoadFormat(String rawData) {
		String[] pieces = rawData.split("\r\n");
		StudentList stu = new StudentList();
		stu.fromLoadFormat(pieces[0]);
		students = stu;
		this.addAll(stu);
		FacultyList fac = new FacultyList();
		fac.fromLoadFormat(pieces[1]);
		faculty = fac;
		this.addAll(fac);
		StaffList sta = new StaffList();
		sta.fromLoadFormat(pieces[2]);
		staff = sta;
		this.addAll(sta);
	}
}
