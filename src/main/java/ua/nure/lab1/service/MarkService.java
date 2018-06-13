package ua.nure.lab1.service;

import ua.nure.lab1.domain.dto.MarkDto;
import ua.nure.lab1.domain.entity.Alternative;
import ua.nure.lab1.domain.entity.Mark;

import java.util.List;
import java.util.Map;

public interface MarkService {
    Map<String, List<Mark>> getMark();

    Mark createMark(MarkDto mark);

    Mark updateMark(Mark mark);

    void removeMark(int markId);

    Mark getMarkById(int markId);

    List<Mark> getMarkByAlternative(Alternative alternative);
}
