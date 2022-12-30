package com.driver;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository//Telling java This is a repository layer
public class StudentRepository {
    //Database
    private HashMap<String,Student> studentMap;
    private HashMap<String,Teacher> teacherMap;
    private HashMap<String, List<String>> teacherstudentMap;//key is teacher

    public StudentRepository(HashMap<String, Student> studentMap, HashMap<String, Teacher> teacherMap, HashMap<String, List<String>> teacherstudentMap) {
        this.studentMap = studentMap;
        this.teacherMap = teacherMap;
        this.teacherstudentMap = teacherstudentMap;
    }
    public void addstudent(Student student){
        String key=student.getName();
        studentMap.put(key,student);
    }
    public void addteacher(Teacher teacher){
        String key=teacher.getName();
        teacherMap.put(key,teacher);
    }
    public void addStudentteacherPair(String student,String teacher){
        if(studentMap.containsKey(student) && teacherMap.containsKey(teacher)){
            List<String>currentMap=new ArrayList<>();
            if(teacherstudentMap.containsKey(teacher)){
                currentMap=teacherstudentMap.get(teacher);
            }
            currentMap.add(student);
            teacherstudentMap.put(teacher,currentMap);
        }
    }
    //get student by name
    public Student getStudentbyName(String name){
        if(studentMap.containsKey(name)) return studentMap.get(name);
        return null;
    }
    //get teacher by name
    public Teacher getteacherByName(String name){
        if (teacherMap.containsKey(name)) return teacherMap.get(name);
        return null;
    }
    //get student by teacher namr
    public List<String> getStudentsByteacherName(String teacher){
        List<String>datafromDB=new ArrayList<>();
        if (teacherstudentMap.containsKey(teacher)){
            datafromDB=teacherstudentMap.get(teacher);
        }
        return datafromDB;
    }
    //get all students
    public List<String> getAllstudents(){
        List<String>studentlist=new ArrayList<>();
        for(String key : studentMap.keySet()){
            studentlist.add(key);
        }
        return studentlist;
    }
    public void deleteTeacherbyName(String teacher){
        List<String>studentList=new ArrayList<>();
        studentList=teacherstudentMap.get(teacher);
        for(int i=0;i<studentList.size();i++){
            studentMap.remove(studentList.get(i));
        }
        teacherstudentMap.remove(teacher);
        teacherMap.remove(teacher);
    }
    public void deleteAllteachers(){
        teacherMap = teacherMap;
        teacherstudentMap = teacherstudentMap;
      //  studentMap = studentMap;
    }
}
