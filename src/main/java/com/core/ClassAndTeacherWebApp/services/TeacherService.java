package com.core.ClassAndTeacherWebApp.services;

import com.core.ClassAndTeacherWebApp.DAO.TeacherDAO;
import com.core.ClassAndTeacherWebApp.model.ClassRoom;
import com.core.ClassAndTeacherWebApp.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;


@Service
public class TeacherService{

    @Autowired
    private TeacherDAO teacherDAO;

    public List<Teacher> getAllTeachers() {
        return teacherDAO.findAll();
    }


    public void addNewTeacher(Teacher teacher) {
        teacherDAO.save(teacher);
    }

    public Teacher getTeacherById(int id) {
        return teacherDAO.findById(id).orElse(null);
    }


    public void addNewClassForTeacher(int id, int classId) {

        Teacher teacher = teacherDAO.findById(id).orElse(null);
        if(Objects.isNull(teacher)) {
            return;
        }

        List<Integer> lst_class = teacher.getClassIds();
        lst_class.add(classId);
        teacher.setClassIds(lst_class);
        teacherDAO.save(teacher);
    }

    public void deleteTeacherById(int id) {
        Teacher teacher = teacherDAO.findById(id).orElse(null);
        if(Objects.isNull(teacher)) {
            return;
        }
        teacher.setIsActive(false);

        teacherDAO.save(teacher);
    }


}



