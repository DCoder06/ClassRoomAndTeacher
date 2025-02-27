package com.core.ClassAndTeacherWebApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Entity
@Data
public class Teacher {

    @Id
    private Integer teacherId;
    private String name;
    private String subject;

    private List<Integer> classIds;
    private Boolean isActive = true;


}
