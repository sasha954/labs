package ua.nure.lab1.dao;

import ua.nure.lab1.domain.entity.Vector;

import java.util.List;

public interface VectorDao {
    List<Vector> getAllVectors();
    Vector createVector(Vector vector);
    void deleteVector(int vectorId);
    Vector updateVector(Vector vector);
    Vector getVectorById(int vectorId);
}
