package iful.edu.practice.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import iful.edu.practice.interfaces.ItemDao;
import iful.edu.practice.model.Item;

@Repository
public class ItemDaoImpl implements ItemDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addItem(Item item) {
		getCurrentSession().save(item);
	}

	@Override
	public void updateItem(Item item) {
		Item itemToUpdate = getItem(item.getId());
		itemToUpdate.setName(item.getName());
		itemToUpdate.setPhoto(item.getPhoto());
		itemToUpdate.setDescription(item.getDescription());
		itemToUpdate.setPrice(item.getPrice());
		getCurrentSession().update(itemToUpdate);
	}

	@Override
	public Item getItem(int id) {
		Item item = (Item) getCurrentSession().get(Item.class, id);
		return item;
	}

	@Override
	public void deteleItem(int id) {
		Item item = getItem(id);
		if (item != null) {
			getCurrentSession().delete(item);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> getItems() {
		return getCurrentSession().createQuery("from Item").list();
	}

}
