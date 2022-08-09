package neu.edu.csye6200.models;

import java.time.LocalDate;
import java.util.Date;

public class Review {
	private Integer rating;
	private LocalDate dateOfReview;
	private LocalDate nextReviewDate;
	private String description;
	
	//create button for alerting next review
	
	public Review(Integer rating, String description) {
		this.dateOfReview=LocalDate.now();
		this.rating=rating;
		this.description=description;
		this.nextReviewDate= this.dateOfReview.plusYears(1);
	}
	
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public LocalDate getDateOfReview() {
		return dateOfReview;
	}
	public void setDateOfReview(LocalDate dateOfReview) {
		this.dateOfReview = dateOfReview;
	}
	public LocalDate getNextReviewDate() {
		return nextReviewDate;
	}
	public void setNextReviewDate(LocalDate nextReviewDate) {
		this.nextReviewDate = nextReviewDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
