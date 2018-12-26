package ru.itis.Taxi.repositories;

import ru.itis.Taxi.models.RatingComment;

import java.util.List;

public interface CommonRepository {
    void newRC(RatingComment ratingComment);
    List<RatingComment> getAllRC();
}
