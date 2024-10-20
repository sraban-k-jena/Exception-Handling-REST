package com.jt.exception_handling_rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jt.exception_handling_rest.service.StudentService;

import com.jt.exception_handling_rest.dto.StudentDTO;
import com.jt.exception_handling_rest.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin
@RequestMapping("/student")
@Tag(name = "StudentController", description = "Manage Students")
public class StudentController {

    @Autowired
    public StudentService service;

    @GetMapping("/all")
    @Operation(summary = "Get ALL Students ", description = "Get All Students .")
    @ApiResponse(responseCode = "200", description = "Get All Students .")
    @ApiResponse(responseCode = "500", description = "Internal Server error .")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        List<StudentDTO> studentDTOs = service.getAllStudents();
        return new ResponseEntity<>(studentDTOs, HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    @Operation(summary = "Get ALL Students ", description = "Get All Students .")
    @ApiResponse(responseCode = "200", description = "Get All Students .")
    @ApiResponse(responseCode = "500", description = "Internal Server error .")
    public ResponseEntity<StudentDTO> getStudentsById(@PathVariable int id) {
        StudentDTO studentDTO = service.getStudentById(id);
        return new ResponseEntity<>(studentDTO, HttpStatus.OK);
    }

    @PostMapping("/add")
    @Operation(summary = "Get ALL Students ", description = "Get All Students .")
    @ApiResponse(responseCode = "200", description = "Get All Students .")
    @ApiResponse(responseCode = "500", description = "Internal Server error .")
    public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO studentDTO) {
        StudentDTO studentDTOs = service.addStudentDTO(studentDTO);
        return new ResponseEntity<>(studentDTOs, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Get ALL Students ", description = "Get All Students .")
    @ApiResponse(responseCode = "200", description = "Get All Students .")
    @ApiResponse(responseCode = "500", description = "Internal Server error .")
    public ResponseEntity<StudentDTO> updateStudents(@PathVariable int id, @RequestBody StudentDTO studentDTO) {
        StudentDTO studentDTOs = service.uodateStudentDTO(id, studentDTO);
        return new ResponseEntity<>(studentDTOs, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Get ALL Students ", description = "Get All Students .")
    @ApiResponse(responseCode = "200", description = "Get All Students .")
    @ApiResponse(responseCode = "500", description = "Internal Server error .")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
        service.deleteStudentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
