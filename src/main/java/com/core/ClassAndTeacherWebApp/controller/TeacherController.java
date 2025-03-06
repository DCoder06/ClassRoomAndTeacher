package com.core.ClassAndTeacherWebApp.controller;

import com.core.ClassAndTeacherWebApp.model.Teacher;
import com.core.ClassAndTeacherWebApp.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/")
    public ResponseEntity<?> createNewTeacher(@RequestBody Teacher teacher) {
        return teacherService.addNewTeacher(teacher);
    }

     @GetMapping("/")
    public ResponseEntity<List<Teacher>> getAllTeachers() {
         return teacherService.getAllTeachers();
     }

     @GetMapping("/{id}")
    public ResponseEntity<?> getTeacherById(@PathVariable int id) {
        return teacherService.getTeacherById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> deleteTeacherById(@PathVariable int id) {
        return teacherService.deleteTeacherById(id);
    }

    @PutMapping("/")
    public ResponseEntity<?> addNewClassForTeacher(@RequestParam(value = "id") int id, @RequestParam(value = "class_id") int class_id) {
        return teacherService.addNewClassForTeacher(id,class_id);
    }


}
