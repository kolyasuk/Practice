package iful.edu.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iful.edu.practice.interfaces.ItemDao;
import iful.edu.practice.interfaces.ItemService;
import iful.edu.practice.model.Item;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao ItemDao;

	@Override
	public void addItem(Item item) {
		ItemDao.addItem(item);
	}

	@Override
	public void updateItem(Item item) {
		ItemDao.updateItem(item);
	}

	@Override
	public Item getItem(int id) {
		return ItemDao.getItem(id);
	}

	@Override
	public void deteleItem(int id) {
		ItemDao.deteleItem(id);

	}

	@Override
	public List<Item> getItems() {
		return ItemDao.getItems();
	}
}