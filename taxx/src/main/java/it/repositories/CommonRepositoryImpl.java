package it.repositories;

import it.model.RatingComment;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Lazy
@Component
public class CommonRepositoryImpl implements CommonRepository {
    @Autowired
    @Lazy
    SessionFactory sessionFactory;

    @Autowired
    @Lazy
    EntityManager em;

    @Autowired
    @Lazy
    public CommonRepositoryImpl(@Qualifier(value = "entityManagerFactory") EntityManagerFactory emf) {
        em = emf.createEntityManager();
    }

    @Override
    public void newRC(RatingComment ratingComment) {
        em.getTransaction().begin();
        em.persist(ratingComment);
        em.getTransaction().commit();
    }

    @Override
    public List<RatingComment> getAllRC() {
        List commentList = sessionFactory.openSession()
                .createQuery("from RatingComment").list();
        return commentList;
    }
}
