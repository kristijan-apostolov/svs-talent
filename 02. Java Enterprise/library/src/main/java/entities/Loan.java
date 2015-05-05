package entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Loan extends BaseEntity {

	private Date startDate;
	private Date endDate;
	@ManyToOne
	private Member member;
	@ManyToOne
	private Publication publication;

	public Loan() {
		super();
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

	@Override
	public String toString() {
		return "ID:" + getId() + " | " + startDate + " - " + endDate
				+ " | Member:" + member.getId() + " Publication:"
				+ publication.getId();
	}

}
