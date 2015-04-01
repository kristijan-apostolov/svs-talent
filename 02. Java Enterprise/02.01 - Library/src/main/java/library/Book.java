package library;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "isbn")
	private String isbn;
	@Column(name = "title")
	private String title;

	// persistent class
	public Book() {
	}

	public Book(long id, String isbn, String title) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", isbn=" + isbn + ", title=" + title + "]";
	}

}
