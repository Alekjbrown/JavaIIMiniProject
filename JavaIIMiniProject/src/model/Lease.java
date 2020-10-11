package model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.CascadeOnDelete;

@Entity
@Table(name="leases")
public class Lease {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@JoinColumn(name="UNIT_ID")
	private Unit unit;
	@JoinColumn(name="TENANT_ID")
	@OneToOne(cascade=CascadeType.ALL)
	private Tenant tenant;
	@Column(name="TERM")
	private int term;
	@Column(name="ENDDATE")
	private LocalDate endDate;
	
	//Constructors
	public Lease() {
		super();
		// Auto-generated constructor stub
	}
	public Lease(int id, Unit unit, Tenant tenant, int term, LocalDate endDate) {
		super();
		this.id = id;
		this.unit = unit;
		this.tenant = tenant;
		this.term = term;
		this.endDate = endDate;
	}
	public Lease(Unit unit, Tenant tenant, int term, LocalDate endDate) {
		super();
		this.unit = unit;
		this.tenant = tenant;
		this.term = term;
		this.endDate = endDate;
	}
	
	//Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Unit getUnit() {
		return unit;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	public Tenant getTenant() {
		return tenant;
	}
	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "Lease [id=" + id + ", unit=" + unit + ", tenant=" + tenant + ", term=" + term + ", endDate=" + endDate
				+ "]";
	}
	
}
