package com.core.ClassAndTeacherWebApp.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class ClassRoom {

    @Id
    private int classId;
    private int standard;
    private char section;
    private int noOfStudents;
    private List<String> subjectsTaught;
    private Boolean isActive = true;

}
