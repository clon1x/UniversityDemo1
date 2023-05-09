package com.lvl.university.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a course offered by the University
 * 
 * @author Luis Viñé
 *
 */
public class Course {

	private String name;
	private String id;
	private String description;
	/**
	 * Number of credits obtained when attending the course
	 */
	private int credits;
	private List<Section> sections = new ArrayList<>();
	
	public Course(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}
	
	public Section createSection(String semester, String place, String daysAndTimes) {
		Section section = new Section(this, semester, place, daysAndTimes);
		sections.add(section);
		return section;
	}
	
	public List<Section> getUncompleteSections() {
	    return sections.stream()
	                    .filter(section -> section.getNumOfStudentsEnrolled() < section.getCapacity())
	                    .collect(Collectors.toList());
	}
	
	public Iterator<Section> sectionsIterator() {
		return sections.iterator();
	}
	
}
