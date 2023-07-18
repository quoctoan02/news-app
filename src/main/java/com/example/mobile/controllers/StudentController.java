package com.example.mobile.controllers;

import com.example.mobile.models.Student;
import com.example.mobile.repostories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(ModelMap modelMap){
        return "hello world...";
    }
    @RequestMapping(value = "/insertStudent", method = RequestMethod.POST)
    public String insertStudent(@RequestParam String name, @RequestParam Integer year) {
        try {
            Student student = new Student(name, year );
            studentRepository.save(student);
            return "insert student success";
        } catch(Exception e)   {
            return e.toString();
        }
    }
    @RequestMapping(value = "showAllStudents", method = RequestMethod.GET)
    public Iterable<Student> showAllStudents() {
        return studentRepository.findAll();
    }
}
