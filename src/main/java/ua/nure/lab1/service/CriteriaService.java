package ua.nure.lab1.service;

import ua.nure.lab1.domain.entity.Criteria;

import java.util.List;

public interface CriteriaService {

    List<Criteria> getAllCriteria();

    Criteria createCriteria(Criteria criteria);

    void removeCriteria(int criteriaId);

    Criteria updateCriteria(Criteria criteria);
}
