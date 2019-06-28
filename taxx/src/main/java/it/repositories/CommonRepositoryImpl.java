package it.repositories;

import it.model.RatingComment;
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
import java.util.List;
import java.util.Objects;

@Lazy
@Component(value = "commonRepositoryImpl")
public class CommonRepositoryImpl implements CommonRepository {


    @Autowired
    @Lazy
    @Qualifier(value = "entityManagerFactory")
    @PersistenceContext(unitName = "entityManagerFactory")
    EntityManager em;

    @Autowired
    @Lazy
    public CommonRepositoryImpl(@Qualifier(value = "transactionManager") JpaTransactionManager transactionManager) {
        em = transactionManager.getEntityManagerFactory().createEntityManager();
    }

    @Transactional
    @Override
    public void newRC(RatingComment ratingComment) {
        em.persist(ratingComment);
    }

    @Transactional
    @Override
    public List<RatingComment> getAllRC() {
        return em.createQuery("from RatingComment", RatingComment.class).getResultList();
    }
}
