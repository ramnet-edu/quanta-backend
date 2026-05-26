package com.quanta.service;

import com.quanta.model.Student;
import com.quanta.repository.StudentRepository;
import com.quanta.dto.LoginRequest;
import com.quanta.config.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final JwtUtil jwtUtil;

    public StudentService(StudentRepository studentRepository, JwtUtil jwtUtil) {
        this.studentRepository = studentRepository;
        this.jwtUtil = jwtUtil;
    }

    public Student saveStudent(Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public String loginStudent(LoginRequest request) {
        Optional<Student> student = studentRepository.findByEmail(request.getEmail());
        if (student.isEmpty()) return "Email nahi mila";
        if (!passwordEncoder.matches(request.getPassword(), student.get().getPassword())) return "Password galat hai";
        return jwtUtil.generateToken(request.getEmail());
    }
}