package iful.edu.practice.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import iful.edu.practice.interfaces.UserDao;
import iful.edu.practice.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addUser(User user) {
		getCurrentSession().save(user);
	}

	@Override
	public void updateUser(User user) {
		User userToUpdate = getUser(user.getId());
		userToUpdate.setFirstName(user.getFirstName());
		userToUpdate.setLastName(user.getLastName());
		userToUpdate.setRole(user.getRole());
		getCurrentSession().update(userToUpdate);
	}

	@Override
	public User getUser(int id) {
		User user = (User) getCurrentSession().get(User.class, id);
		return user;
	}

	@Override
	public void deleteUser(int id) {
		User user = getUser(id);
		if (user != null) {
			getCurrentSession().delete(user);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		return getCurrentSession().createQuery("from User").list();
	}

}
