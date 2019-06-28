package it.repositories;

import it.model.RatingComment;

import java.util.List;

public interface CommonRepository {
    void newRC(RatingComment ratingComment);

    List getAllRC();
}
