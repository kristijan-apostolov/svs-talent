package entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Member extends BaseEntity {

	private String name;
	@Column(unique = true)
	private String email;
	@OneToMany(mappedBy = "member")
	private Set<Loan> loans;

	public Member() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Loan> getLoans() {
		return loans;
	}

	public void setLoans(Set<Loan> loans) {
		this.loans = loans;
	}

	@Override
	public String toString() {
		return "ID:" + getId() + " | Name:" + getName() + " | Email:"
				+ getEmail();
	}

}
