package services;

import java.util.List;

import services.exceptions.EmailExistsException;
import services.exceptions.IsbnExistsException;
import services.exceptions.IssnExistsException;
import entities.Book;
import entities.Magazine;
import entities.Member;

public class Validator {

	public static void checkISBN(List<Book> list, Book book)
			throws IsbnExistsException {
		for (Book x : list) {
			if (x.getIsbn().equals(book.getIsbn()) && x.getId() != book.getId()) {
				throw new IsbnExistsException();
			}
		}
	}

	public static void checkISSN(List<Magazine> list, Magazine magazine)
			throws IssnExistsException {
		for (Magazine x : list) {
			if (x.getIssn().equals(magazine.getIssn())
					&& x.getId() != magazine.getId()) {
				throw new IssnExistsException();
			}
		}
	}

	public static void checkEmail(List<Member> list, Member member)
			throws EmailExistsException {
		for (Member x : list) {
			if (x.getEmail().equals(member.getEmail())
					&& x.getId() != member.getId()) {
				throw new EmailExistsException();
			}
		}
	}

	public static boolean isValidEmailAddress(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}
}
