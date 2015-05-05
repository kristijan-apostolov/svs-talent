package com.seavus.webcalculator;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calculate")
public class CalculateServlet extends HttpServlet {
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
		if (operations == null) {
			operations = new ArrayList<Operation>();
		}

		resp.setContentType("text/html");

		try {
			int op1 = Integer.parseInt(req.getParameter("operandOne"));
			int op2 = Integer.parseInt(req.getParameter("operandTwo"));
			Operator operator = Operator.valueOf(req.getParameter("operation"));
			Operation operation = new Operation(op1, op2, operator);

			operations.add(operation);
			session.setAttribute("operations", operations);

			resp.getWriter().println(operation);
		} catch (IllegalArgumentException e) {
			resp.getWriter().println("Invalid arguments!");
		}
	}
}
