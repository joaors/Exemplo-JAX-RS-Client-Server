package com.meajudaserver.dao;

import com.meajudaserver.model.BaseEntity;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

public abstract class AbstractFacade<T extends BaseEntity> {
   
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    public T find(Serializable id) {
        return getEntityManager().find(entityClass, id);
    }
    
    public AbstractFacade() {}

    protected abstract EntityManager getEntityManager();
        
    public void create(BaseEntity entity) {
        getEntityManager().persist(entity);
    }

    public void edit(BaseEntity entity) {
        getEntityManager().merge(entity);
    }

    public void remove(Integer id) {
        getEntityManager().remove(find(id));
    }
    
    public void persist(BaseEntity entity) {
        getEntityManager().persist(entity);
    }

    public BaseEntity find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
}
