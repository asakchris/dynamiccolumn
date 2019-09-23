CREATE TABLE test_entity (entity_id NUMBER (10));

CREATE OR REPLACE PROCEDURE get_attributes (
   p_entity_id   IN     test_entity.entity_id%TYPE,
   p_recordset      OUT SYS_REFCURSOR)
AS
BEGIN
   OPEN p_recordset FOR
      SELECT 1 entity_id, 'Foo' entity_name, SYSDATE now FROM DUAL
      UNION ALL
      SELECT 2, 'Bar', SYSDATE FROM DUAL;
END;
/