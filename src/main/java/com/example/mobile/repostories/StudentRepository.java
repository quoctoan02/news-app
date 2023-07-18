package com.example.mobile.repostories;

import com.example.mobile.models.Student;
import org.springframework.data.repository.CrudRepository;


public interface StudentRepository extends CrudRepository<Student, Integer> {

}
