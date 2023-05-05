package com.lvl.university.collections;

import java.util.Iterator;

import com.lvl.university.model.Student;

public class StudentLinkedList2 implements StudentList {

	private StudentNode head;
	private int size;
	
	private class StudentNode {
		private Student data;
		private StudentNode next;
		
		public StudentNode(Student data, StudentNode next) {
			this.data = data;
			this.next = next;
		}
		
		public void setNextNode(StudentNode next) {
			this.next = next;
		}
		
		public StudentNode next() {
			return this.next;
		}
		
		public Student getData() {
			return data;
		}
		
	}
	
	private class StudentLinkedList2Iterator implements Iterator<Student> {

		private Student[] students = new Student[size];
		private int current;
		private int last;
		
		public StudentLinkedList2Iterator() {
			current = 0;
			last = 0;
			createStudentsArray(head); 
		}

		private void createStudentsArray(StudentNode head) {
			StudentNode current = head;
			while (current != null) {
				this.students[last++] = current.getData();
				current = current.next();
			}
		}

		@Override
		public boolean hasNext() {
			return current < last;
		}

		@Override
		public Student next() {
			return students[current++];
		}
		
	}
	
	@Override
	public void add(Student student) {
		head = new StudentNode(student, head);
		size++;
	}

	@Override
	public void delete(Student student) {

		if (head == null) return;
		
		if (head.getData() == student) {
			head = head.next();
			--size;
			return;
		}
		
		for (StudentNode current = head; current.next() != null; current = current.next()) {
			if (current.next().getData() == student) {
				current.setNextNode(current.next().next());
				--size;
				return;
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StudentLinkedList2 [");
		
		StudentNode current = head;
		while (current != null) {
			builder.append(current.getData().toString() + ", ");
			current = current.next();
		}
		builder.replace(builder.length() - 2, builder.length(), "");
		builder.append("]");
		return builder.toString();
	}

	@Override
	public Iterator<Student> iterator() {
		return new StudentLinkedList2Iterator();
	}

	@Override
	public int size() {
		return size;
	}

}
