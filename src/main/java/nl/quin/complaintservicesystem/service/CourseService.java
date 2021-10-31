package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.model.Course;
import nl.quin.complaintservicesystem.model.StudentCourseResult;

import java.util.Collection;
import java.util.Map;

public interface CourseService {

    Collection<Course> getAllCourses();
    Collection<Course> getCourses(String name);
    Course getCourseById(long id);
    long createCourse(Course course);
    void updateCourse(long id, Course course);
    void partialUpdateCourse(long id, Map<String, String> fields);
    void deleteCourse(long id);

}