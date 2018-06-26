package ua.nure.lab1.service;

import ua.nure.lab1.domain.dto.ChosenAlternative;
import ua.nure.lab1.domain.entity.Alternative;

import java.util.List;

public interface ChooseService {
    ChosenAlternative nextAlternative();

    boolean hasNext();

    List<Alternative> getWinner();

    void clear();

    boolean changeRow();
}
