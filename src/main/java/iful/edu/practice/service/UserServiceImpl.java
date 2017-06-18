package iful.edu.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iful.edu.practice.dao.UserDao;
import iful.edu.practice.model.User;

@Service("user")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Transactional
	public void addUser(User user) {
		userDao.addUser(user);

	}

	@Transactional
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Transactional
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	@Transactional
	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}

	@Transactional
	public List<User> getUsers() {
		return userDao.getUsers();
	}

}