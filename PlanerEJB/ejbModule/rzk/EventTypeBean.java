package rzk;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.EventType;

/**
 * Session Bean implementation class EventTypeBean
 */

@Singleton
@Startup
public class EventTypeBean {

	@PersistenceContext
	EntityManager em;
	
	
	private HashMap<Integer, String> types;

	public EventTypeBean() {		
		  types = new HashMap<Integer, String>();		 
	}

	public HashMap<Integer, String> getTypes() {
		return types;
	}

	@PostConstruct
	public void load() {
		TypedQuery<EventType> query = em.createNamedQuery("EventType.findAll", EventType.class);
		  List<EventType> eventTypes = query.getResultList();
		  
		  for (EventType et : eventTypes) 
			  types.put(et.getId(), et.getName());
		System.out.println("EventTypeBean created."+LocalDateTime.now());
	}
}
