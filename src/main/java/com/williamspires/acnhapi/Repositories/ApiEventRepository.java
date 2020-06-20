package com.williamspires.acnhapi.Repositories;

import com.williamspires.acnhapi.Model.ApiEvent;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class ApiEventRepository {

    @PersistenceContext
    private EntityManager entitymanager;

    @Transactional
    public void insertApiEvent(ApiEvent apiEvent) {
        entitymanager.createNativeQuery("INSERT INTO apistats (path) values (?)")
                .setParameter(1, apiEvent.getPath())
                .executeUpdate();
    }

    @Transactional
    public void insertWithEntityManager(ApiEvent apiEvent) {
        this.entitymanager.persist(apiEvent);
    }

}
