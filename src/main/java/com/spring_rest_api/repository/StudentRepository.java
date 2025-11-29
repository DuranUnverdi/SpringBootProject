package com.spring_rest_api.repository;

import com.spring_rest_api.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT s FROM Student s WHERE LOWER(s.firstName) = LOWER(?1)")
    public Student findByFirstName(String firstName);
}