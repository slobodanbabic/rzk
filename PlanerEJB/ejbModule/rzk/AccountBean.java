package rzk;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.User;

/**
 * Session Bean implementation class AccountBean
 */
@Stateless
@LocalBean
public class AccountBean{
	
	@PersistenceContext
	EntityManager em;
	
	public AccountBean() {
        // TODO Auto-generated constructor stub
    }

	
	public boolean createAccount(String email, String password, String firstName, String lastName) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);		
		user = em.merge(user);
		em.persist(user);
		return user.getId() != 0;
	}

}
