package com.core.ClassAndTeacherWebApp.services;

import com.core.ClassAndTeacherWebApp.DAO.ClassRoomDAO;
import com.core.ClassAndTeacherWebApp.model.ClassRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClassRoomService {

    @Autowired
    private ClassRoomDAO classRoomDAO;

    public List<ClassRoom> getAllClassRooms() {
        return classRoomDAO.findAll();
    }

    public ClassRoom getClassRoomById(int classRoomId) {
        return classRoomDAO.findById(classRoomId).orElse(null);
    }

    public void createNewClassRoom(ClassRoom classRoom) {
        classRoomDAO.save(classRoom);
    }

    public void addNewSubjectToClassRoom(ClassRoom classRoom) {
        Optional<ClassRoom> class_Room = classRoomDAO.findById(classRoom.getClassId());
        if(class_Room.isEmpty()) {
            return;
        }
        classRoomDAO.save(classRoom);
    }

    public void deleteClassRoomById(int id) {
        ClassRoom classRoom = classRoomDAO.findById(id).orElse(null);
        if(Objects.isNull(classRoom)) {
            return;
        }
        classRoom.setIsActive(false);

        classRoomDAO.save(classRoom);
    }
}
