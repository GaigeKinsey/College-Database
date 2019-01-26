package edu.neumont.kinsey.database.model;

import java.util.ArrayList;

public class StudentList extends ArrayList<Student> implements Savable{

	private static final long serialVersionUID = 1L;

	@Override
	public String getFileName() {
		return "students.txt";
	}

	@Override
	public String toSaveFormat() {
		String result = "";
		for (Student student : this) {
			result += student.serialize() + "; ";
		}
		return result;
	}

	@Override
	public void fromLoadFormat(String s) {
		String[] pieces = s.trim().split(";");
		for (String piece : pieces) {
			Student student = new Student();
			student.deserialize(piece);
			this.add(student);
		}
	}
}
