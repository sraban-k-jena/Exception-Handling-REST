package com.jt.exception_handling_rest.reposiotry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jt.exception_handling_rest.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
