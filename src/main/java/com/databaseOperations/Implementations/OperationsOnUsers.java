package com.databaseOperations.Implementations;

import com.databaseOperations.Interfaces.Operations;
import com.domain.Users;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class OperationsOnUsers implements Operations {
    private Users users;
    @Override
    public void addToDatabase(Object object, EntityManager entityManager) {
        //wywoluje metode w klasie OperationsUsersId poniewaz  dodaje nowego uzytkownika po id.
        users = (Users) object;
        OperationsOnUsersId operationsOnUsersId = new OperationsOnUsersId();
        operationsOnUsersId.addToDatabase(users, entityManager);
    }

    @Override
    //aktualizowanie uzytkownika na podstawie jego adresu email
    public void updateDatabase(Object object, EntityManager entityManager) {

    }

    @Override
    //usuwanie uzytkownika na podstawie jego adresu email
    public void deleteFromDatabase(Object object, EntityManager entityManager) {
        entityManager.getTransaction().begin();
        users = (Users) selectFromDatabase(object, entityManager);
        entityManager.remove(users.getAdress());
        entityManager.remove(users);
        System.out.println("Poprwanie Wyjebalo");
        entityManager.getTransaction().commit();
    }

    @Override
    //wyciaganie uzytkownika na podstawie adresu email
    public Object selectFromDatabase(Object object, EntityManager entityManager) {
        users = (Users) object;
        String query = "SELECT users  FROM Users users WHERE users.adresEmail = :adresEmail";
        TypedQuery<Users> typedQuery = entityManager.createQuery(query, Users.class);
        typedQuery.setParameter("adresEmail", users.getAdresEmail());
        if (!typedQuery.getResultList().isEmpty())
            users = typedQuery.getResultList().get(0);
        else
            users = null;
        return users;
    }
}
