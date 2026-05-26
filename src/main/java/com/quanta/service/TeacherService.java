package com.quanta.service;

import com.quanta.model.Teacher;
import com.quanta.repository.TeacherRepository;
import com.quanta.dto.LoginRequest;
import com.quanta.config.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final JwtUtil jwtUtil;

    public TeacherService(TeacherRepository teacherRepository, JwtUtil jwtUtil) {
        this.teacherRepository = teacherRepository;
        this.jwtUtil = jwtUtil;
    }

    public Teacher saveTeacher(Teacher teacher) {
        teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
        return teacherRepository.save(teacher);
    }

    public String loginTeacher(LoginRequest request) {
        Optional<Teacher> teacher = teacherRepository.findByEmail(request.getEmail());
        if (teacher.isEmpty()) return "Email nahi mila";
        if (!passwordEncoder.matches(request.getPassword(), teacher.get().getPassword())) return "Password galat hai";
        return jwtUtil.generateToken(request.getEmail());
    }
}