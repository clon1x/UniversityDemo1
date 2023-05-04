package com.lvl.university.collections;

import java.util.Iterator;

import com.lvl.university.model.Student;

public class StudentLinkedList2 implements StudentList {

	private StudentNode head;
	private int size;
	
	private class StudentNode {
		private Student data;
		private StudentNode next;
		
		public StudentNode(Student data) {
			this.data = data;
			this.next = null;
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
		
		public StudentLinkedList2Iterator(StudentNode head) {
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
		StudentNode newNode = new StudentNode(student);
		if (head == null) {
			head = newNode;
		} else {
			StudentNode tail = head;
			while (tail.next() != null) {
				tail = tail.next();
			}
			tail.setNextNode(newNode);
		}
		size++;
	}

	public int getSize() {
		return this.size;
	}

	@Override
	public void delete(Student student) {
		if (head == null) return;
		
		if (head.getData() == student) {
			head = head.next();
			return;
		}
		
		StudentNode current = head;
		while (current.next() != null) {
			if (current.next().getData() == student) {
				current.setNextNode(current.next().next());
			}
			
			current = current.next();
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StudentLinkedList [students=");
		
		StudentNode current = head;
		while (current != null) {
			builder.append(current.getData().toString());
			current = current.next();
		}
		builder.append("]");
		return builder.toString();
	}

	@Override
	public Iterator<Student> iterator() {
		return new StudentLinkedList2Iterator(head);
	}

}
