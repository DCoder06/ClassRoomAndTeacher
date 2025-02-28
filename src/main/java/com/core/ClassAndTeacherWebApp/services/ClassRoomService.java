package com.core.ClassAndTeacherWebApp.services;

import com.core.ClassAndTeacherWebApp.DAO.ClassRoomDAO;
import com.core.ClassAndTeacherWebApp.model.ClassRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClassRoomService {

    @Autowired
    private ClassRoomDAO classRoomDAO;

    public ResponseEntity<List<ClassRoom>> getAllClassRooms() {
        return new ResponseEntity<>(classRoomDAO.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> getClassRoomById(int classRoomId) {
        Optional<ClassRoom> classRoom = classRoomDAO.findById(classRoomId);
        if(classRoom.isPresent()) {
            return new ResponseEntity<>(classRoom, HttpStatus.OK);
        }
        return new ResponseEntity<>("No entry for Id: " + classRoomId + " found.", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> createNewClassRoom(ClassRoom classRoom) {
        Optional<ClassRoom> class_Room = classRoomDAO.findById(classRoom.getClassId());
        if(class_Room.isPresent()) {
            return new ResponseEntity<>("Item already exists.", HttpStatus.OK);
        }
        classRoomDAO.save(classRoom);
        return new ResponseEntity<>(classRoom, HttpStatus.CREATED);
    }

    public ResponseEntity<?> addNewSubjectToClassRoom(ClassRoom classRoom) {
        Optional<ClassRoom> class_Room = classRoomDAO.findById(classRoom.getClassId());
        if(class_Room.isPresent()) {
            classRoomDAO.save(classRoom);
            return new ResponseEntity<>(classRoom,HttpStatus.OK);
        }
        return new ResponseEntity<>("No ClassRoom with Id: " + classRoom.getClassId() + " exists.", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> deleteClassRoomById(int id) {
        ClassRoom classRoom = classRoomDAO.findById(id).orElse(null);
        if(Objects.isNull(classRoom)) {
            return new ResponseEntity<>("No ClassRoom with Id: " + id + " exists." ,HttpStatus.NOT_FOUND);
        }
        classRoom.setIsActive(false);
        classRoomDAO.save(classRoom);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
