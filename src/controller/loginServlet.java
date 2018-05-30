package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;
import dao.MechDAO;
import dao.UserDAO;
import model.Users;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		//get input user information
		UserDAO userDAO = new UserDAO();
		AdminDAO adminDAO =new AdminDAO();
		MechDAO mechDAO = new MechDAO();
		
		Users  users =new Users();
		String check = userDAO.judgeUserPassword(userName);
		//judge user exist?
		
		String message = "username or password error!";
		if(check.equals(password))
		{
			int userid = userDAO.FindID(userName);			
			String role = userDAO.FindRole(userid);
			
			
			if(role.equals("admin"))
			{				
				users = adminDAO.selectAdmin(users,userid);
				users = userDAO.FindLog(users, userid);
				request.getSession().setAttribute("users", users);
			request.getRequestDispatcher("admin.jsp").forward(request,response);
			}
			else if(role.equals("mechanic")){
				users = mechDAO.selectMech(users,userid);
				users = userDAO.FindLog(users, userid);
				request.getSession().setAttribute("users", users);
			request.getRequestDispatcher("mechanic.jsp").forward(request,response);
			}else {
				request.getSession().setAttribute("message", message);
				response.sendRedirect("pages/login.jsp");
			}
			
		}else {
			
			request.getSession().setAttribute("message", message);
			response.sendRedirect("pages/login.jsp");
//			request.getRequestDispatcher("pages/login.jsp").forward(request,response);
			
		}
		
	}

}
