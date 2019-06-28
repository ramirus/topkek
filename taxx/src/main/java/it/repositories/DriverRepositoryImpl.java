package it.repositories;

import it.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.Objects;
import java.util.Optional;

@Lazy
@Component(value = "driverRepositoryImpl")
@EnableTransactionManagement
public class DriverRepositoryImpl implements DriverRepository {

    @Autowired
    @Lazy
    @PersistenceContext(unitName = "entityManagerFactory")
    @Qualifier(value = "entityManagerFactory")
    EntityManager em;


    @Autowired
    @Lazy
    public DriverRepositoryImpl(
            @Qualifier(value = "transactionManager") JpaTransactionManager transactionManager) {
        em = transactionManager.getEntityManagerFactory().createEntityManager();
    }

    @Override
    @Transactional
    public Optional<Driver> findOneByEmail(String email) {
        Driver driver = em.createQuery(
                "from Driver d WHERE d.email =:email", Driver.class).
                setParameter("email", email).getSingleResult();
        return Optional.of(driver);
    }

    @Transactional
    @Override
    public int getSumForDay(long id) {
        return em.createQuery("select sum(price) from Order where driver.id=:id ")
                .setParameter("id", id)
                .getFirstResult();
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public void save(Driver model) {
        em.persist(model);
    }
}
