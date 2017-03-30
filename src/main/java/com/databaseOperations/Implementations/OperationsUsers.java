package com.databaseOperations.Implementations;

import com.databaseOperations.Interfaces.Operations;
import com.domain.Users;

import javax.persistence.EntityManager;

public class OperationsUsers implements Operations {

    public void addToDatabase(Object object, EntityManager entityManager) {
        Users users = (Users) object;
        entityManager.getTransaction().begin();
        entityManager.persist(users);
        entityManager.getTransaction().commit();
    }

    public void updateDatabase(Object object, EntityManager entityManager) {

    }

    public void deleteFromDatabase(Object object, EntityManager entityManager) {

    }

    public Users selectFromDatabase(long id, EntityManager entityManager) {
        Users users = new Users();
        users.setId(id);
        users.setPassword("LOL");
        return users;
    }
}
