package ua.nure.lab1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.lab1.domain.dto.ChosenAlternative;
import ua.nure.lab1.domain.entity.Alternative;
import ua.nure.lab1.service.AlternativeService;
import ua.nure.lab1.service.ChooseService;

import javax.annotation.PostConstruct;
import java.util.List;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.toList;

@Service
public class ChooseServiceImpl implements ChooseService {

    @Autowired
    private AlternativeService alternativeService;

    private List<ChosenAlternative> alternatives;
    private int cursor;
    private int lastReturned;
    private int startItemElem;

    @PostConstruct
    private void init() {
        alternatives = alternativeService.getAllAlternative().stream().map(ChosenAlternative::new)
                .collect(toList());
    }

    @Override
    public boolean hasNext() {
        if(cursor == alternatives.size() && startItemElem != alternatives.size()) {
            startItemElem++;
            cursor = startItemElem;
        }
        return cursor != alternatives.size() && startItemElem != alternatives.size();
    }

    @Override
    public ChosenAlternative nextAlternative() {
        int i = cursor;
        ChosenAlternative alternative = alternatives.get(i);
        lastReturned = i + 1;
        cursor = i + 1;
        return alternative;
    }

    @Override
    public List<Alternative> getWinner() {
        long maxHigh = alternatives.stream().max(comparing(ChosenAlternative::getMoreThanQuantity))
                .map(ChosenAlternative::getMoreThanQuantity).orElse(0);
        long maxEquals = alternatives.stream().max(comparing(ChosenAlternative::getEqualsQuantity))
                .map(ChosenAlternative::getEqualsQuantity).orElse(0);

        if(maxHigh > maxEquals) {
            return alternatives.stream().filter(alt -> alt.getMoreThanQuantity() == maxHigh)
                    .map(ChosenAlternative::getAlternative).collect(toList());
        } else {
            return alternatives.stream().filter(alt -> alt.getEqualsQuantity() == maxEquals)
                    .map(ChosenAlternative::getAlternative).collect(toList());
        }
    }

    @Override
    public void clear() {
        startItemElem = 0;
        cursor = 0;
        alternatives = alternativeService.getAllAlternative().stream().map(ChosenAlternative::new)
                .collect(toList());
    }

    @Override
    public boolean changeRow() {
        return lastReturned == alternatives.size();
    }
}
