package iful.edu.practice.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import iful.edu.practice.model.Item;
import iful.edu.practice.model.Order;
import iful.edu.practice.model.User;

@Repository
public class OrderDaoImpl implements OrderDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addOrder(Order order) {
		User user = new User();
		Item item = new Item();
		java.sql.Date date = new java.sql.Date((new java.util.Date()).getTime());
		order.setUserId(user.getId());
		order.setItemId(item.getId());
		order.setTotalPrice(item.getPrice());
		order.setOrderDate(date);
		order.setStatus("true");
	}

	public Order getOrder(int id) {
		Order order = (Order) getCurrentSession().get(Order.class, id);
		return order;
	}

	public void deleteOrder(int id) {
		Order order = getOrder(id);
		if (order != null) {
			getCurrentSession().delete(order);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Order> getOrders() {
		return getCurrentSession().createQuery("from UserOrder").list();
	}
}
