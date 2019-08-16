package app.model;

public class table {

	String movie;
	String releaseYear;
	String director;
	String dateBirth;
	
	public table(String movie, String releaseYear, String director, String dateBirth) {
		this.movie = movie;
		this.releaseYear = releaseYear;
		this.director = director;
		this.dateBirth = dateBirth;
	}
	
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
	public String getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getDateBirth() {
		return dateBirth;
	}
	public void setDateBirth(String dateBirth) {
		this.dateBirth = dateBirth;
	}
}
