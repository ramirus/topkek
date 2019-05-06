package it.services;

import it.model.RatingComment;
import it.repositories.CommonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Lazy
public class CommonServiceImpl implements CommonService {
    @Autowired
    @Lazy
    @Qualifier(value = "commonRepositoryImpl")
    private CommonRepository commonRepository;


    @Override
    public void newRatingComment(RatingComment ratingComment) {
        commonRepository.newRC(ratingComment);
    }

    @Override
    public List<RatingComment> getAllRatingCom() {
        return commonRepository.getAllRC();
    }
}


