package iful.edu.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iful.edu.practice.dao.ItemDao;
import iful.edu.practice.model.Item;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao ItemDao;

	@Transactional
	public void addItem(Item item) {
		ItemDao.addItem(item);
	}

	@Transactional
	public void updateItem(Item item) {
		ItemDao.updateItem(item);
	}

	@Transactional
	public Item getItem(int id) {
		return ItemDao.getItem(id);
	}

	@Transactional
	public void deleteItem(int id) {
		ItemDao.deteleItem(id);

	}

	@Transactional
	public List<Item> getItems() {
		return ItemDao.getItems();
	}

}