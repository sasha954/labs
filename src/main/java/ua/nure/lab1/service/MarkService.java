package ua.nure.lab1.service;

import ua.nure.lab1.domain.entity.Mark;

import java.util.List;
import java.util.Map;

public interface MarkService {
    Map<String, List<Mark>> getMark();
}
