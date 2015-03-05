package com.store.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet(name = "Register", urlPatterns = { "/reg" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static Logger logger = Logger.getLogger(RegisterServlet.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
		String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
       // Date birthdate=new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthdate"));
        String country=request.getParameter("country");
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        String zipcode = request.getParameter("zipcode");
        String telephone = request.getParameter("telephone");

		String errorMsg = null;
        if(firstname == null || firstname.equals("")){
            errorMsg = "First Name can't be null or empty.";
        }
        if(lastname == null || lastname.equals("")){
            errorMsg = "Last Name can't be null or empty.";
        }
		if(email == null || email.equals("")){
			errorMsg = "Email can't be null or empty.";
		}
        if(login == null || login.equals("")){
            errorMsg = "Login can't be null or empty.";
        }
		if(password == null || password.equals("")){
			errorMsg = "Password can't be null or empty.";
		}
        if(confirmPassword == null || confirmPassword.equals("")){
            errorMsg = "Confirm Password can't be null or empty.";
        }
		if(country == null || country.equals("")){
			errorMsg = "Country can't be null or empty.";
		}
        if(city == null || city.equals("")){
            errorMsg = "City can't be null or empty.";
        }
        if(street == null || street.equals("")){
            errorMsg = "Street can't be null or empty.";
        }
        if(telephone == null || telephone.equals("")){
            errorMsg = "Telephone can't be null or empty.";
        }
		
		if(errorMsg != null){
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/register.jsp");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>"+errorMsg+"</font>");
			rd.include(request, response);
		}else{
		
		Connection con = (Connection) getServletContext().getAttribute("DBConnection");
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("insert into user(firstname, lastname, email, login, password, confirmPassword, country," +
                    "city, street, zipcode, telephone) values (?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, email);
			ps.setString(4, login);
            ps.setString(5, password);
            ps.setString(6, confirmPassword);
            ps.setString(7, country);
            ps.setString(8, city);
            ps.setString(9, street);
            ps.setString(10, zipcode);
            ps.setString(11, telephone);
			ps.execute();
			
			logger.info("User registered with email="+email);
			
			//forward to login page to login
			RequestDispatcher rd = getServletContext().getRequestDispatcher("login.jsp");
			PrintWriter out= response.getWriter();
			out.println("<font color=green>Registration successful, please login below.</font>");
			rd.include(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Database connection problem");
			throw new ServletException("DB Connection problem.");
		}finally{
			try {
				ps.close();
			} catch (SQLException e) {
				logger.error("SQLException in closing PreparedStatement");
			}
		}
		}
		
	}

}
