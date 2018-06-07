package ua.nure.lab1.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ua.nure.lab1.dao.MarkDao;
import ua.nure.lab1.domain.dto.MarkDto;
import ua.nure.lab1.domain.entity.Criteria;
import ua.nure.lab1.domain.entity.Mark;
import ua.nure.lab1.service.CriteriaService;
import ua.nure.lab1.service.MarkService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

@Service
@Primary
public class MarkServiceImpl implements MarkService {

    @Autowired
    private MarkDao markDao;

    @Override
    public Map<String, List<Mark>> getMark() {
        return constructMarkMap(markDao.getAllMarks());
    }

    @Override
    public Mark createMark(MarkDto markDto) {
        return markDao.createMark(convertFromDto(markDto));
    }

    private Mark convertFromDto(MarkDto markDto) {
        Mark mark = new Mark();
        mark.setName(markDto.getName());
        mark.setRange(parseInt(markDto.getRange()));
        mark.setNumMark(parseInt(markDto.getNumMark()));
        mark.setNormMark(getNormalization(markDto));
        mark.setCriterion(getCriteriaIdFromMark(markDto));
        return mark;
    }

    private Criteria getCriteriaIdFromMark(MarkDto markDto) {
        Criteria criteria = new Criteria();
        criteria.setId(markDto.getCriteriaId());
        return criteria;
    }

    private int getNormalization(MarkDto mark) {
        return StringUtils.isNotBlank(mark.getNormMark()) ? 1 : 0;
    }

    @Override
    public Mark updateMark(Mark mark) {
        return markDao.updateMark(mark);
    }

    @Override
    public void removeMark(int markId) {
        markDao.deleteMark(markId);
    }

    @Override
    public Mark getMarkById(int markId) {
        return markDao.getMarkById(markId);
    }

    private Map<String, List<Mark>> constructMarkMap(List<Mark> marks) {
        return marks.stream().collect(Collectors.groupingBy(mark -> mark.getCriterion().getName(), LinkedHashMap::new,
                Collectors.toList()));
    }
}
