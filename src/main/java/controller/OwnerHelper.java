package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Owner;

/**
 * @author christophersaid - csaid
 * CIS175 - Spring 2024
 * Feb 24, 2024
 */
public class OwnerHelper {
	//  constructor
    public OwnerHelper() {

    }

    static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JavaPetOwnerList");

    public void addOwner(Owner toAdd) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(toAdd);
        em.getTransaction().commit();
        em.close();
    }

    public List<Owner> showAllOwners() {
        EntityManager em = emfactory.createEntityManager();
        List<Owner> allOwners = em.createQuery("SELECT o FROM Owner o").getResultList();
        System.out.println(allOwners.size());
        for(Owner owner : allOwners ) {
        	System.out.println(owner.getOwnerId());
        	
        }
        return allOwners;
    }

    public void deleteOwner(Owner toDelete) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Owner> typedQuery = em.createQuery("SELECT o FROM Owner o WHERE o.firstName = :selectedFirst AND o.lastName = :selectedLast", Owner.class);

        typedQuery.setParameter("selectedFirst", toDelete.getFirstName());
        typedQuery.setParameter("selectedLast", toDelete.getLastName());

        typedQuery.setMaxResults(1);

        Owner result = typedQuery.getSingleResult();

        em.remove(result);
        em.getTransaction().commit();
        em.close();
    }

    public Owner searchForOwnerById(int id) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        Owner found = em.find(Owner.class, id);
        em.close();

        return found;
    }

    public void updateOwner(Owner toEdit) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(toEdit);
        em.getTransaction().commit();
        em.close();
    }

    public List<Owner> searchForOwnerByFirstName(String firstName) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Owner> typedQuery = em.createQuery("SELECT o FROM Owner o WHERE o.firstName = :selectedFirst", Owner.class);
        typedQuery.setParameter("selectedFirst", firstName);

        List<Owner> foundOwners = typedQuery.getResultList();
        em.close();

        return foundOwners;
    }

    public List<Owner> searchForOwnerByLastName(String lastName) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Owner> typedQuery = em.createQuery("SELECT o FROM Owner o WHERE o.lastName = :selectedLast", Owner.class);
        typedQuery.setParameter("selectedLast", lastName);

        List<Owner> foundOwners = typedQuery.getResultList();
        em.close();

        return foundOwners;
    }
    
    public List<Owner> searchForOwnerUsername(String username) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Owner> typedQuery = em.createQuery("SELECT o FROM Owner o WHERE o.userName = :selectedUsername", Owner.class);
        typedQuery.setParameter("selectedUsername", username);

        List<Owner> foundOwners = typedQuery.getResultList();
        em.close();

        return foundOwners;
    }

    public void cleanUp() {
        emfactory.close();
    }
}
