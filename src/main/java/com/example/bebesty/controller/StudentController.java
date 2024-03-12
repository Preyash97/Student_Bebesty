package com.example.bebesty.controller;

import com.example.bebesty.model.Student;
import com.example.bebesty.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public List<Student> getAllStudent(){
        return this.studentService.getAllStudents();
    }

    @PostMapping("/add")
    public String addNewStudent(@RequestBody Student studentData){
        return this.studentService.addStudent(studentData);
    }

    @PutMapping("/update/{studentId}")
    public String updateStudent(@PathVariable Integer studentId,Student newData){
        return this.studentService.updateStudent(studentId,newData);
    }

    @DeleteMapping("/delete/{studentId}")
    public void deleteStudent(@PathVariable Integer studentId){
        this.studentService.deleteStudent(studentId);
    }

    @GetMapping("/student/{studentId}")
    public Student getSingleStudent(@PathVariable Integer studentId){
        return this.studentService.getStudentData(studentId);
    }
}
