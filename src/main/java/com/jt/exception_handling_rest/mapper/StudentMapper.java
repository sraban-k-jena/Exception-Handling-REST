package com.jt.exception_handling_rest.mapper;

import org.hibernate.annotations.Comment;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.jt.exception_handling_rest.dto.StudentDTO;
import com.jt.exception_handling_rest.model.Student;

@Component
public class StudentMapper {
    public static Student convertToStudent(StudentDTO studentDTO) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO, student);
        return student;
    }

    public static StudentDTO convertToStudentDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        BeanUtils.copyProperties(student, studentDTO);
        return studentDTO;
    }
}
