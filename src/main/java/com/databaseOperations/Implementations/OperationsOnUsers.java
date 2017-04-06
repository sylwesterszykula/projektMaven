package com.databaseOperations.Implementations;

import com.databaseOperations.Interfaces.Operations;
import com.domain.Adress;
import com.domain.Users;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class OperationsOnUsers implements Operations {
    @Override
    //dodawanie nowego uzytkownika
    public void addToDatabase(Object object, EntityManager entityManager) {
        //wywoluje metode w klasie OperationsUsersId poniewaz  dodaje nowego uzytkownika po id.
        Users user = (Users) object;
        OperationsOnUsersId operationsOnUsersId = new OperationsOnUsersId();
        operationsOnUsersId.addToDatabase(user, entityManager);
    }

    @Override
    //aktualizowanie uzytkownika na podstawie jego adresu email
    public void updateDatabase(Object object, EntityManager entityManager) {
        entityManager.getTransaction().begin();
        Users users = (Users) selectFromDatabase(object, entityManager);
        users = (Users) checkDifferencesWithoutAdressEmail(object, users);
        entityManager.getTransaction().commit();
    }

    @Override
    //usuwanie uzytkownika na podstawie jego adresu email
    public void deleteFromDatabase(Object object, EntityManager entityManager) {
        entityManager.getTransaction().begin();
        Users user = (Users) selectFromDatabase(object, entityManager);
        entityManager.remove(user.getAdress());
        entityManager.remove(user);
        entityManager.getTransaction().commit();
    }

    @Override
    //wyciaganie uzytkownika na podstawie adresu email
    public Object selectFromDatabase(Object object, EntityManager entityManager) {
        Users user = (Users) object;
        String query = "SELECT users  FROM Users users WHERE users.adresEmail = :adresEmail";
        TypedQuery<Users> typedQuery = entityManager.createQuery(query, Users.class);
        typedQuery.setParameter("adresEmail", user.getAdresEmail());
        if (!typedQuery.getResultList().isEmpty())
            user = typedQuery.getResultList().get(0);
        else
            user = null;
        return user;
    }

    public Object checkDifferencesWithoutAdressEmail(Object object, Users oldUser) {
        Users newUser = (Users) object;
        if (newUser.getAge() != null) {
            oldUser.setAge(newUser.getAge());
        }
        if (newUser.getDateOfBirth() != null) {
            oldUser.setDateOfBirth(newUser.getDateOfBirth());
        }
        if (newUser.getFirstName() != null) {
            oldUser.setFirstName(newUser.getFirstName());
        }
        if (newUser.getLastName() != null) {
            oldUser.setLastName(newUser.getLastName());
        }
        if (newUser.getDateOfRegister() != null) {
            oldUser.setDateOfRegister(newUser.getDateOfRegister());
        }
        if (newUser.getPassword() != null) {
            oldUser.setPassword(newUser.getPassword());
        }
        if (newUser.getAdress().getZipCode() != null){
            oldUser.getAdress().setZipCode(newUser.getAdress().getZipCode());
        }
        if (newUser.getAdress().getStreetNumber() != null){
            oldUser.getAdress().setStreetNumber(newUser.getAdress().getStreetNumber());
        }
        if (newUser.getAdress().getStreet() != null){
            oldUser.getAdress().setStreet(newUser.getAdress().getStreet());
        }
        if (newUser.getAdress().getLocality() != null){
            oldUser.getAdress().setLocality(newUser.getAdress().getLocality());
        }
        return oldUser;
    }
}
