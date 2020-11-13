package web;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rzk.PlannerBeanRemote;

/**
 * Servlet implementation class CreateEventServlet
 */
@WebServlet("/CreateEventServlet")
public class CreateEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateEventServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PlannerBeanRemote bean = (PlannerBeanRemote) request.getSession().getAttribute("bean");
		
		String description = request.getParameter("description");
		int eventTypeID = Integer.parseInt(request.getParameter("eventType"));
		String date = request.getParameter("date");	
		String fromTime = request.getParameter("fromTime");		
		String toTime = request.getParameter("toTime");
		
		LocalDateTime fromDate = LocalDateTime.parse(date + "T" + fromTime);
		LocalDateTime toDate = LocalDateTime.parse(date + "T" + toTime);		
		bean.createEvent(description, Timestamp.valueOf(fromDate), Timestamp.valueOf(toDate), eventTypeID);
		request.getSession().getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
