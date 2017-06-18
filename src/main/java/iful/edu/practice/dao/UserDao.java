package iful.edu.practice.dao;

import java.util.List;

import iful.edu.practice.model.User;

public interface UserDao {
	public void addUser(User user);

	public void updateUser(User user);

	public User getUserById(int id);

	public void deleteUser(int user_id);

	public List<User> getUsers();

}