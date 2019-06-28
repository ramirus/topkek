package it.services;

import it.model.RatingComment;
import it.repositories.CommonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component(value = "commonServiceImpl")
@Lazy
@EnableTransactionManagement
public class CommonServiceImpl implements CommonService {
    @Autowired
    @Lazy
    @Qualifier(value = "commonRepositoryImpl")
    private CommonRepository commonRepository;

    @Transactional
    @Override
    public void newRatingComment(RatingComment ratingComment) {
        commonRepository.newRC(ratingComment);
    }

    @Transactional
    @Override
    public List<RatingComment> getAllRatingCom() {
        return commonRepository.getAllRC();
    }
}


