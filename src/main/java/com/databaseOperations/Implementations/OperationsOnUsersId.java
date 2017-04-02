package com.databaseOperations.Implementations;

import com.databaseOperations.Interfaces.Operations;
import com.domain.Adress;
import com.domain.Users;

import javax.persistence.EntityManager;

public class OperationsOnUsersId implements Operations{
    private Users users;
    private Adress adress;

    public void addToDatabase(Object object, EntityManager entityManager) {
        users = (Users) object;
        adress = users.getAdress();
        entityManager.getTransaction().begin();
        entityManager.persist(users);
        entityManager.persist(adress);
        entityManager.getTransaction().commit();
    }

    public void updateDatabase(Object object, EntityManager entityManager) {
        users = (Users)object;
        entityManager.getTransaction().begin();
        Users temp = (Users) selectFromDatabase(object, entityManager);
        //reczne ustawianie ktore pola maja byc aktualizowane (do zrobienia uniwersalna metoda)
        temp.setAdresEmail(users.getAdresEmail());
        entityManager.getTransaction().commit();
    }

    public void deleteFromDatabase(Object object, EntityManager entityManager) {
        entityManager.getTransaction().begin();
        users = (Users) selectFromDatabase(object, entityManager);
        entityManager.remove(users.getAdress());
        entityManager.remove(users);
        entityManager.getTransaction().commit();
    }

    public Object selectFromDatabase(Object object, EntityManager entityManager) {
        users = (Users)object;
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
