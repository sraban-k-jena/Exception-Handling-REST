package com.jt.exception_handling_rest.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jt.exception_handling_rest.dto.StudentDTO;
import com.jt.exception_handling_rest.mapper.StudentMapper;
import com.jt.exception_handling_rest.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private com.jt.exception_handling_rest.reposiotry.StudentRepo studentRepo;

    @Override
    public StudentDTO addStudentDTO(StudentDTO studentDTO) {
        Student student = StudentMapper.convertToStudent(studentDTO);
        studentRepo.save(student);
        return StudentMapper.convertToStudentDTO(student);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepo.findAll();
        return students.stream()
                .map(StudentMapper::convertToStudentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudentById(int id) {
        Integer.parseInt("name");
        Student student = studentRepo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        return StudentMapper.convertToStudentDTO(student);
    }

    @Override
    public StudentDTO uodateStudentDTO(int id, StudentDTO studentDTO) {
        Student student = studentRepo.findById(id).get();
        BeanUtils.copyProperties(studentDTO, student, "id");
        studentRepo.save(student);
        return StudentMapper.convertToStudentDTO(student);
    }

    @Override
    public void deleteStudentById(int id) {
        studentRepo.deleteById(id);
    }
}
