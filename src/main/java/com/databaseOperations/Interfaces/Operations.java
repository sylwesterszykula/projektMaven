package com.databaseOperations.Interfaces;

import javax.persistence.EntityManager;

public interface Operations {

    void addToDatabase (Object object, EntityManager entityManager);

    void updateOnIdDatabase (Object object, EntityManager entityManager);

    void deleteOnIdFromDatabase (Object object, EntityManager entityManager);

    Object selectOnIdFromDatabase (Object object, EntityManager entityManager);
}
