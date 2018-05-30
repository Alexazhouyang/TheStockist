package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;
import dao.FindIdDAO;
import dao.MechDAO;
import dao.UserDAO;
import model.Users;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Users users = new Users();
		String username,firstname,lastname,email,phonenumber,address,description,password,role;
		int userid;
		try {
			username=request.getParameter("username");
			firstname=request.getParameter("firstname");
			lastname=request.getParameter("lastname");
			password=request.getParameter("password");
			email=request.getParameter("email");
			phonenumber=request.getParameter("phonenumber");
			description = request.getParameter("description");
			address=request.getParameter("address");
			role=request.getParameter("role");
			
			users.setUsername(username);
			users.setFirstname(firstname);
			users.setLastname(lastname);
			users.setEmail(email);
			users.setPassword(password);
			users.setPhonenumber(phonenumber);
			users.setDescription(description);
			users.setAddress(address);
			users.setRole(role);
			UserDAO userDAO = new UserDAO();
			AdminDAO adminDAO = new AdminDAO();
			FindIdDAO fIdDAO =new FindIdDAO();
			MechDAO mechDAO = new MechDAO();
			userDAO.insertUser(users);
			userid = fIdDAO.FindID(users);
			
			if(role.equals("admin"))
			{
			adminDAO.insertAdmin(users, userid);
			users = adminDAO.selectAdmin(users,userid);
			users = userDAO.FindLog(users, userid);
			request.getSession().setAttribute("users", users);
		request.getRequestDispatcher("admin.jsp").forward(request,response);
			}
			else {
				mechDAO.insertMech(users, userid);
				users = mechDAO.selectMech(users,userid);
				users = userDAO.FindLog(users, userid);
				request.getSession().setAttribute("users", users);
			request.getRequestDispatcher("mechanic.jsp").forward(request,response);
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
