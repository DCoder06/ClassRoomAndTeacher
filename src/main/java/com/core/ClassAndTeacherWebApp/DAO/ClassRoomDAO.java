package com.core.ClassAndTeacherWebApp.DAO;

import com.core.ClassAndTeacherWebApp.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRoomDAO extends JpaRepository<ClassRoom, Integer> {
}
