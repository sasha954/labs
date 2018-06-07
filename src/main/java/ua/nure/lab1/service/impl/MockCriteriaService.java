package ua.nure.lab1.service.impl;

import org.springframework.stereotype.Service;
import ua.nure.lab1.domain.entity.Criteria;
import ua.nure.lab1.domain.entity.OptimalityType;
import ua.nure.lab1.domain.entity.ScaleType;
import ua.nure.lab1.domain.entity.Type;
import ua.nure.lab1.service.CriteriaService;

import java.util.Arrays;
import java.util.List;

import static ua.nure.lab1.domain.entity.OptimalityType.MAXIMUM;
import static ua.nure.lab1.domain.entity.ScaleType.INTERVAL;
import static ua.nure.lab1.domain.entity.Type.QUALITY;

@Service
public class MockCriteriaService implements CriteriaService {
    @Override
    public List<Criteria> getAllCriteria() {
        return mockCriteriaList();
    }

    private List<Criteria> mockCriteriaList() {
        return Arrays.asList(
                constructCriteria(1, "Criteria1", 1, 1, QUALITY, MAXIMUM, "Units1", INTERVAL),
                constructCriteria(2, "Criteria2", 2, 2, QUALITY, MAXIMUM, "Units2", INTERVAL),
                constructCriteria(3, "Criteria3", 3, 3, QUALITY, MAXIMUM, "Units3", INTERVAL),
                constructCriteria(4, "Criteria4", 4, 4, QUALITY, MAXIMUM, "Units4", INTERVAL),
                constructCriteria(5, "Criteria5", 5, 5, QUALITY, MAXIMUM, "Units5", INTERVAL),
                constructCriteria(6, "Criteria6", 6, 6, QUALITY, MAXIMUM, "Units6", INTERVAL),
                constructCriteria(7, "Criteria7", 7, 7, QUALITY, MAXIMUM, "Units7", INTERVAL),
                constructCriteria(8, "Criteria8", 8, 8, QUALITY, MAXIMUM, "Units8", INTERVAL)
        );
    }

    private Criteria constructCriteria(int id, String name, int range, int weight, Type type,
                                       OptimalityType optimType, String units, ScaleType scaleType) {
        return new Criteria(id, name, range, weight, type, optimType, units, scaleType);
    }

    @Override
    public Criteria createCriteria(Criteria criteria) {
        return null;
    }

    @Override
    public void removeCriteria(int criteriaId) {

    }

    @Override
    public Criteria updateCriteria(Criteria criteria) {
        return null;
    }

    @Override
    public Criteria getCriteriaById(int criteriaId) {
        return null;
    }
}
