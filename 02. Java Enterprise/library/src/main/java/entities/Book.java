package entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Book extends Publication {

	@Column(unique = true)
	private String isbn;

	public Book() {
		super();
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book => ID:" + getId() + " | Title:" + getTitle() + " | ISBN:"
				+ getIsbn();
	}
}
