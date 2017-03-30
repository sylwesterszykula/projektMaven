package com.databaseOperations.Interfaces;

import javax.persistence.EntityManager;

public interface Operations {

    void addToDatabase (Object object, EntityManager entityManager);

    void updateDatabase (Object object, EntityManager entityManager);

    void deleteFromDatabase (Object object, EntityManager entityManager);

    Object selectFromDatabase (long id, EntityManager entityManager);
}
