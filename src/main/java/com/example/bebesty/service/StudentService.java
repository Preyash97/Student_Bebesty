package com.example.bebesty.service;

import com.example.bebesty.model.Student;
import com.example.bebesty.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return this.studentRepository.findAll();
    }
    public String addStudent(Student newStudent){
//        boolean newStudentEmailExist = studentRepository.findByEmail(newStudent.getEmail());
//        if(newStudentEmailExist){
//            return "please choose a different email id.";
//        }else {
            this.studentRepository.save(newStudent);
            return "Student details are added";
   //     }
    }

    public String updateStudent(Integer studentId,Student updatedStudent){
        Student oldStudentdata = this.studentRepository.findById(studentId).get();

        oldStudentdata.setEmail(updatedStudent.getEmail());
        oldStudentdata.setLocation(updatedStudent.getLocation());
        oldStudentdata.setStudentname(updatedStudent.getStudentname());

        this.studentRepository.save(oldStudentdata);

        return "student data upadated";
    }
    public void deleteStudent(Integer studentId){
        if(this.studentRepository.findById(studentId).isPresent()){
            this.studentRepository.deleteById(studentId);
        }
    }

    public Student getStudentData(Integer studentId){
        Student selectedStudent = null;
        if(this.studentRepository.findById(studentId).isPresent()){
            selectedStudent = this.studentRepository.findById(studentId).get();
        }
        return selectedStudent;
    }
}
