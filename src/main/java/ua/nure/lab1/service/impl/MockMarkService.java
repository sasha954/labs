package ua.nure.lab1.service.impl;

import org.springframework.stereotype.Service;
import ua.nure.lab1.domain.entity.*;
import ua.nure.lab1.service.MarkService;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static ua.nure.lab1.domain.entity.OptimalityType.OPTIMALITY_TYPE1;
import static ua.nure.lab1.domain.entity.ScaleType.SCALE_TYPE1;
import static ua.nure.lab1.domain.entity.Type.TYPE1;

@Service
public class MockMarkService implements MarkService {
    @Override
    public Map<String, List<Mark>> getMark() {
        return constructMap();
    }

    private Map<String, List<Mark>> constructMap() {
      return constructMarkList().stream().collect(groupingBy(mark ->
              mark.getCriterion().getName(), LinkedHashMap::new, toList()));
    }

    private List<Mark> constructMarkList() {
        return Arrays.asList(
                constructMark(1, "Mark1", 1, 4, 3, constructCriteria("Criteria1")),
                constructMark(2, "Mark2", 1, 4, 3, constructCriteria("Criteria1")),
                constructMark(3, "Mark3", 1, 4, 3, constructCriteria("Criteria1")),
                constructMark(4, "Mark4", 1, 4, 3, constructCriteria("Criteria2")),
                constructMark(5, "Mark5", 1, 4, 3, constructCriteria("Criteria3")),
                constructMark(6, "Mark6", 1, 4, 3, constructCriteria("Criteria2")),
                constructMark(7, "Mark7", 1, 4, 3, constructCriteria("Criteria2")),
                constructMark(8, "Mark8", 1, 4, 3, constructCriteria("Criteria3")),
                constructMark(9, "Mark9", 1, 4, 3, constructCriteria("Criteria1")),
                constructMark(10, "Mark10", 1, 4, 3, constructCriteria("Criteria1"))
        );
    }

    private Mark constructMark(int id, String name, int range, int numMark, int normMark, Criteria criteria) {
        return new Mark(id, name, range, numMark, normMark, criteria);
    }

    private Criteria constructCriteria(String name) {
        return new Criteria(1, name, 1, 1, TYPE1, OPTIMALITY_TYPE1, "Units", SCALE_TYPE1);
    }
}