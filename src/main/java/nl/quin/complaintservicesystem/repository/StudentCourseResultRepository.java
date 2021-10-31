package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.model.StudentCourseResult;
import nl.quin.complaintservicesystem.model.StudentCourseResultKey;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface StudentCourseResultRepository extends JpaRepository<StudentCourseResult, StudentCourseResultKey> {
    Collection<StudentCourseResult> findAllByStudentId(long studentId);
    Collection<StudentCourseResult> findAllByCourseId(long courseId);
}