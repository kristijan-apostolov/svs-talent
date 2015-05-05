package com.seavus.webcalculator;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		print(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		print(req, resp);
	}

	@SuppressWarnings("unchecked")
	private void print(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		HttpSession session = req.getSession();
		ArrayList<Operation> operations = (ArrayList<Operation>) session
				.getAttribute("operations");
		if(operations == null){
			operations = new ArrayList<Operation>();
		}
		
		resp.setContentType("text/html");
		for (Operation operation : operations) {
			resp.getWriter().println(operation+"<br>");
		}
	}
}
