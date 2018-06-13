package ua.nure.lab1.dao;

import ua.nure.lab1.domain.dto.AlternativeDto;
import ua.nure.lab1.domain.entity.Alternative;
import ua.nure.lab1.domain.entity.Mark;

import java.util.List;

public interface AlternativeDao {
    Alternative createAlternative(AlternativeDto alternative);

    Alternative updateAlternative(Alternative alternative);

    void removeAlternative(int alternative);

    List<Alternative> getAllAlternatives();

    Alternative getAlternativeById(int id);

    Alternative addMarksToAlternative(Alternative alternative);

}
