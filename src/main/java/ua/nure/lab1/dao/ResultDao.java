package ua.nure.lab1.dao;

import ua.nure.lab1.domain.entity.Result;

import java.util.List;

public interface ResultDao {
    Result createResult(Result result);

    List<Result> getAllResults();

    void updateResultsRange(List<Result> results);
}
