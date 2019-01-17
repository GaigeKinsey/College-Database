package edu.neumont.kinsey.database.model;

import java.util.ArrayList;
import java.util.Collections;

public class CollegeDatabase extends ArrayList<Person>{

	private static final long serialVersionUID = 1L;

	public void sort() {
		Collections.sort(this);
	}
}
