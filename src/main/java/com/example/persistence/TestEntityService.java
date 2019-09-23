package com.example.persistence;

import java.util.List;
import java.util.Map;

public interface TestEntityService {
    List<Map<String, Object>> getAttributes(Integer entityId);
}
