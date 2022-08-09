package neu.edu.csye6200.models;

import java.util.ArrayList;
import java.util.List;

public class Employee {	
	Teacher teacher;
	boolean isEmployed;
	List<Review> reviews;
	
	public void addReview(Review rev) {
		this.reviews.add(rev);
	}
	public Review getLatestReview() {
		return this.reviews.get(this.reviews.size()-1);
	}
	public List<Review> getAllReviews(){
		return this.reviews;
	}
	public Employee(Teacher teacher, Review rev) {	
		this.teacher=teacher;
		this.isEmployed = false;
		reviews = new ArrayList<Review>();
		reviews.add(rev);
	}
	public Teacher getEmployee()
	{
		return teacher;
	}
	
	
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public boolean isEmployed() {
		return isEmployed;
	}
	public void setEmployed(boolean isEmployed) {
		this.isEmployed = isEmployed;
	}
	@Override
	public String toString() {
		return String.valueOf(teacher.id);
	}
	
}
