package com.example.demo.student;

//import org.springframework.security.config.web.server.ServerSecurityMarker;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import static com.sun.tools.javac.jvm.ByteCodes.illegal;


@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> getStudents() {
        return this.studentRepository.findAll();
    }

    public void addNewStudent(Student student) throws Exception {
        //System.out.println(student);
        Optional<Student> studentOptional = this.studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("email token");
        }
        this.studentRepository.save(student);
    }

    public void deleteStudent(Long studentId){
        boolean exist = this.studentRepository.existsById(studentId);
        if (!exist){
            throw new IllegalStateException(" Student id " + studentId + " does not exist.");
        }
        this.studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String email, String name){
       // pass
    }
}

