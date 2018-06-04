package ua.nure.lab1.service;

import ua.nure.lab1.domain.entity.Alternative;

import java.util.List;

public interface AlternativeService {
    List<Alternative> getAllAlternative();
    Alternative createNewAlternative(Alternative alternative);
    void deleteAlternative(int alternative);
    Alternative updateAlternative(Alternative alternative);
}
