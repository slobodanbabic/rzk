package rzk;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import javax.ejb.Remote;

import model.Event;

@Remote
public interface PlannerBeanRemote {

	public String login(String user, String pass);

	public boolean createEvent(String description, Timestamp fromDate, Timestamp toDate, int eventTypeID);

	public List<Event> searchEvents(Date date);

	public HashMap<Integer, String>getTypes();

	public void destroy();
}
