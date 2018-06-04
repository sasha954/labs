package ua.nure.lab1.service.impl;

import org.springframework.stereotype.Service;
import ua.nure.lab1.domain.entity.Alternative;
import ua.nure.lab1.domain.entity.Criteria;
import ua.nure.lab1.domain.entity.Mark;
import ua.nure.lab1.domain.entity.Vector;
import ua.nure.lab1.service.VectorService;

import java.util.Arrays;
import java.util.List;

import static ua.nure.lab1.domain.entity.OptimalityType.OPTIMALITY_TYPE1;
import static ua.nure.lab1.domain.entity.ScaleType.SCALE_TYPE1;
import static ua.nure.lab1.domain.entity.Type.TYPE1;

@Service
public class MockVectorService implements VectorService {

    @Override
    public List<Vector> getAllVectors() {
        return constructVectors();
    }

    @Override
    public Vector createVector(Vector vector) {
        return null;
    }

    @Override
    public Vector updateVector(Vector vector) {
        return null;
    }

    @Override
    public void removeVector(int vectorId) {

    }

    @Override
    public Vector getVectorById(int vectorId) {
        return null;
    }

    private List<Vector> constructVectors() {
       return Arrays.asList(
          constructVector("Alternative1"),
          constructVector("Alternative2"),
          constructVector("Alternative3"),
          constructVector("Alternative4"),
          constructVector("Alternative5")
        );
    }

    private Vector constructVector(String altName) {
        return new Vector(constructAlternative(altName), constructMarkList());
    }

    private Alternative constructAlternative(String name) {
        return new Alternative(1, name);
    }

    private List<Mark> constructMarkList() {
        return Arrays.asList(
                constructMark(1, "Mark1", 1, 1, 1, constructCriteria("Criteria1")),
                constructMark(4, "Mark4", 4, 4, 4, constructCriteria("Criteria2")),
                constructMark(5, "Mark5", 5, 5, 5, constructCriteria("Criteria3"))
        );
    }

    private Mark constructMark(int id, String name, int range, int numMark, int normMark, Criteria criteria) {
        return new Mark(id, name, range, numMark, normMark, criteria);
    }

    private Criteria constructCriteria(String name) {
        return new Criteria(1, name, 1, 1, TYPE1, OPTIMALITY_TYPE1, "Units", SCALE_TYPE1);
    }
}
