package services;

import java.util.List;

import services.exceptions.EmailExistsException;
import services.exceptions.InvalidEmailException;
import services.exceptions.NoSuchIdException;
import dao.DAO;
import dao.HibernateMemberDAO;
import entities.Member;

@SuppressWarnings("unchecked")
public class MemberService {

	private DAO memberDAO = new HibernateMemberDAO();

	public List<Member> getMembers() {
		return memberDAO.getAll();
	}

	public void registerMember(String name, String email)
			throws InvalidEmailException, EmailExistsException {
		if (!Validator.isValidEmailAddress(email)) {
			throw new InvalidEmailException();
		}
		Member member = new Member();
		member.setName(name);
		member.setEmail(email);
		Validator.checkEmail(memberDAO.getAll(), member);
		memberDAO.insert(member);
	}

	public void updateMember(long id, String name, String email)
			throws NoSuchIdException, InvalidEmailException,
			EmailExistsException {
		if (!Validator.isValidEmailAddress(email)) {
			throw new InvalidEmailException();
		}
		Member member = new Member();
		member.setId(id);
		member.setName(name);
		member.setEmail(email);
		if (memberDAO.get(id) == null) {
			throw new NoSuchIdException();
		}
		Validator.checkEmail(memberDAO.getAll(), member);
		memberDAO.update(member);
	}

	public void deleteMember(long id) throws NoSuchIdException {
		Member member = (Member) memberDAO.get(id);
		if (member == null) {
			throw new NoSuchIdException();
		}
		memberDAO.delete(member);
	}

}
