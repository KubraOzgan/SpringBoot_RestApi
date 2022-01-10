package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //This interface is responsiblefor data access
public interface StudentRepository extends JpaRepository<Student, Long> { //ObjectType, IdType

    //SELECT * FROM student where email = ?
    @Query("SELECT s FROM Student s where s.email = ?1") //Jpql query, Student is for the class name
    Optional<Student> findStudentByEmail(String email);
}


//JpaRepository has queries!!!