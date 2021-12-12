package services;

import java.util.List;

import model.User;
import persistence.UserDAO;
import persistence.commons.DAOFactory;

public class UserService {
	
	public List<User> list() {
		return DAOFactory.getUserDAO().findAll();
	}
	
	public User find(Integer id) {
		UserDAO	userDAO = DAOFactory.getUserDAO();
		return userDAO.find(id);
	}

	public User update(Integer id, String username, Double coins, Double time) {

		UserDAO userDAO = DAOFactory.getUserDAO();
		User user = userDAO.find(id);

		user.setUsername(username);
		user.setCoins(coins);
		user.setTime(time);

		if (user.isValid()) {
			userDAO.update(user);
		}

		return user;
	}

	public void delete(Integer id) {
		User user = new User(id, null, null, null, null, null, null, null);

		UserDAO userDAO = DAOFactory.getUserDAO();
		userDAO.delete(user);
	}

}
