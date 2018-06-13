package ua.nure.lab1.dao;

import ua.nure.lab1.domain.entity.Mark;

import java.util.List;

public interface MarkDao {
    List<Mark> getAllMarks();
    Mark createMark(Mark mark);
    void deleteMark(int markId);
    Mark updateMark(Mark mark);
    Mark getMarkById(int markId);

    List<Mark> getMarkByAlternativeId(int id);
}
