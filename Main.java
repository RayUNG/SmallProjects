package com.ray88u;

public class Main {
	private static ItemsList list = new ItemsList();
	
	public static void main(String[] args) {
		
		Item temp = new Item("still water", 0.55);
		list.addToList(temp);
		
		temp = new Item("Plain flour", 0.45);
		list.addToList(temp);
		
		temp = new Item("Self rais flour", 0.45);
		list.addToList(temp);
		
		temp = new Item("Smoked bavarian ham", 1.09);
		list.addToList(temp);

		temp = new Item("Roast ham", 1.19);
		list.addToList(temp);

		temp = new Item("Chicken breast", 5.29);
		list.addToList(temp);

		temp = new Item("Pork medallions", 2.39);
		list.addToList(temp);

		temp = new Item("Chicken thighs", 1.65);
		list.addToList(temp);

		temp = new Item("Semi skimmed milk", 0.79);
		list.addToList(temp);

		temp = new Item("Tuna in sunflowerOil", 2.49);
		list.addToList(temp);

		temp = new Item("Philadelphia G&H", 0.99);
		list.addToList(temp);

		temp = new Item("Grana padano", 2.49);
		list.addToList(temp);

		temp = new Item("British butter", 1.49);
		list.addToList(temp);
		
		temp = new Item("Apple Juice", 0.89);
		list.addToList(temp);
		
		System.out.println(list);
		/*
		 * for(String s: list.Items().keySet()) {
		 * System.out.println(s+" "+list.Items().get(s).getPrice()); }
		 */
		Basket rayBasket = new Basket("Ray");
		
		addToBasket(rayBasket, "Apples 1kg", 1);
		addToBasket(rayBasket, "Apple Juice", 2);
		addToBasket(rayBasket, "British butter", 1);
		addToBasket(rayBasket, "Tuna in sunflowerOil", 1);
		System.out.println(rayBasket);
		removeFromBasket(rayBasket, "Apple Juice", 1);
		System.out.println(rayBasket);
		clearBasket(rayBasket);
		System.out.println(rayBasket);
		
		
		
		
	}
	
	public static int addToBasket(Basket basket, String item, int quantity) {
		Item itemChecked = list.get(item);
		if(itemChecked == null) {
			System.out.println(item +" not found");
			return 0;
		}else {
			return basket.addToBasket(itemChecked, quantity);
		}	
	}
	
	public static int removeFromBasket(Basket basket, String item, int quantity) {
		Item itemChecked = list.get(item);
		if(itemChecked == null) {
			System.out.println(item +" not found");
			return 0;
		}else {
			return basket.removeFromBasket(itemChecked, quantity);
		}	
	}
	
	public static void clearBasket(Basket basket) {
		basket.clearBasket();
	}

}
 