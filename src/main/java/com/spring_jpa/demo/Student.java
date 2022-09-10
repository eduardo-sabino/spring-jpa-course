package com.spring_jpa.demo;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "Student")
@Table(
    name = "student",
    uniqueConstraints = {
        @UniqueConstraint(name = "student_email_unique", columnNames = "email")
    }
)
public class Student {
    @Id
    @Column(
        name = "id",
        unique = true,
        nullable = false,
        insertable = true,
        updatable = false
    )
    private String id;
    
    private Name name;

    @Column(
        name = "email",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String email;

    @Column(
        name = "age",
        nullable = false
    )
    private int age;

    public Student() {
    }

    public Student(Name name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "Student [age=" + age + ", email=" + email + ", id=" + id + ", name=" + name.getFullName() + "]";
    }

    
}
@Embeddable
class Name {
    @Column(
        name = "first_name",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String firstName;

    @Column(
        name = "last_name",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String lastName;
    
    public Name() {}

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
}