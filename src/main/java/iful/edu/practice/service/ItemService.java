package iful.edu.practice.service;

import java.util.List;

import iful.edu.practice.model.Item;

public interface ItemService {

	public void addItem(Item item);

	public void updateItem(Item item);

	public Item getItem(int id);

	public void deleteItem(int id);

	public List<Item> getItems();

}
