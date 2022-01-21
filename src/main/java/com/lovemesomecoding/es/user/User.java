package com.lovemesomecoding.es.user;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
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

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@Document(indexName = "user")
public class User implements Serializable {
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

}
