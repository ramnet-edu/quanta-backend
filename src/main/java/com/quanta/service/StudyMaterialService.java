package com.quanta.service;

import com.quanta.model.StudyMaterial;
import com.quanta.repository.StudyMaterialRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudyMaterialService {

    private final StudyMaterialRepository studyMaterialRepository;

    public StudyMaterialService(StudyMaterialRepository studyMaterialRepository) {
        this.studyMaterialRepository = studyMaterialRepository;
    }

    public StudyMaterial save(StudyMaterial material) {
        return studyMaterialRepository.save(material);
    }

    public List<StudyMaterial> getByTeacher(Long teacherId) {
        return studyMaterialRepository.findByTeacherId(teacherId);
    }
}