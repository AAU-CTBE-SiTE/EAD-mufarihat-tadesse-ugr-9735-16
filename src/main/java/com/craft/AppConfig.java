
package com.craft;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Arrays;

@Configuration
public class AppConfig {

    @Bean
    public Address address() {
        Address address = new Address();
        address.setCity("Jimma");
        address.setStreet("Kochi");
        return address;
    }

    @Bean
    @Scope("singleton")
    public Subject physics() {
        Subject s = new Subject();
        s.setName("Physics");
        return s;
    }

    @Bean
    @Scope("prototype")
    public Subject maths() {
        Subject s = new Subject();
        s.setName("Maths");
        return s;
    }

    @Bean
    public Student student() {
        Student student = new Student(1, "Ebo", 22, address());

        student.setSubjects(
                Arrays.asList(physics(), maths())
        );

        return student;
    }
}
