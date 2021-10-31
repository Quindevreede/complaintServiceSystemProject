package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.model.Course;
import nl.quin.complaintservicesystem.model.StudentCourseResult;
import nl.quin.complaintservicesystem.model.StudentCourseResultKey;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public interface StudentCourseResultService {

    Collection<StudentCourseResult> getAllResults();
    Collection<StudentCourseResult> getResultsByStudentId(long studentId);
    Collection<StudentCourseResult> getResultsByCourseId(long studentId);
    StudentCourseResult getResultById(long studentId, long courseId);

    StudentCourseResultKey addResult(long studentId, long courseId, StudentCourseResult result);
    void updateResult(long studentId, long courseId, StudentCourseResult result);
    void partialUpdateResult(long studentId, long courseId, StudentCourseResult result);
    void deleteResult(long studentId, long courseId);

}