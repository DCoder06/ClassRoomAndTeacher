package com.core.ClassAndTeacherWebApp.controller;


import com.core.ClassAndTeacherWebApp.DAO.ClassRoomDAO;
import com.core.ClassAndTeacherWebApp.model.ClassRoom;
import com.core.ClassAndTeacherWebApp.services.ClassRoomService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classRoom")
public class ClassRoomController {

    @Autowired
    private ClassRoomService classRoomService;

    @GetMapping("/")
    public ResponseEntity<List<ClassRoom>> getAllClassRooms() {
        return classRoomService.getAllClassRooms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClassRoomById(@PathVariable int id) {
        return classRoomService.getClassRoomById(id);
    }

    @PostMapping("/")
    public ResponseEntity<?> addNewClassRoom(@RequestBody ClassRoom classRoom) {
        return classRoomService.createNewClassRoom(classRoom);
    }

    @PutMapping("/")
    public ResponseEntity<?> addNewSubjectToClass(@RequestBody ClassRoom classRoom) {
        return classRoomService.addNewSubjectToClassRoom(classRoom);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> deleteClassRoomById(@PathVariable int id) {
        return classRoomService.deleteClassRoomById(id);
    }

}
