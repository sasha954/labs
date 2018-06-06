package ua.nure.lab1.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.nure.lab1.dao.CriteriaDao;
import ua.nure.lab1.domain.entity.Criteria;

import java.util.List;

@Repository
public class CriteriaDaoImpl implements CriteriaDao {

    @Autowired(required = false)
    private JdbcTemplate jdbcTemplate;

    @Override
    public Criteria createCriteria(Criteria criteria) {
        return null;
    }

    @Override
    public Criteria updateCriteria(Criteria criteria) {
        return null;
    }

    @Override
    public void removeCriteria(int criteriaId) {

    }

    @Override
    public List<Criteria> getAllCriteria() {
        return null;
    }

    @Override
    public Criteria getCriteriaById(int criteriaId) {
        return null;
    }
}
