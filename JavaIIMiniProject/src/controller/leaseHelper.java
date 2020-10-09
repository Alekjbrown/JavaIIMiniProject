package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Lease;


public class leaseHelper {
		static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JavaIIMiniProject");
		
		public void insertTenant(Lease lease) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.persist(lease);
			em.getTransaction().commit();
			em.close();
		}
		
		public void deleteTenant(Lease toDelete) {
			EntityManager em = emfactory.createEntityManager(); // unit tenant term endDate
			em.getTransaction().begin();
			TypedQuery<Lease> typedQuery = em.createQuery("select li from Lease li where "
					+ "li.unit = :selectedUnit and li.tenant = :selectedTenant", Lease.class);
			
			//Substitute parameter with actual data from the toDelete item
			typedQuery.setParameter("selectedUnit", toDelete.getUnit());
			typedQuery.setParameter("selectedTenant", toDelete.getTenant());
			
			//we only want one result
			typedQuery.setMaxResults(1);
			
			//get the result and save it into a new list item
			Lease result = typedQuery.getSingleResult();
			
			//remove it
			em.remove(result);
			em.getTransaction().commit();
			em.close();
		}
		
		public List<Lease> searchForLeaseByTenant(String tenantName) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Lease> typedQuery = em.createQuery("select li from "
					+ "Lease li where li.tenant_name = ::selectedTenantName", Lease.class);
			typedQuery.setParameter("selectedTenantName", tenantName);
			List<Lease> foundItems = typedQuery.getResultList();
			em.close();
			return foundItems;
		}
		
		public List<Lease> searchForLeaseByUnit(int unit) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Lease> typedQuery = em.createQuery("select li from "
					+ "Lease li where li.unit = ::selectedUnit", Lease.class);
			typedQuery.setParameter("selectedUnit", unit);
			List<Lease> foundItems = typedQuery.getResultList();
			em.close();
			return foundItems;
		}
		
		public Lease searchForTenantById(int idToEdit) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			Lease found = em.find(Lease.class, idToEdit);
			em.close();
			return found;
		}
		
		public void updateLease(Lease toEdit) {
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
		
		public List<Lease> showAllLeases() {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			List<Lease> allLeases = em.createQuery("SELECT i FROM Lease i").getResultList();
			return allLeases;
		}
}
