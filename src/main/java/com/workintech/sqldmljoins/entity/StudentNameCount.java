package com.workintech.sqldmljoins.entity;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SqlResultSetMapping;

@NamedNativeQuery(name = "findStudentNameCount",
        query = "SELECT ad, COUNT(*) as count FROM ogrenci GROUP BY ad",
        resultSetMapping = "Mapping.StudentNameCount")
@SqlResultSetMapping(name = "Mapping.StudentNameCount",
        classes = @ConstructorResult(targetClass = StudentNameCount.class,
                columns = {
                        @ColumnResult(name = "ad"),
                        @ColumnResult(name = "count")
                }))
public interface StudentNameCount {
    String getAd();
    int getCount();
}