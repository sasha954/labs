package ua.nure.lab1.service;

import org.springframework.stereotype.Service;
import ua.nure.lab1.domain.entity.Alternative;

import java.util.Arrays;
import java.util.List;

@Service
public class AlternativeServiceImpl implements AlternativeService {

    @Override
    public List<Alternative> getAllAlternative() {
        return Arrays.asList(new Alternative(1, "Alt1"),
                new Alternative(2, "Alt2"),
                new Alternative(3, "Alt3"),
                new Alternative(4, "Alt4"),
                new Alternative(5, "Alt5"),
                new Alternative(6, "Alt6"),
                new Alternative(7, "Alt7"),
                new Alternative(8, "Alt8"));
    }
}
