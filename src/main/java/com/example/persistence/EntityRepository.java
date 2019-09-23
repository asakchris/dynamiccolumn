package com.example.persistence;

import java.util.List;
import java.util.Map;

public interface EntityRepository {
    List<Map<String, Object>> getAttributes(Integer entityId);
}
