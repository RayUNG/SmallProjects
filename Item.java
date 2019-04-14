package com.ray88u;

public class Item implements Comparable<Item>{

	private final String name;
	private double price;
	private int quantity;

	public Item(String name, double price) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = 0;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}
	
	public int getQuantityNeeded() {
		return quantity;
	}
	
	public void setQuantityNeeded(int quantityNeeded) {
		this.quantity = quantityNeeded;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode() + 31;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("Entering Items.equals");
		if(obj == this) {
			return true;
		}
		if((obj == null) || (obj.getClass() != this.getClass())) {
			return false;
		}
		String objName = ((Item) obj).getName();
		return this.name.equals(objName);
	}

	@Override
	public int compareTo(Item o) {
//		System.out.println("Entering Item.compareTo");
		if(this==o) {
			return 0;
		}
		if(o != null) {
			return this.name.compareTo(o.getName());
		}
		throw new NullPointerException();
	}

	@Override
	public String toString() {
		return this.name + " : price " + this.price + " quantity : ";
	}
}
