package ua.nure.lab1.service.impl;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import ua.nure.lab1.domain.entity.Criteria;
import ua.nure.lab1.domain.entity.OptimalityType;
import ua.nure.lab1.domain.entity.ScaleType;
import ua.nure.lab1.domain.entity.Type;
import ua.nure.lab1.service.CriteriaService;

import java.util.Arrays;
import java.util.List;

import static ua.nure.lab1.domain.entity.OptimalityType.OPTIMALITY_TYPE1;
import static ua.nure.lab1.domain.entity.ScaleType.*;
import static ua.nure.lab1.domain.entity.Type.TYPE1;

@Service
@Order(1)
public class MockCriteriaService implements CriteriaService {
    @Override
    public List<Criteria> getAllCriteria() {
        return mockCriteriaList();
    }

    private List<Criteria> mockCriteriaList() {
        return Arrays.asList(
                constructCriteria(1, "Criteria1", 1, 1, TYPE1, OPTIMALITY_TYPE1, "Units1", SCALE_TYPE1),
                constructCriteria(2, "Criteria2", 2, 2, TYPE1, OPTIMALITY_TYPE1, "Units2", SCALE_TYPE1),
                constructCriteria(3, "Criteria3", 3, 3, TYPE1, OPTIMALITY_TYPE1, "Units3", SCALE_TYPE1),
                constructCriteria(4, "Criteria4", 4, 4, TYPE1, OPTIMALITY_TYPE1, "Units4", SCALE_TYPE1),
                constructCriteria(5, "Criteria5", 5, 5, TYPE1, OPTIMALITY_TYPE1, "Units5", SCALE_TYPE1),
                constructCriteria(6, "Criteria6", 6, 6, TYPE1, OPTIMALITY_TYPE1, "Units6", SCALE_TYPE1),
                constructCriteria(7, "Criteria7", 7, 7, TYPE1, OPTIMALITY_TYPE1, "Units7", SCALE_TYPE1),
                constructCriteria(8, "Criteria8", 8, 8, TYPE1, OPTIMALITY_TYPE1, "Units8", SCALE_TYPE1)
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
}
