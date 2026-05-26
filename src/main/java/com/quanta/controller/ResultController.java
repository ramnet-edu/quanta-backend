package com.quanta.controller;

import com.quanta.model.Result;
import com.quanta.service.ResultService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/results")
public class ResultController {

    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @PostMapping("/save")
    public ResponseEntity<Result> saveResult(@RequestBody Result result) {
        return ResponseEntity.ok(resultService.saveResult(result));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Result>> getByStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(resultService.getResultsByStudent(studentId));
    }

    @GetMapping("/test/{testId}")
    public ResponseEntity<List<Result>> getByTest(@PathVariable Long testId) {
        return ResponseEntity.ok(resultService.getResultsByTest(testId));
    }
}