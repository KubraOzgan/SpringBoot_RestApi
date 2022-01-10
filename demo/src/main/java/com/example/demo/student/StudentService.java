package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

//Initialize this class(Meaning it has to be a spring bean)
@Service //This class is service class. That way in controller it can find StudentService
// @Component would work too
public class StudentService {

    private final StudentRepository studentRepository; //To do db queries!!!

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return  studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()) {
            throw new IllegalStateException("Email taken!");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists) {
            throw new IllegalStateException("Student with id " + studentId + " doesn't exists!");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional //With this, we don't have to implement jqpl query
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("Student with id " + studentId + " doesn't exists!"));
        if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }
        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()) {
                throw new IllegalStateException("Email taken!");
            }
            student.setEmail(email);
        }
    }

    /*public List<Student> getStudents() { //returns json array
        return  List.of(new Student(1L,
                "Mary",
                "mary@gmail.com",
                LocalDate.of(2000, Month.APRIL, 5),
                21));
    }*/
}
