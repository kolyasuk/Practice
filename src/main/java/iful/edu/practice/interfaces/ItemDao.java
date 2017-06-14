package iful.edu.practice.interfaces;

import java.util.List;

import iful.edu.practice.model.Item;

public interface ItemDao {
	public void addItem(Item item);

	public void updateItem(Item item);

	public Item getItem(int id);

	public void deteleItem(int id);

	public List<Item> getItems();

}