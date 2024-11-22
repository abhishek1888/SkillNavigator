package com.hexaware.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.model.Course;
import com.hexaware.serviceImpl.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
 
    @Autowired
    private CourseService courseService;
 
    @PutMapping("/completion")
    public ResponseEntity<Course> updateCourseCompletion(@RequestParam Long id, @RequestParam boolean isCompleted) {
        Course updatedCourse = courseService.updateCompletionStatus(id, isCompleted);
        return ResponseEntity.ok(updatedCourse);
    }
    
    @PostMapping("/create")
    public ResponseEntity<Course> createCourse(@RequestBody Course course)
    {
    	return ResponseEntity.ok(courseService.createCourse(course));
    }
 
    
    @PostMapping("/assign")
    public ResponseEntity<Course> assignCandidate(@RequestParam long id,@RequestParam long courseId)
    {
    	return ResponseEntity.ok(courseService.assignCandidate(id,courseId));
    }
    
    
    @PostMapping("/score")
    public ResponseEntity<Long> calculateScore(@RequestParam long id,@RequestBody Map<String, String> userAnswers)
    {
    	return ResponseEntity.ok(courseService.calculateScore(id,userAnswers));
    }
    // Other endpoints for CRUD operations
}
