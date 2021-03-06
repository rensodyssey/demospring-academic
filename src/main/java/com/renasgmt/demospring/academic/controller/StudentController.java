package com.renasgmt.demospring.academic.controller;

import com.renasgmt.demospring.academic.model.Student;
import com.renasgmt.demospring.academic.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/academic/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity getAllStudent(){
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @GetMapping("/{npm}")
    public ResponseEntity<Student> getStudentByStudentId(@PathVariable String npm){
        return ResponseEntity.ok(studentService.getStudentByStudentId(npm));
    }

    @PostMapping
    public ResponseEntity addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        //return ResponseEntity.status(HttpStatus.CREATED).build();
        return new ResponseEntity<>("Insert student with ID "+ student.getStudentId() +" succeed!", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return new ResponseEntity<>("Update student with ID "+ student.getStudentId() +" succeed!", HttpStatus.OK);
    }

    @DeleteMapping("/{npm}")
    public ResponseEntity deleteStudent(@PathVariable String npm){
        studentService.deleteStudent(npm);
        return new ResponseEntity<>("Delete student with ID "+ npm +" succeed!", HttpStatus.OK);
    }
}
