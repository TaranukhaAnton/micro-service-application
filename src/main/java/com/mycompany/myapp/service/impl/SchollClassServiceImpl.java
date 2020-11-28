package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.service.SchollClassService;
import com.mycompany.myapp.domain.SchollClass;
import com.mycompany.myapp.repository.SchollClassRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link SchollClass}.
 */
@Service
@Transactional
public class SchollClassServiceImpl implements SchollClassService {

    private final Logger log = LoggerFactory.getLogger(SchollClassServiceImpl.class);

    private final SchollClassRepository schollClassRepository;

    public SchollClassServiceImpl(SchollClassRepository schollClassRepository) {
        this.schollClassRepository = schollClassRepository;
    }

    @Override
    public SchollClass save(SchollClass schollClass) {
        log.debug("Request to save SchollClass : {}", schollClass);
        return schollClassRepository.save(schollClass);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<SchollClass> findAll(Pageable pageable) {
        log.debug("Request to get all SchollClasses");
        return schollClassRepository.findAll(pageable);
    }


    public Page<SchollClass> findAllWithEagerRelationships(Pageable pageable) {
        return schollClassRepository.findAllWithEagerRelationships(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SchollClass> findOne(Long id) {
        log.debug("Request to get SchollClass : {}", id);
        return schollClassRepository.findOneWithEagerRelationships(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete SchollClass : {}", id);
        schollClassRepository.deleteById(id);
    }
}
