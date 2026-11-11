package com.craft.studentcrud.service;

import com.craft.studentcrud.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;

@Service
public class StudentService {

    private Student[] students = new Student[10];

    private int count = 0;
    private int nextId = 1;

    // READ ALL STUDENTS
    public Student[] getAllStudents() {
        return Arrays.copyOf(students, count);
    }

    // READ STUDENT BY ID
    public Student getStudentById(int id) {

        for (int i = 0; i < count; i++) {

            if (students[i].getId() == id) {
                return students[i];
            }
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Student not found"
        );
    }

    // CREATE STUDENT
    public Student addStudent(Student student) {

        if (count >= students.length) {
            throw new ResponseStatusException(
                    HttpStatus.INSUFFICIENT_STORAGE,
                    "Student array is full"
            );
        }

        student.setId(nextId++);

        students[count] = student;
        count++;

        return student;
    }

    // UPDATE STUDENT
    public Student updateStudent(int id, Student updatedStudent) {

        for (int i = 0; i < count; i++) {

            if (students[i].getId() == id) {

                students[i].setName(updatedStudent.getName());
                students[i].setDepartment(updatedStudent.getDepartment());
                students[i].setAge(updatedStudent.getAge());

                return students[i];
            }
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Student not found"
        );
    }

    // DELETE STUDENT
    public void deleteStudent(int id) {

        for (int i = 0; i < count; i++) {

            if (students[i].getId() == id) {

                // Shift elements to the left
                for (int j = i; j < count - 1; j++) {
                    students[j] = students[j + 1];
                }

                students[count - 1] = null;
                count--;

                return;
            }
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Student not found"
        );
    }
}

