package ie.cct.CloudCA2019432;

public class Animal {
	private String type;
	private Float weight;
	private Float price;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Float getWeight() {
		return weight;
	}
	public void setWeight(Float weight) {
		this.weight = weight;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Animal(String type, Float weight, Float price) {
		super();
		this.type = type;
		this.weight = weight;
		this.price = price;
	}
	public Animal() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
