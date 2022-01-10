package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Makes this class to serve rest endpoints
@RequestMapping(path = "api/v1/student") //http://localhost:8080/api/v1/student
public class StudentController {

    private final StudentService studentService;

    @Autowired //private final StudentService studentService will be initialize and injected in this constructor
    //That way we used dependency injection instead of this.studentService = new StudentService
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() { //returns json array
        return studentService.getStudents();
    }

    @PostMapping
    public  void registerNewStudent(@RequestBody Student student) { //Takes req body and maps it into Student
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}") //studentId added to path => {{baseUrl}}/api/v1/student/studentId
    public void deleteStudent(@PathVariable("studentId") Long studentId) { //studentId comes from the path
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}") //{{baseUrl}}/api/v1/student/1?name=Mary&email=mary.@gmail.com
    public void updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }

}
