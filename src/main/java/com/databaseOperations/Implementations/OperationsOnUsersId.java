package com.databaseOperations.Implementations;

import com.databaseOperations.Interfaces.Operations;
import com.domain.Adress;
import com.domain.Users;

import javax.persistence.EntityManager;

public class OperationsOnUsersId implements Operations{

    public void addToDatabase(Object object, EntityManager entityManager) {
        Users user = (Users) object;
        Adress adres = user.getAdress();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.persist(adres);
        entityManager.getTransaction().commit();
    }

    public void updateDatabase(Object object, EntityManager entityManager) {
        Users user = (Users)object;
        entityManager.getTransaction().begin();
        Users temp = (Users) selectFromDatabase(object, entityManager);
        //reczne ustawianie ktore pola maja byc aktualizowane (do zrobienia uniwersalna metoda)
        temp.setAdresEmail(user.getAdresEmail());
        entityManager.getTransaction().commit();
    }

    public void deleteFromDatabase(Object object, EntityManager entityManager) {
        entityManager.getTransaction().begin();
        Users user = (Users) selectFromDatabase(object, entityManager);
        entityManager.remove(user.getAdress());
        entityManager.remove(user);
        entityManager.getTransaction().commit();
    }

    public Object selectFromDatabase(Object object, EntityManager entityManager) {
        Users user = (Users)object;
        if (!entityManager.isOpen()) {
            entityManager.getTransaction().begin();
        }
        user = entityManager.find(Users.class, user.getId());
        if(!entityManager.isOpen()) {
            entityManager.getTransaction().commit();
        }
        return user;
    }
}
