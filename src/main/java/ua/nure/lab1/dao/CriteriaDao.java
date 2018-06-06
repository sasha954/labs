package ua.nure.lab1.dao;

import ua.nure.lab1.domain.entity.Alternative;
import ua.nure.lab1.domain.entity.Criteria;

import java.util.List;

public interface CriteriaDao {
    Criteria createCriteria(Criteria criteria);

    Criteria updateCriteria(Criteria criteria);

    void removeCriteria(int criteriaId);

    List<Criteria> getAllCriteria();

    Criteria getCriteriaById(int criteriaId);
}
