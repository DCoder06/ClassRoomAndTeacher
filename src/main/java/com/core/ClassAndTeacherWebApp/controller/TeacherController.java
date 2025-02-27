package com.core.ClassAndTeacherWebApp.controller;

import com.core.ClassAndTeacherWebApp.model.Teacher;
import com.core.ClassAndTeacherWebApp.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/")
    public void createNewTeacher(@RequestBody Teacher teacher) {
        teacherService.addNewTeacher(teacher);
    }

     @GetMapping("/")
    public List<Teacher> getAllTeachers() {
         return teacherService.getAllTeachers();
     }

     @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable int id) {
        return teacherService.getTeacherById(id);
    }

    @PutMapping("/{id}")
    public void deleteTeacherById(@PathVariable int id) {
        teacherService.deleteTeacherById(id);
    }

    @PutMapping("/")
    public void addNewClassForTeacher(@RequestParam(value = "id") int id, @RequestParam(value = "class_id") int class_id) {
        teacherService.addNewClassForTeacher(id,class_id);
    }



}
