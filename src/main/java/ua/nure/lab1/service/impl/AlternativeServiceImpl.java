package ua.nure.lab1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.nure.lab1.dao.AlternativeDao;
import ua.nure.lab1.dao.MarkDao;
import ua.nure.lab1.domain.dto.AlternativeDto;
import ua.nure.lab1.domain.entity.Alternative;
import ua.nure.lab1.domain.entity.Mark;
import ua.nure.lab1.service.AlternativeService;
import ua.nure.lab1.service.MarkService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AlternativeServiceImpl implements AlternativeService {

    @Autowired
    private AlternativeDao alternativeDao;
    @Autowired
    private MarkService markService;

    @Override
    public List<Alternative> getAllAlternative() {
        List<Alternative> alternatives = alternativeDao.getAllAlternatives();
        setMarksToAlternative(alternatives);
        return alternatives;
    }

    private void setMarksToAlternative(List<Alternative> alternatives) {
        for (Alternative alternative : alternatives) {
            alternative.setMark(markService.getMarkByAlternative(alternative));
        }
    }

    private List<Alternative> getMockList() {
        return Arrays.asList(new Alternative(1, "Alt1"),
                new Alternative(2, "Alt2"),
                new Alternative(3, "Alt3"),
                new Alternative(4, "Alt4"),
                new Alternative(5, "Alt5"),
                new Alternative(6, "Alt6"),
                new Alternative(7, "Alt7"),
                new Alternative(8, "Alt8"));
    }

    @Override
    public Alternative getById(int id) {
        return alternativeDao.getAlternativeById(id);
    }

    @Override
    public Alternative addMarksToAlternative(AlternativeDto alternativeDto) {
        Alternative alternative = convertFromDto(alternativeDto);
        return alternativeDao.addMarksToAlternative(alternative);
    }

    private Alternative convertFromDto(AlternativeDto alternativeDto) {
        Alternative alternative = new Alternative();
        alternative.setName(alternativeDto.getName());
        alternative.setId(alternativeDto.getAlternativeId());
        alternative.setMark(constructMarkList(alternativeDto));
        return alternative;
    }

    @Transactional
    private List<Mark> constructMarkList(AlternativeDto alternativeDto) {
        List<Mark> marks = new ArrayList<>();
        for (String id : alternativeDto.getMarks()) {
            marks.add(markService.getMarkById(Integer.parseInt(id)));
        }
        return marks;
    }

    @Override
    public Alternative createNewAlternative(AlternativeDto alternativeDto) {
        return alternativeDao.createAlternative(alternativeDto);
    }


    @Override
    public void deleteAlternative(int alternativeId) {
        alternativeDao.removeAlternative(alternativeId);
    }

    @Override
    public Alternative updateAlternative(Alternative alternative) {
        return alternativeDao.updateAlternative(alternative);
    }
}
