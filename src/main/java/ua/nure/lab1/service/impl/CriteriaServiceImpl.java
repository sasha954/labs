package ua.nure.lab1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ua.nure.lab1.dao.CriteriaDao;
import ua.nure.lab1.domain.entity.Criteria;
import ua.nure.lab1.service.CriteriaService;

import java.util.List;

@Service
@Primary
public class CriteriaServiceImpl implements CriteriaService {

    @Autowired
    private CriteriaDao criteriaDao;

    @Override
    public List<Criteria> getAllCriteria() {
        return criteriaDao.getAllCriteria();
    }

    @Override
    public Criteria createCriteria(Criteria criteria) {
        return criteriaDao.createCriteria(criteria);
    }

    @Override
    public void removeCriteria(int criteriaId) {
        criteriaDao.removeCriteria(criteriaId);
    }

    @Override
    public Criteria updateCriteria(Criteria criteria) {
        return criteriaDao.updateCriteria(criteria);
    }

    @Override
    public Criteria getCriteriaById(int criteriaId) {
        return criteriaDao.getCriteriaById(criteriaId);
    }
}
