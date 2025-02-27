package com.core.ClassAndTeacherWebApp.controller;


import com.core.ClassAndTeacherWebApp.DAO.ClassRoomDAO;
import com.core.ClassAndTeacherWebApp.model.ClassRoom;
import com.core.ClassAndTeacherWebApp.services.ClassRoomService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classRoom")
public class ClassRoomController {

    @Autowired
    private ClassRoomService classRoomService;

    @GetMapping("/")
    public List<ClassRoom> getAllClassRooms() {
        return classRoomService.getAllClassRooms();
    }

    @GetMapping("/{id}")
    public ClassRoom getClassRoomById(@PathVariable int id) {
        return classRoomService.getClassRoomById(id);
    }

    @PostMapping("/")
    public void addNewClassRoom(@RequestBody ClassRoom classRoom) {
        classRoomService.createNewClassRoom(classRoom);
    }

    @PutMapping("/")
    public void addNewSubjectToClass(@RequestBody ClassRoom classRoom) {
        classRoomService.addNewSubjectToClassRoom(classRoom);
    }

    @PutMapping("/{id}")
    public void deleteClassRoomById(@PathVariable int id) {
        classRoomService.deleteClassRoomById(id);
    }

}
