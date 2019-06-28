package it.repositories;

import it.form.OrderForm;
import it.model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

@Lazy
@Component(value = "orderRepositoryImpl")
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    @Lazy
    @PersistenceContext(unitName = "entityManagerFactory")
    @Qualifier(value = "entityManagerFactory")
    EntityManager em;

    @Autowired
    @Lazy
    public OrderRepositoryImpl(@Qualifier(value = "transactionManager") JpaTransactionManager transactionManager) {
        em = transactionManager.getEntityManagerFactory().createEntityManager();
    }

    @Transactional
    @Override
    public void newOrder(Order order) {
        em.persist(order);
    }
}
