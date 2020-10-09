package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Tenant;

public class tenantHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JavaIIMiniProject");
	
	public void insertTenant(Tenant tenant) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(tenant);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteTenant(Tenant toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Tenant> typedQuery = em.createQuery("select li from Tenant li where "
				+ "li.tenant_name = :selectedTenantName and li.phone = :selectedPhone", Tenant.class);
		
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedTenantName", toDelete.getTenantName());
		typedQuery.setParameter("selectedPhone", toDelete.getPhone());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list item
		Tenant result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Tenant> searchForTenantByName(String tenantName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Tenant> typedQuery = em.createQuery("select li from "
				+ "Tenant li where li.tenant_name = ::selectedTenantName", Tenant.class);
		typedQuery.setParameter("selectedTenantName", tenantName);
		List<Tenant> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public List<Tenant> searchForTenantByPhone(String phone) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Tenant> typedQuery = em.createQuery("select li from "
				+ "Tenant li where li.phone = ::selectedPhone", Tenant.class);
		typedQuery.setParameter("selectedPhone", phone);
		List<Tenant> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public Tenant searchForTenantById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Tenant found = em.find(Tenant.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateTenant(Tenant toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void cleanUp() {
		// TODO Auto-generated method stub
		emfactory.close();
		
	}
	
	public List<Tenant> showAllBeans() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		List<Tenant> allTenants = em.createQuery("SELECT i FROM Tenant i").getResultList();
		return allTenants;
	}
	
}
