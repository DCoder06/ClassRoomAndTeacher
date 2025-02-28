package com.core.ClassAndTeacherWebApp.services;

import com.core.ClassAndTeacherWebApp.DAO.TeacherDAO;
import com.core.ClassAndTeacherWebApp.model.ClassRoom;
import com.core.ClassAndTeacherWebApp.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class TeacherService{

    @Autowired
    private TeacherDAO teacherDAO;

    public ResponseEntity<List<Teacher>> getAllTeachers() {
        return new ResponseEntity<>(teacherDAO.findAll(), HttpStatus.OK);
    }


    public ResponseEntity<?> addNewTeacher(Teacher teacher) {
        Optional<Teacher> newTeacher = teacherDAO.findById(teacher.getTeacherId());
        if(newTeacher.isPresent()) {
            return new ResponseEntity<>("Item already exists.", HttpStatus.OK);
        }
        teacherDAO.save(teacher);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    public ResponseEntity<?> getTeacherById(int id) {
        Optional<Teacher> teacher = teacherDAO.findById(id);
        if(teacher.isPresent()) {
            return new ResponseEntity<>(teacher, HttpStatus.OK);
        }
        return new ResponseEntity<>("Teacher with Id: " + id + "do not exists.", HttpStatus.NOT_FOUND);
    }


    public ResponseEntity<?> addNewClassForTeacher(int id, int classId) {

        Teacher teacher = teacherDAO.findById(id).orElse(null);
        if(Objects.isNull(teacher)) {
            return new ResponseEntity<>("Teacher with Id: " + id + "do not exists.", HttpStatus.NOT_FOUND);
        }

        List<Integer> lst_class = teacher.getClassIds();
        lst_class.add(classId);
        teacher.setClassIds(lst_class);
        teacherDAO.save(teacher);

        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    public ResponseEntity<?> deleteTeacherById(int id) {
        Teacher teacher = teacherDAO.findById(id).orElse(null);
        if(Objects.isNull(teacher)) {
            return new ResponseEntity<>("Teacher with Id: " + id + "do not exists.", HttpStatus.NOT_FOUND);
        }
        teacher.setIsActive(false);
        teacherDAO.save(teacher);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}



