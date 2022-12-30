package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//Telling java this is aservice layer
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    //add a student
    public void Addstudent(Student student){
        studentRepository.addstudent(student);
    }
    //add a teacher
    public void Addteacher(Teacher teacher){
        studentRepository.addteacher(teacher);
    }
    //add teacher-student pair
    public void addstudentteacherPair(String student,String teacher){
        studentRepository.addStudentteacherPair(student,teacher);
    }
    public Student getstudentbyName(String name){
        return studentRepository.getStudentbyName(name);
    }
    public Teacher getteacherbyName(String name){
        return studentRepository.getteacherByName(name);
    }
    public List<String> getStudentsbyteacherName(String teacher){
        return studentRepository.getStudentsByteacherName(teacher);
    }
    public List<String> getallstudents(){
        return studentRepository.getAllstudents();
    }
    public void deleteteacherbyName(String teacher){
        studentRepository.deleteTeacherbyName(teacher);
    }
    public void deleteallteachers(){
        studentRepository.deleteAllteachers();
    }
}
