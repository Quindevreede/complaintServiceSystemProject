package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.exceptions.UserNotFoundException;
import nl.quin.complaintservicesystem.model.Student;
import nl.quin.complaintservicesystem.repository.CourseRepository;
import nl.quin.complaintservicesystem.repository.StudentCourseResultRepository;
import nl.quin.complaintservicesystem.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Map;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentCourseResultRepository studentCourseResultRepository;

    @Override
    public Collection<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Collection<Student> getStudents(String name) {
        if (name.isEmpty()) {
            return studentRepository.findAll();
        }
        else {
            return studentRepository.findAllByLastName(name);
        }
    }

    @Override
    public Student getStudentById(long id) {
        if (!studentRepository.existsById(id)) { throw new UserNotFoundException(); }
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public long createStudent(Student student) {
        Student storedStudent = studentRepository.save(student);
        return storedStudent.getId();
    }

    @Override
    public void updateStudent(long id, Student student) {
        if (!studentRepository.existsById(id)) { throw new UserNotFoundException(); }
        Student storedStudent = studentRepository.findById(id).orElse(null);
        storedStudent.setFirstName(student.getFirstName());
        storedStudent.setLastName(student.getLastName());
        storedStudent.setStudentNr(student.getStudentNr());
        studentRepository.save(student);
    }

    @Override
    public void partialUpdateStudent(long id, Map<String, String> fields) {
        if (!studentRepository.existsById(id)) { throw new UserNotFoundException(); }
        Student storedStudent = studentRepository.findById(id).orElse(null);
        for (String field : fields.keySet()) {
            switch (field) {
                case "first_name":
                    storedStudent.setFirstName((String) fields.get(field));
                    break;
                case "last_name":
                    storedStudent.setLastName((String) fields.get(field));
                    break;
                case "student_nr":
                    storedStudent.setStudentNr((String) fields.get(field));
                    break;
            }
        }
        studentRepository.save(storedStudent);
    }

    @Override
    public void deleteStudent(long id) {
        if (!studentRepository.existsById(id)) { throw new UserNotFoundException(); }
        studentRepository.deleteById(id);
    }

}