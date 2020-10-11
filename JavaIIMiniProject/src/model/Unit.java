package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="units")
public class Unit {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="NUM_BEDS")
	private int beds;
	@Column(name="NUM_BATHS")
	private int baths;
	@Column(name="FLOOR")
	private int floor;
	@Column(name="ADDRESS")
	private String address;
	
	//constructors
	public Unit() {
		super();
		//  Auto-generated constructor stub
	}
	public Unit(int id, int beds, int baths, int floor, String address) {
		super();
		this.id = id;
		this.beds = beds;
		this.baths = baths;
		this.floor = floor;
		this.address = address;
	}
	public Unit(int beds, int baths, int floor, String address) {
		super();
		this.beds = beds;
		this.baths = baths;
		this.floor = floor;
		this.address = address;
	}
	
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBeds() {
		return beds;
	}
	public void setBeds(int beds) {
		this.beds = beds;
	}
	public int getBaths() {
		return baths;
	}
	public void setBaths(int baths) {
		this.baths = baths;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Unit [id=" + id + ", beds=" + beds + ", baths=" + baths + ", floor=" + floor + ", address=" + address
				+ "]";
	}
	
	
	
}
