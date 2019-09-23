package com.example.persistence;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class TestEntityServiceImpl implements TestEntityService {
    private EntityRepository repository;

    public TestEntityServiceImpl(EntityRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Map<String, Object>> getAttributes(Integer entityId) {
        return repository.getAttributes(entityId);
    }
}
