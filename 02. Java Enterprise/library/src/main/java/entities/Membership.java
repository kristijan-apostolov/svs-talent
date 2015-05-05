package entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Membership extends BaseEntity {

	private Date startDate;
	private Date endDate;
	private String memebershipType;
	@OneToOne
	private Member member;

	public Membership() {
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

	public String getMemebershipType() {
		return memebershipType;
	}

	public void setMemebershipType(String memebershipType) {
		this.memebershipType = memebershipType;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}
