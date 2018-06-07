package ua.nure.lab1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.lab1.dao.AlternativeDao;
import ua.nure.lab1.domain.entity.Alternative;
import ua.nure.lab1.service.AlternativeService;

import java.util.Arrays;
import java.util.List;

@Service
public class AlternativeServiceImpl implements AlternativeService {

    @Autowired
    private AlternativeDao alternativeDao;

    @Override
    public List<Alternative> getAllAlternative() {
       return alternativeDao.getAllAlternatives();
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
    public Alternative createNewAlternative(Alternative alternative) {
        return alternativeDao.createAlternative(alternative);
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
