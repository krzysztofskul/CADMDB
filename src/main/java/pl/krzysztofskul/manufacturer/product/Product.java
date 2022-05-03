package pl.krzysztofskul.manufacturer.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import pl.krzysztofskul.manufacturer.Manufacturer;

@Entity
public class Product {

	/**
	 * params.
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/*
	 * todo: create enum for standarized product names
	 */
	private Object nameCategorized;
	
	private String nameModel;
	
	private Manufacturer manufacturer;

	/**
	 * constr.
	 */
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * getters and setters
	 */

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nameCategorized
	 */
	public Object getNameCategorized() {
		return nameCategorized;
	}

	/**
	 * @param nameCategorized the nameCategorized to set
	 */
	public void setNameCategorized(Object nameCategorized) {
		this.nameCategorized = nameCategorized;
	}

	/**
	 * @return the nameModel
	 */
	public String getNameModel() {
		return nameModel;
	}

	/**
	 * @param nameModel the nameModel to set
	 */
	public void setNameModel(String nameModel) {
		this.nameModel = nameModel;
	}

	/**
	 * @return the manufacturer
	 */
	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	/**
	 * @param manufacturer the manufacturer to set
	 */
	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	
	
	
	
}
