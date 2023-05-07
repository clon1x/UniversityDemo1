package com.lvl.university.model;

public class Section {
	
	public static final int DEFAULT_SECTION_CAPACITY = 1;
    private String place;
	private String daysAndTimes;
	private String semester;
	private Course course;
	private int capacity = DEFAULT_SECTION_CAPACITY;
	private int enrolledStudentsNumber;
	
	public Section(Course course, String semester, String place, String daysAndTimes) {
		super();
		this.place = place;
		this.daysAndTimes = daysAndTimes;
		this.semester = semester;
		this.course = course;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getNumOfStudentsEnrolled() {
		return enrolledStudentsNumber;
	}

	public void setNumOfStudentsEnrolled(int numOfStudents) {
		enrolledStudentsNumber = numOfStudents;
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

    @Override
    public String toString() {
        return "Section [place=" + place + ", daysAndTimes=" + daysAndTimes + ", semester=" + semester + ", course=" + course
                        + ", capacity=" + capacity + ", enrolledStudentsNumber=" + enrolledStudentsNumber + "]";
    }

}
