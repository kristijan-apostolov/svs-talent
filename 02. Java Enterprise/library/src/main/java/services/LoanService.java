package services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import services.exceptions.NoSuchIdException;
import dao.DAO;
import dao.HibernateLoanDAO;
import dao.HibernateMemberDAO;
import dao.HibernatePublicationDAO;
import entities.Loan;
import entities.Member;
import entities.Publication;

@SuppressWarnings("unchecked")
public class LoanService {

	private DAO loanDAO = new HibernateLoanDAO();
	private DAO publicationDAO = new HibernatePublicationDAO();
	private DAO memberDAO = new HibernateMemberDAO();

	public List<Loan> getLoans() {
		return loanDAO.getAll();
	}

	public void deleteLoan(long id) throws NoSuchIdException {
		Loan loan = (Loan) loanDAO.get(id);
		if (loan == null) {
			throw new NoSuchIdException();
		}
		loanDAO.delete(loan);
	}

	public void addLoan(long memberId, long publicationId)
			throws NoSuchIdException {

		Member member = (Member) memberDAO.get(memberId);
		Publication publication = (Publication) publicationDAO
				.get(publicationId);
		if (member == null || publication == null) {
			throw new NoSuchIdException();
		}

		Date startDate = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		calendar.add(Calendar.DATE, 14);
		Date endDate = calendar.getTime();

		Loan loan = new Loan();
		loan.setMember(member);
		loan.setPublication(publication);
		loan.setStartDate(startDate);
		loan.setEndDate(endDate);

		loanDAO.insert(loan);
	}
}
