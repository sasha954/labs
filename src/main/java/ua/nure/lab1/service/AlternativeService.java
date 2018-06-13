package ua.nure.lab1.service;

import ua.nure.lab1.domain.dto.AlternativeDto;
import ua.nure.lab1.domain.entity.Alternative;

import java.util.List;

public interface AlternativeService {
    Alternative getById(int id);

    List<Alternative> getAllAlternative();

    Alternative createNewAlternative(AlternativeDto alternative);

    void deleteAlternative(int alternative);

    Alternative updateAlternative(Alternative alternative);

    Alternative addMarksToAlternative(AlternativeDto alternativeDto);
}
