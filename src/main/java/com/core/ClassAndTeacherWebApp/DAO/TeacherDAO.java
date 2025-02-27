package com.core.ClassAndTeacherWebApp.DAO;

import com.core.ClassAndTeacherWebApp.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherDAO extends JpaRepository<Teacher, Integer> {
}
