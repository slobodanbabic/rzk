package rzk;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Event;
import model.EventType;
import model.User;

/**
 * Session Bean implementation class PlannerBean
 */
@Stateful
@LocalBean
public class PlannerBean implements PlannerBeanRemote {

	@PersistenceContext
	EntityManager em;

	private String userID;

	@EJB
	EventTypeBean eventTypeBean;

	/**
	 * Default constructor.
	 */
	public PlannerBean() {
		// TODO Auto-generated constructor stub
	}

	public String getUserID() {
		return userID;
	}

	@Override
	public String login(String user, String pass) {
		if (userID != null)
			return userID;
		Query q = em.createQuery("SELECT u FROM User u WHERE u.email LIKE :user AND u.password LIKE :pass");
		q.setParameter("user", user);
		q.setParameter("pass", pass);
		List<User> users = q.getResultList();
		System.out.println(users.size());

		try {
			userID = String.valueOf(users.get(0).getId());
			System.out.println("ID usera je: "+userID);
			return userID;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}

	@Override
	public boolean createEvent(String description, Timestamp fromDate, Timestamp toDate, int eventTypeID) {
		boolean ok = false;
		Event e = new Event();
		User user = em.find(User.class, Integer.parseInt(userID));
		EventType eventType = em.find(EventType.class, eventTypeID);
		if (user == null || eventType == null)
			return ok;
		e.setUser(user);
		e.setDescription(description);
		e.setFromDate(fromDate);
		e.setToDate(toDate);
		e.setEventType(eventType);
		e = em.merge(e);
		em.persist(e);
		ok = true;
		return ok;
	}

	@Override
	public List<Event> searchEvents(Date date) {
		TypedQuery<Event> query = em.createQuery("SELECT e FROM Event e where e.user.id =:id AND e.fromDate >= :fromDate "
				+ "AND e.toDate < :toDate", Event.class);
		query.setParameter("fromDate", date);		 
		query.setParameter("id", Integer.parseInt(userID));
		Date toDate = Date.valueOf(LocalDate.parse(date.toString()).plusDays(1).toString());
		query.setParameter("toDate", toDate);
		return query.getResultList();
	}

	@Override
	public HashMap<Integer, String> getTypes() {
		return eventTypeBean.getTypes();
	}

	@Remove
	@Override
	public void destroy() {
		System.out.println("PlanerBean removed " + LocalDateTime.now());

	}

	@PreDestroy
	private void cleenup() {
		System.out.println("PlanerBean destroyed " + LocalDateTime.now());
	}

}
