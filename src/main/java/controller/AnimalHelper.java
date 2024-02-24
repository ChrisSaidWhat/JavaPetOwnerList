package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Animal;

/**
 * @author christophersaid - csaid
 * CIS175 - Spring 2024
 * Feb 24, 2024
 */
public class AnimalHelper {
	//  constructor
    public AnimalHelper() {

    }

    static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JavaPetOwnerList");

    public void addAnimal(Animal toAdd) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(toAdd);
        em.getTransaction().commit();
        em.close();
    }

    public List<Animal> showAllAnimals() {
        EntityManager em = emfactory.createEntityManager();
        List<Animal> allAnimals = em.createQuery("SELECT a FROM Animal a").getResultList();
        return allAnimals;
    }

    public void deleteAnimal(Animal toDelete) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Animal> typedQuery = em.createQuery("SELECT a FROM Animal a WHERE a.name = :selectedName AND a.type = :selectedType", Animal.class);

        typedQuery.setParameter("selectedName", toDelete.getName());
        typedQuery.setParameter("selectedType", toDelete.getType());

        typedQuery.setMaxResults(1);

        Animal result = typedQuery.getSingleResult();

        em.remove(result);
        em.getTransaction().commit();
        em.close();
    }

    public Animal searchForAnimalById(int id) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        Animal found = em.find(Animal.class, id);
        em.close();

        return found;
    }

    public void updateAnimal(Animal toEdit) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(toEdit);
        em.getTransaction().commit();
        em.close();
    }

    public List<Animal> searchForAnimalByName(String name) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Animal> typedQuery = em.createQuery("SELECT a FROM Animal a WHERE a.name = :selectedName", Animal.class);
        typedQuery.setParameter("selectedName", name);

        List<Animal> foundAnimals = typedQuery.getResultList();
        em.close();

        return foundAnimals;
    }

    public List<Animal> searchForAnimalByType(String type) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Animal> typedQuery = em.createQuery("SELECT a FROM Animal a WHERE a.type = :selectedType", Animal.class);
        typedQuery.setParameter("selectedType", type);

        List<Animal> foundAnimals = typedQuery.getResultList();
        em.close();

        return foundAnimals;
    }

    public void cleanUp() {
        emfactory.close();
    }
}
