package com.lvl.university.model;

public class Section {
	
	private String place;
	private String daysAndTimes;
	private String semester;
	private Course course;
	
	public Section(Course course, String semester, String place, String daysAndTimes) {
		super();
		this.place = place;
		this.daysAndTimes = daysAndTimes;
		this.semester = semester;
		this.course = course;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDaysAndTimes() {
		return daysAndTimes;
	}

	public void setDaysAndTimes(String daysAndTimes) {
		this.daysAndTimes = daysAndTimes;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public Course getCourse() {
		return course;
	}

}
