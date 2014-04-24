package servlets;

import java.io.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidateCreditCard
 */
@WebServlet(urlPatterns="/ValidateCreditCard")
public class ValidateCreditCard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String validCard;
	BufferedReader queryString;
	
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();

		String ccNum= request.getParameter("creditCardNumber".toString());
		String pass= request.getParameter("Password".toString());

		if ((ccNum.equals("1111111111111111")) && (pass.equals("0000"))){
			out.write("<html><head><title>Initiate Transaction</title></head>");
			out.write("<body><form action=\"ValidateCreditCard\" method=\"post\">");
    		out.write("<h1> Valid card, select your options </h1>");
    		out.write("<button type=\"submit\" formaction=\"http://localhost:8080/DependentTransaction/WithdrawalInformation.html\">Witdhrawal</button>");
    		out.write("<button type=\"submit\" formaction=\"http://localhost:8080/DependentTransaction\">Deposit</button>");
    		out.write("</form></body></html>");
    	}
		else{
			out.write("<h1>Invalid credit card.</h1>");
			out.write("<a href=\"http://localhost:8080/DependentTransaction\" > Try again. </a>");
		}
    	}
	}
