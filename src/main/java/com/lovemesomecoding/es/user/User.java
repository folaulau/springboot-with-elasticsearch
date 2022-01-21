package com.lovemesomecoding.es.user;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Mapping doc<br>
 * https://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/#elasticsearch.mapping
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@Document(indexName = "sb_with_es_user", createIndex = true)
public class User implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    private String            id;

    @MultiField(mainField = @Field(type = FieldType.Keyword), otherFields = {@InnerField(suffix = "token", type = FieldType.Text)})
    private String            firstName;

    @MultiField(mainField = @Field(type = FieldType.Keyword), otherFields = {@InnerField(suffix = "token", type = FieldType.Text)})
    private String            lastName;

    @Field(type = FieldType.Keyword)
    private String            middleName;

    @MultiField(mainField = @Field(type = FieldType.Keyword), otherFields = {@InnerField(suffix = "token", type = FieldType.Text)})
    private String            email;

    @Field(type = FieldType.Date, format = DateFormat.date_hour_minute_second_millis)
    @CreatedDate
    private LocalDateTime     createdAt;

    @Field(type = FieldType.Date, format = DateFormat.date_hour_minute_second_millis)
    @LastModifiedDate
    private LocalDateTime     updateAt;
}
