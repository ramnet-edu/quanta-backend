package com.quanta.controller;

import com.quanta.model.StudyMaterial;
import com.quanta.service.StudyMaterialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/materials")
public class StudyMaterialController {

    private final StudyMaterialService studyMaterialService;

    public StudyMaterialController(StudyMaterialService studyMaterialService) {
        this.studyMaterialService = studyMaterialService;
    }

    @PostMapping("/add")
    public ResponseEntity<StudyMaterial> add(@RequestBody StudyMaterial material) {
        return ResponseEntity.ok(studyMaterialService.save(material));
    }

    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<List<StudyMaterial>> getByTeacher(@PathVariable Long teacherId) {
        return ResponseEntity.ok(studyMaterialService.getByTeacher(teacherId));
    }
}