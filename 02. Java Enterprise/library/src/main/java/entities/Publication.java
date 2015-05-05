package entities;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public abstract class Publication extends BaseEntity {

	private String title;
	@OneToMany(mappedBy = "publication")
	private Set<Loan> loans;

	public Publication() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Loan> getLoans() {
		return loans;
	}

	public void setLoans(Set<Loan> loans) {
		this.loans = loans;
	}

}
