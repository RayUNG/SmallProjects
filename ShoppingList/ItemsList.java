package com.ray88u;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ItemsList {

	private final Map<String, Item> list;
	
	public ItemsList() {
		this.list = new LinkedHashMap<>();
	}
	
	public Map<String, Item> Items(){
		return Collections.unmodifiableMap(list);
	}
	
	public Item get(String key) {
		return list.get(key);
	}
	
	public int addToList(Item item) {
		if(item != null) {
			Item inStock = list.getOrDefault(item.getName(), item);
			if(inStock != item) {
				System.out.println("Item already in stock");
			}
			list.put(item.getName(), item);
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		String s = "\nStock List:\n";
		for(Map.Entry<String, Item> item : list.entrySet()) {
			Item shoppingItem = item.getValue();
			s = s + shoppingItem.getName()+" "+shoppingItem.getPrice()+"\n";
		}		
		return s;		
	}
	
	
	
}
