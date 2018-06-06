package ua.nure.lab1.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.nure.lab1.dao.AlternativeDao;
import ua.nure.lab1.domain.entity.Alternative;

import java.util.List;

@Repository
public class AlternativeDaoImpl implements AlternativeDao {

    @Autowired(required = false)
    private JdbcTemplate jdbcTemplate;

    @Override
    public Alternative createAlternative(Alternative alternative) {
        return null;
    }

    @Override
    public Alternative updateAlternative(Alternative alternative) {
        return null;
    }

    @Override
    public void removeAlternative(int alternative) {

    }

    @Override
    public List<Alternative> getAllAlternatives() {
        return null;
    }

    @Override
    public Alternative getAlternativeById(int id) {
        return null;
    }
}
