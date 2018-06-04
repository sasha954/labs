package ua.nure.lab1.service.impl;

import org.springframework.stereotype.Service;
import ua.nure.lab1.domain.entity.Criteria;
import ua.nure.lab1.service.CriteriaService;

import java.util.Arrays;
import java.util.List;

@Service
public class MockCriteriaService implements CriteriaService {
    @Override
    public List<Criteria> getAllCriteria() {
        return mockCriteriaList();
    }

    private List<Criteria> mockCriteriaList() {
        return Arrays.asList(
                constructCriteria(1, "Criteria1", 1, 1, "Type1", "OptimType1", "Units1", "ScaleType1"),
                constructCriteria(2, "Criteria2", 2, 2, "Type2", "OptimType2", "Units2", "ScaleType2"),
                constructCriteria(3, "Criteria3", 3, 3, "Type3", "OptimType3", "Units3", "ScaleType3"),
                constructCriteria(4, "Criteria4", 4, 4, "Type4", "OptimType4", "Units4", "ScaleType4"),
                constructCriteria(5, "Criteria5", 5, 5, "Type5", "OptimType5", "Units5", "ScaleType5"),
                constructCriteria(6, "Criteria6", 6, 6, "Type6", "OptimType6", "Units6", "ScaleType6"),
                constructCriteria(7, "Criteria7", 7, 7, "Type7", "OptimType7", "Units7", "ScaleType7"),
                constructCriteria(8, "Criteria8", 8, 8, "Type8", "OptimType8", "Units8", "ScaleType8")
        );
    }

    private Criteria constructCriteria(int id, String name, int range, int weight, String type,
                                       String optimType, String units, String scaleType) {
        return new Criteria(id, name, range, weight, type, optimType, units, scaleType);
    }

    @Override
    public Criteria createCriteria(Criteria criteria) {
        return null;
    }

    @Override
    public void removeCriteria(Criteria criteria) {

    }

    @Override
    public Criteria updateCriteria(Criteria criteria) {
        return null;
    }
}
