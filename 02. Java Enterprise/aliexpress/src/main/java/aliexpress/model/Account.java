package aliexpress.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Account extends BaseEntity {

	private String name;
	@Column(unique = true)
	private String email;
	private String password;
	@OneToMany(mappedBy = "account")
	private Set<CreditCard> creditcards;

	public Account() {
		super();
	}

	public Account(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<CreditCard> getCreditcards() {
		return creditcards;
	}

	public void setCreditcards(Set<CreditCard> creditcards) {
		this.creditcards = creditcards;
	}

	@Override
	public String toString() {
		return "Name:" + name + " Email:" + email + " Password:" + password;
	}

}
