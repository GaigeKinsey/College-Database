package edu.neumont.kinsey.database.model;

import java.util.ArrayList;

public class StaffList extends ArrayList<Staff> implements Savable{

	private static final long serialVersionUID = 1L;

	@Override
	public String getFileName() {
		return "staff.txt";
	}
	
	@Override
	public String toSaveFormat() {
		String result = "";
		for (Staff staff : this) {
			result += staff.serialize() + "; ";
		}
		return result;
	}

	@Override
	public void fromLoadFormat(String s) {
		String[] pieces = s.trim().split(";");
		for (String piece : pieces) {
			Staff staff = new Staff();
			staff.deserialize(piece);
			this.add(staff);
		}
	}
}
