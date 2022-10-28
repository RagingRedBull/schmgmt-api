package com.example.sam.student.repository;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class SamJpaRepositoryImpl<T, ID extends Serializable>
        extends SimpleJpaRepository<T, ID> implements SamJpaRepository<T, ID> {
    private final EntityManager entityManager;
    private final JpaEntityInformation<T, ?> entityInformation;

    public SamJpaRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
        this.entityInformation = entityInformation;
    }

    @Override
    @Transactional
    public void refresh(T t) {
        entityManager.refresh(t);
    }

    @Transactional
    @Override
    public <S extends T> S save(S entity) {

        Assert.notNull(entity, "Entity must not be null.");

        if (entityInformation.isNew(entity)) {
            entityManager.persist(entity);
            entityManager.refresh(entity);
            return entity;
        } else {
            return entityManager.merge(entity);
        }
    }
}
