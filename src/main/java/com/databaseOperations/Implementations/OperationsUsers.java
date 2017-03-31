package com.databaseOperations.Implementations;

import com.databaseOperations.Interfaces.Operations;
import com.domain.Adress;
import com.domain.Users;

import javax.persistence.EntityManager;

public class OperationsUsers implements Operations {

    public void addToDatabase(Object object, EntityManager entityManager) {
        Users users = (Users) object;
        Adress adress = users.getAdress();
        entityManager.getTransaction().begin();
        entityManager.persist(users);
        entityManager.persist(adress);
        entityManager.getTransaction().commit();
    }

    public void updateOnIdDatabase(Object object, EntityManager entityManager) {
        Users users = (Users)object;
        entityManager.getTransaction().begin();
        Users temp = selectOnIdFromDatabase(object,entityManager);
        //reczne ustawianie ktore pola maja byc aktualizowane (do zrobienia uniwersalna metoda)
        temp.setAge(users.getAge());
        temp.getAdress().setStreet(users.getAdress().getStreet());
        entityManager.getTransaction().commit();
    }

    public void deleteFromDatabase(Object object, EntityManager entityManager) {

    }

    public Users selectOnIdFromDatabase(Object object, EntityManager entityManager) {
        Users users = (Users)object;
        if (!entityManager.isOpen()) {
            entityManager.getTransaction().begin();
        }
        users = entityManager.find(Users.class, users.getId());
        if(!entityManager.isOpen()) {
            entityManager.getTransaction().commit();
        }
        return users;
    }
}
