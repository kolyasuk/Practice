package iful.edu.practice.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import iful.edu.practice.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addUser(User user) {
		getCurrentSession().save(user);
	}

	public void updateUser(User user) {
		User userToUpdate = getUserById(user.getId());
		userToUpdate.setLogin(user.getLogin());
		userToUpdate.setName(user.getName());
		userToUpdate.setPassword(user.getPassword());
		userToUpdate.setEmail(user.getEmail());
		userToUpdate.setRole(user.getRole());
	}

	public User getUserById(int id) {
		User user = (User) getCurrentSession().get(User.class, id);
		return user;
	}

	public void deleteUser(int id) {
		User user = getUserById(id);
		if (user != null) {
			getCurrentSession().delete(user);
		}
	}

	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		return getCurrentSession().createQuery("from User").list();
	}
}
