package bean;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import bean.exceptions.NonexistentEntityException;
import bean.exceptions.PreexistingEntityException;

public abstract class AbstractBean<T> {
	
	private Class<T> entityClass;
	private EntityManagerFactory emf;
	protected EntityManager em;
	
	public AbstractBean(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
	
	protected EntityManager getEntityManager() {
		if (em != null) {
			return em;
		}else {
			emf = Persistence.createEntityManagerFactory("VXP_MySQL_PU");
			em = emf.createEntityManager();
			return em;
		}
	}
	
    public void create(T entity, Object id) throws PreexistingEntityException {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (find(id) != null) {
//            	TODO: gọi tên bảng từ annotation để thông báo rõ ràng hơn trên UI
                throw new PreexistingEntityException("Entity " + entityClass.getSimpleName() + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
    }

    public void edit(T entity, Object id) throws NonexistentEntityException {
    	
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            entity = em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                if (find(id) == null) {
                    throw new NonexistentEntityException("The province with id " + entityClass.getSimpleName() + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void remove(T entity, Object id) throws NonexistentEntityException {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            T entityForRemove;
            try {
                entityForRemove = (T) em.getReference(entityClass, id);
//                entityForRemove.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The "+ entityClass.getSimpleName() + " with id " + id + " no longer exists.", enfe);
            }
            em.remove(entityForRemove);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
//        getEntityManager().remove(getEntityManager().merge(entity));
    }
    
    public T find(Object id) {
//    	em = getEntityManager();
//        try {
        	return getEntityManager().find(entityClass, id);
//        } finally {
//            em.close();
//        }
    }

    public List<T> findAll() {
    	em = getEntityManager();
    	try {
    		javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
            cq.select(cq.from(entityClass));
            return getEntityManager().createQuery(cq).getResultList();
		} finally {
			em.close();
		}
        
    }

    public List<T> findRange(int[] range) {
    	em = getEntityManager();
    	try {
    		javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
            cq.select(cq.from(entityClass));
            javax.persistence.Query q = getEntityManager().createQuery(cq);
            q.setMaxResults(range[1] - range[0] + 1);
            q.setFirstResult(range[0]);
            return q.getResultList();
		} finally {
			em.close();
		}
        
    }
    
    public List<T> findListByPropertive(String propertive, Object value){
    	em = getEntityManager();
    	try {
    		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
            Root<T> model = cq.from(entityClass);
            cq.select(model);
            cq.where(cb.equal(model.get(propertive), value));
            TypedQuery<T> q = getEntityManager().createQuery(cq);
            return q.getResultList();
		} finally {
			em.close();
		}
        
    }

    public int count() {
    	em = getEntityManager();
    	try {
    		javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
            javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
            cq.select(getEntityManager().getCriteriaBuilder().count(rt));
            javax.persistence.Query q = getEntityManager().createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
		} finally {
			em.close();
		}
        
    }
    
}
