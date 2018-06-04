package ua.nure.lab1.service;

import ua.nure.lab1.domain.entity.Vector;

import java.util.List;

public interface VectorService {

    List<Vector> getAllVectors();

    Vector createVector(Vector vector);

    Vector updateVector(Vector vector);

    void removeVector(int vectorId);

    Vector getVectorById(int vectorId);
}
