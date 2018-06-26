package ua.nure.lab1.service;

import ua.nure.lab1.domain.entity.Result;

import java.util.List;

public interface ResultService {
    Result createResult(Result result);
    List<Result> getAllResult();
    void updateResultRange(List<Result> results);
}
