package iful.edu.practice.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import iful.edu.practice.model.Item;

@Repository
public class ItemDaoImpl implements ItemDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addItem(Item item) {
		getCurrentSession().save(item);
	}

	public void updateItem(Item item) {
		Item itemToUpdate = getItem(item.getItem_id());
		itemToUpdate.setName(item.getName());
		itemToUpdate.setPhoto(item.getPhoto());
		itemToUpdate.setDescription(item.getDescription());
		itemToUpdate.setPrice(item.getPrice());
	}

	public Item getItem(int id) {
		Item item = (Item) getCurrentSession().get(Item.class, id);
		return item;
	}

	public void deteleItem(int id) {
		Item item = getItem(id);
		if (item != null) {
			getCurrentSession().delete(item);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Item> getItems() {
		return getCurrentSession().createQuery("from Item").list();
	}

}
