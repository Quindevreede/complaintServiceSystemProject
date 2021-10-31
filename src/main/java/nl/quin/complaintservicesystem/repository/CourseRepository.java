package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.model.Course;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Collection<Course> findAllByName(String name);
}