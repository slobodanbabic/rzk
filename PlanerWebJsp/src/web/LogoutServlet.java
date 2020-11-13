package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rzk.PlannerBeanRemote;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogoutServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		PlannerBeanRemote bean = (PlannerBeanRemote) request.getSession().getAttribute("bean");
		bean.destroy();
		request.setAttribute("message", "Uspesno ste se odjavili.");
		request.getSession().setAttribute("bean", null);
		request.getSession().setAttribute("events", null);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
