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
		User userToUpdate = getUser(user.getUser_id());
		userToUpdate.setFirst_name(user.getFirst_name());
		userToUpdate.setLast_name(user.getLast_name());
		userToUpdate.setRole(user.getRole());
	}

	public User getUser(int user_id) {
		User user = (User) getCurrentSession().get(User.class, user_id);
		return user;
	}

	public void deleteUser(int user_id) {
		User user = getUser(user_id);
		if (user != null) {
			getCurrentSession().delete(user);
		}
	}

	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		return getCurrentSession().createQuery("from User").list();
	}
}
