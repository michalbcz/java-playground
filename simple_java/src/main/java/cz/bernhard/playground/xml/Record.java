package cz.bernhard.playground.xml;

public class Record {
	
	private String productId;
	private String brand;
	private String name;
	
	public String getProductId() {
		return productId;
	}
	public Record setProductId(String productId) {
		this.productId = productId;
		return this;
	}
	public String getBrand() {
		return brand;
	}
	
	public Record setBrand(String brand) {
		this.brand = brand;
		return this;
	}
	
	public String getName() {
		return name;
	}
	
	public Record setName(String name) {
		this.name = name;
		return this;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((productId == null) ? 0 : productId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Record other = (Record) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}
	
	

}
