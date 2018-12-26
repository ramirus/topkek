package ru.itis.Taxi.services;

import ru.itis.Taxi.models.RatingComment;

import java.util.List;

public interface CommonService {
    void newRatingComment(RatingComment ratingComment);
    List<RatingComment> getAllRatingCom();
}
