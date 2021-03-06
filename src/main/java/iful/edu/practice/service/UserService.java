package iful.edu.practice.service;

import java.util.List;

import iful.edu.practice.model.User;

public interface UserService {

	public void addUser(User user);

	public void updateUser(User user);

	public User getUserById(int id);

	public User getUserByLogin(String login);

	public void deleteUser(int id);

	public List<User> getUsers();

}
