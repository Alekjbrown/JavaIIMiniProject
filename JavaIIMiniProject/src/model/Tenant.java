package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tenants")
public class Tenant {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="TENANT_NAME")
	private String tenantName;
	@Column(name="DOB")
	private LocalDate dob;
	@Column(name="PHONE")
	private String phone;
	public Tenant() {
		super();
		//  Auto-generated constructor stub
	}
	public Tenant(int id, String tenantName, LocalDate dob) {
		super();
		this.id = id;
		this.tenantName = tenantName;
		this.dob = dob;
	}
	public Tenant(String tenantName, LocalDate dob) {
		super();
		this.tenantName = tenantName;
		this.dob = dob;
	}
	public Tenant(LocalDate dob) {
		super();
		this.dob = dob;
	}	
	public Tenant(String tenantName, LocalDate dob, String phone) {
		super();
		this.tenantName = tenantName;
		this.dob = dob;
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenantName() {
		return tenantName;
	}
	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Tenant [id=" + id + ", tenantName=" + tenantName + ", dob=" + dob + ", phone=" + phone + "]";
	}
	
}
