package ua.nure.lab1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.nure.lab1.dao.ResultDao;
import ua.nure.lab1.domain.entity.Result;
import ua.nure.lab1.service.AlternativeService;
import ua.nure.lab1.service.ResultService;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultDao resultDao;
    @Autowired
    private AlternativeService alternativeService;

    @Override
    public Result createResult(Result result) {
        List<Result> results = getAllResult();
        final int[] counter = {1};

        result.setWeight(calculateWeight(result));
        result.setRange(1);
        result = resultDao.createResult(result);
        if(!results.isEmpty()) {
            results.add(result);
            results = results.stream()
                    .sorted(Comparator.comparing(Result::getWeight).reversed())
                    .peek(res -> res.setRange(counter[0]++))
                    .collect(Collectors.toList());
            updateResultRange(results);
        }

        return result;
    }

    private double calculateWeight(Result result) {
        return result.getAlternative().getMark().stream()
                .mapToDouble(mark -> mark.getCriterion().getRange() * mark.getNumMark()).sum();
    }

    @Override
    @Transactional
    public List<Result> getAllResult() {
        List<Result> results = resultDao.getAllResults();
        setAlternative(results);
        return results;
    }

    private void setAlternative(List<Result> results) {
        results.forEach(result -> result.setAlternative(alternativeService
                .getById(result.getAlternative().getId())));
    }


    @Override
    public void updateResultRange(List<Result> results) {
        resultDao.updateResultsRange(results);
    }
}
