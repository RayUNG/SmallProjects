package com.ray88u;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
	
	public final String name;
	private final Map<Item, Integer> list;
	
	public Basket(String name) {
		this.name = name;
		this.list = new TreeMap<>();
	}

	public int addToBasket(Item item, int quantity) {
		if((item != null) && (quantity > 0)) {
			int inBasket = list.getOrDefault(item, 0);
			list.put(item, inBasket+quantity);
			return inBasket;
		}
		return 0;
	}
	
	public int removeFromBasket(Item item, int quantity) {
		if((item != null) && (quantity > 0)) {
			int inBasket = list.getOrDefault(item, 0);
			int newQuantity = inBasket - quantity;
			if(newQuantity > 0) {
				list.put(item, newQuantity);
				return quantity;
			}else if(newQuantity == 0) {
				list.remove(item);
				return quantity;
			}
		}
		return 0;
	}
	
	public void clearBasket() {
		this.list.clear();
	}
	
	public Map<Item, Integer> Items(){
		return Collections.unmodifiableMap(list);
	}

	@Override
	public String toString() {
		String s = "\nShopping basket " + name + " contains " + list.size() +
				((list.size() == 1)? " item" : " items") + "\n";
		double totalCost = 0.0;
		for(Map.Entry<Item, Integer> item : list.entrySet()) {
			s = s + item.getKey() + item.getValue() + "\n";
			totalCost += item.getKey().getPrice() * item.getValue();
		}
		return s + "Total cost " + totalCost;
	}
	
	
	
}
