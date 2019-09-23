package com.example.persistence;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EntityRepositoryImpl implements EntityRepository {
    private JdbcTemplate jdbcTemplate;

    public EntityRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Map<String, Object>> getAttributes(Integer entityId) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("get_attributes")
                .withoutProcedureColumnMetaDataAccess()
                .returningResultSet("p_recordset", new GenericResultSetMapper())
                .declareParameters(
                        new SqlParameter("p_entity_id", Types.INTEGER),
                        new SqlOutParameter("p_recordset", Types.REF_CURSOR)
                );
        Map<String, Object> inputParamMap = new HashMap<>();
        inputParamMap.put("p_entity_id", entityId);

        Map<String, Object> results = simpleJdbcCall.execute(inputParamMap);
        System.out.println("results: " + results);
        List<Map<String, Object>> resultsCollection = (List<Map<String, Object>>) results.get("p_recordset");
        System.out.println("resultsCollection: " + resultsCollection);
        return resultsCollection;
    }
}
