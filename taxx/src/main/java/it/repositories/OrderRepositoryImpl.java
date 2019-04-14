package it.repositories;

import it.form.OrderForm;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Lazy
@Component
public class OrderRepositoryImpl implements OrderRepository {
    @Autowired
    @Lazy
    SessionFactory sessionFactory;

    @Autowired
    @Lazy
    EntityManager em;

    @Autowired
    @Lazy
    public OrderRepositoryImpl(@Qualifier(value = "entityManagerFactory") EntityManagerFactory emf) {
        em = emf.createEntityManager();
    }
    @Override
    public void newOrder(OrderForm orderForm) {
        em.getTransaction().begin();
        em.persist(orderForm);
        em.getTransaction().commit();

    }
}
