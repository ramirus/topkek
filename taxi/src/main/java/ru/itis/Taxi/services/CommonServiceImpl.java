package ru.itis.Taxi.services;

import ru.itis.Taxi.models.RatingComment;
import ru.itis.Taxi.repositories.CommonRepository;

import java.util.List;

public class CommonServiceImpl implements CommonService {
    private CommonRepository commonRepository;

    public CommonServiceImpl(CommonRepository commonRepository) {
        this.commonRepository = commonRepository;
    }
    @Override
    public void newRatingComment(RatingComment ratingComment){
        commonRepository.newRC(ratingComment);
    }
    @Override
    public List<RatingComment> getAllRatingCom(){
        return commonRepository.getAllRC();
    }
}
