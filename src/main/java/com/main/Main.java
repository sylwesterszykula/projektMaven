package com.main;

import com.databaseOperations.Implementations.OperationsOnUsersId;
import com.databaseOperations.Implementations.OperationsOnUsers;
import com.databaseOperations.Interfaces.Operations;
import com.dateConverting.DataConverting;
import com.domain.Users;
import com.domain.Adress;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        /*Operations operations = new OperationsOnUsers();
        Users users = new Users();
        Adress adress = new Adress();
        DataConverting dataConverting = new DataConverting();
        users.setFirstName("Sylwester");
        users.setLastName("Szykula");
        users.setAge(22);
        users.setPassword("sylwester");
        users.setAdresEmail("sylwesterszykula@gmail.com");
        users.setDateOfRegister(dataConverting.convertingFromLocalLocalDate());
        users.setDateOfBirth(dataConverting.convertingFromBrithLocalDate(1994,12,9));
        adress.setLocality("Lublin");
        adress.setStreet("Juranda");
        adress.setStreetNumber("5");
        adress.setZipCode("20-100");
        users.setAdress(adress);
        operations.addToDatabase(users, entityManager);*/


        /*Operations operations = new OperationsOnUsersId();
        Users users = new Users();
        users.setId(1);
        users.setFirstName("Jan");
        users = (Users)operations.selectFromDatabase(users, entityManager);
        System.out.println(users.toString());*/

        /*Operations operations = new OperationsOnUsersId();
        Users users = new Users();
        Adress adress = new Adress();
        users.setAdress(adress);
        users.setId(10);
        users.setAdresEmail("andrzejnowak@gmail.com");
        operations.updateDatabase(users, entityManager);
        System.out.println(operations.selectFromDatabase(users, entityManager).toString());*/

        /*Operations operations = new OperationsOnUsersId();
        Users users = new Users();
        users.setId(3);
        operations.deleteOnIdFromDatabase(users, entityManager);*/

        /*Operations operations = new OperationsOnUsers();
        Users users1 = new Users();
        users1.setAdresEmail("sylwesterszykula@gmail.com");
        users1 = (Users)operations.selectFromDatabase(users1, entityManager);
        if (users1 != null){
            System.out.println(users1.toString());
        }
        else  {
            System.out.println("Nie ma takiego uzytkownika");
        }

        Users users2 = new Users();
        users2.setAdresEmail("sylwester1szykula@gmail.com");
        users2 = (Users)operations.selectFromDatabase(users2, entityManager);
        if (users2 != null){
            System.out.println(users2.toString());
        }
        else  {
            System.out.println("Nie ma takiego uzytkownika");
        }*/

        /*Operations operations = new OperationsOnUsers();
        Users users = new Users();
        users.setAdresEmail("sylwesterszykula@gmail.com");
        operations.deleteFromDatabase(users, entityManager);*/

        Operations operations = new OperationsOnUsers();
        Users users = new Users();
        users.setAdress(new Adress());
        users.setAdresEmail("sylwesterszykula@gmail.com");
        users.setFirstName("Sylwester");
        users.getAdress().setStreetNumber("Juranda");
        users.getAdress().setStreetNumber("400");
        operations.updateDatabase(users, entityManager);

        entityManager.close();
        entityManagerFactory.close();
    }

}
