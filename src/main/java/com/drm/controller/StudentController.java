package com.drm.controller;

import com.drm.entity.Student;
import com.drm.payload.StudentDto;
import com.drm.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private StudentService studentService;

    public StudentController (StudentService studentService){
        this.studentService = studentService;

    }

    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(
         @RequestBody Student student
    ){
        Student std = studentService.addStudent(student);
        return new ResponseEntity<>(std, HttpStatus.CREATED);
    }
    @DeleteMapping
    public  ResponseEntity<String> deleteStudent(
            @RequestParam long id
    ){
        studentService.deleteStudent(id);
        return new ResponseEntity<>("Student deleted successfully! ",HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<String> updateStudent(
            @RequestParam long id,
            @RequestBody StudentDto Dto
    ){
        studentService.updateStudent(id, Dto);
        return new ResponseEntity<>("Student updated successfully!",HttpStatus.OK);
    }
     @GetMapping
    public  ResponseEntity < List<Student> >getStudents(){
        List<Student> students = studentService.getStudent();
        return new ResponseEntity<>(students,HttpStatus.OK);
     }

}
