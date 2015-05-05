package aliexpress.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class CreditCard extends BaseEntity {

	private long cardNumber;
	private String nameOnCard;
	private byte expirationMonth;
	private short expirationYear;
	private short cvc;
	@ManyToOne
	private Account account;

	public CreditCard() {
		super();
	}

	public CreditCard(long cardNumber, String nameOnCard, byte expirationMonth,
			short expirationYear, short cvc, Account account) {
		super();
		this.cardNumber = cardNumber;
		this.nameOnCard = nameOnCard;
		this.expirationMonth = expirationMonth;
		this.expirationYear = expirationYear;
		this.cvc = cvc;
		this.account = account;
	}

	public short getCvc() {
		return cvc;
	}

	public void setCvc(short cvc) {
		this.cvc = cvc;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public byte getExpirationMonth() {
		return expirationMonth;
	}

	public void setExpirationMonth(byte expirationMonth) {
		this.expirationMonth = expirationMonth;
	}

	public short getExpirationYear() {
		return expirationYear;
	}

	public void setExpirationYear(short expirationYear) {
		this.expirationYear = expirationYear;
	}

	@Override
	public String toString() {
		return "ID:" + getId() + " Card Number:" + cardNumber + " Name:"
				+ nameOnCard + " Expiration:" + expirationMonth + " "
				+ expirationYear + " CVC2/CVV2:" + cvc;
	}

}
