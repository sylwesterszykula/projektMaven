package com.main;

import com.databaseOperations.Implementations.OperationsUsers;
import com.databaseOperations.Interfaces.Operations;
import com.dateConverting.DataConverting;
import com.domain.Adress;
import com.domain.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Operations operations = new OperationsUsers();

        /*Users users = new Users();
        Adress adress = new Adress();
        DataConverting dataConverting = new DataConverting();
        users.setFirstName("Sylwester");
        users.setLastName("Szykula");
        users.setAge(22);
        users.setPassword("sylwek");
        users.setDateOfRegister(dataConverting.convertingFromLocalLocalDate());
        users.setDateOfBirth(dataConverting.convertingFromBrithLocalDate(1994,12,9));
        adress.setLocality("Krasnobrod");
        adress.setStreet("Tomaszowska");
        adress.setStreetNumber("120");
        adress.setZipCode("22-440");
        users.setAdress(adress);
        operations.addToDatabase(users, entityManager);*/


        Users users = new Users();
        users.setId(1);
        users.setFirstName("Jan");
        users = (Users) operations.selectOnIdFromDatabase(users, entityManager);
        System.out.println(users.toString());
        entityManager.close();
        entityManagerFactory.close();
    }

}
