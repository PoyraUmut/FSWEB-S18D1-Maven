package com.workintech.sqldmljoins.entity;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SqlResultSetMapping;

@NamedNativeQuery(name = "findStudentNameSurnameCount",
        query = "SELECT o.ad, o.soyad, COUNT(i.kitapno) as count " +
                "FROM ogrenci o " +
                "LEFT JOIN islem i ON o.ogrno = i.ogrno " +
                "GROUP BY o.ad, o.soyad",
        resultSetMapping = "Mapping.StudentNameSurnameCount")
@SqlResultSetMapping(name = "Mapping.StudentNameSurnameCount",
        classes = @ConstructorResult(targetClass = StudentNameSurnameCount.class,
                columns = {
                        @ColumnResult(name = "ad"),
                        @ColumnResult(name = "soyad"),
                        @ColumnResult(name = "count")
                }))
public interface StudentNameSurnameCount {
    String getAd();
    String getSoyad();
    int getCount();
}