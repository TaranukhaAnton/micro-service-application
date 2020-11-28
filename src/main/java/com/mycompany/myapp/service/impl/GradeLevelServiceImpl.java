package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.service.GradeLevelService;
import com.mycompany.myapp.domain.GradeLevel;
import com.mycompany.myapp.repository.GradeLevelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link GradeLevel}.
 */
@Service
@Transactional
public class GradeLevelServiceImpl implements GradeLevelService {

    private final Logger log = LoggerFactory.getLogger(GradeLevelServiceImpl.class);

    private final GradeLevelRepository gradeLevelRepository;

    public GradeLevelServiceImpl(GradeLevelRepository gradeLevelRepository) {
        this.gradeLevelRepository = gradeLevelRepository;
    }

    @Override
    public GradeLevel save(GradeLevel gradeLevel) {
        log.debug("Request to save GradeLevel : {}", gradeLevel);
        return gradeLevelRepository.save(gradeLevel);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<GradeLevel> findAll(Pageable pageable) {
        log.debug("Request to get all GradeLevels");
        return gradeLevelRepository.findAll(pageable);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<GradeLevel> findOne(Long id) {
        log.debug("Request to get GradeLevel : {}", id);
        return gradeLevelRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete GradeLevel : {}", id);
        gradeLevelRepository.deleteById(id);
    }
}
