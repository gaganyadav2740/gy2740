package com.drm.service;

import com.drm.entity.Student;
import com.drm.payload.StudentDto;
import com.drm.repository.StudentRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
 private StudentRepository studentRepository;
 public StudentService (StudentRepository studentRepository) {
  this.studentRepository = studentRepository;
 }
 public Student addStudent(Student student) {
  Student std = studentRepository.save(student);
  return std;
 }
 public void deleteStudent(Long id) {
  studentRepository.deleteById(id);
 }
 public void updateStudent(Long id, StudentDto dto) {
  Optional<Student> ops = studentRepository.findById(id);
  Student student = ops.get();
  student.setName(dto.getName());
  student.setEmailId(dto.getEmailId());
  student.setMobile(dto.getMobile());
  studentRepository.save(student);

 }

 @GetMapping
 public List<Student> getStudent() {
  return studentRepository.findAll();
 }
}


