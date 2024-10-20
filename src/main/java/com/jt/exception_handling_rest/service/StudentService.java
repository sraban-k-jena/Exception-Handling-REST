package com.jt.exception_handling_rest.service;

import java.util.List;
import com.jt.exception_handling_rest.dto.StudentDTO;

public interface StudentService {
    StudentDTO addStudentDTO(StudentDTO studentDTO);

    List<StudentDTO> getAllStudents();

    StudentDTO getStudentById(int id);

    StudentDTO uodateStudentDTO(int id, StudentDTO studentDTO); // Correct method name

    void deleteStudentById(int id);
}
