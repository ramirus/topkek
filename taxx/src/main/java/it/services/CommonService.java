package it.services;

import it.model.RatingComment;

import java.util.List;

public interface CommonService {
    void newRatingComment(RatingComment ratingComment);

    List getAllRatingCom();
}
