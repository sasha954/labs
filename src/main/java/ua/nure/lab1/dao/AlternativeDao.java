package ua.nure.lab1.dao;

import ua.nure.lab1.domain.entity.Alternative;

import java.util.List;

public interface AlternativeDao {
    Alternative createAlternative(Alternative alternative);

    Alternative updateAlternative(Alternative alternative);

    void removeAlternative(int alternative);

    List<Alternative> getAllAlternatives();

    Alternative getAlternativeById(int id);
}
