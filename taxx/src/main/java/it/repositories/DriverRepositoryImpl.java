package it.repositories;

import it.model.Driver;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Optional;

@Lazy
@Component
public class DriverRepositoryImpl implements DriverRepository {

    @Autowired
    @Lazy
    SessionFactory sessionFactory;

    @Autowired
    @Lazy
    EntityManager em;

    @Autowired
    @Lazy
    public DriverRepositoryImpl(@Qualifier(value = "entityManagerFactory") EntityManagerFactory emf) {
        em = emf.createEntityManager();
    }

    @Override
    public Optional<Driver> findOneByEmail(String email) {
        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("from Driver where email=:email");
        query.setParameter("email", email);
        Driver driver= (Driver) query.uniqueResult();
        return Optional.ofNullable(driver);
    }

    @Override
    public int getSumForDay(long id) {
        return 0;
    }

    @Override
    public void save(Driver model) {

    }
}
