package iful.edu.practice.dao;

import java.util.List;

import iful.edu.practice.model.Order;

public interface OrderDao {

	public void addOrder(Order order);

	public Order getOrder(int id);

	public void deleteOrder(int id);

	public List<Order> getOrders();

}