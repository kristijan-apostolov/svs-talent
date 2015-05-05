package entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Magazine extends Publication {

	@Column(unique = true)
	private String issn;

	public Magazine() {
		super();
	}

	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn;
	}

	@Override
	public String toString() {
		return "Magazine => ID:" + getId() + " | Title:" + getTitle()
				+ " | ISSN:" + getIssn();
	}
}
