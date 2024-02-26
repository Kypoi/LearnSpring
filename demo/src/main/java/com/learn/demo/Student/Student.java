package com.learn.demo.Student;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;

@Setter
@Entity
@NoArgsConstructor @AllArgsConstructor
@Table
public class Student {
  //
  @Id
  @SequenceGenerator(
          name = "student_sequence",
          sequenceName = "student_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "student_sequence"
  )
  @Getter
  private Long id;
  @Getter
  private String name;
  @Getter
  private String email;
  @Getter
  private LocalDate birth;
  @Transient
  private Integer age;
  //
  public Student(String name, String email, LocalDate birth) {
    this.name = name;
    this.email = email;
    this.birth = birth;
  }
  //

  public Integer getAge(){
    //return (this.birth != null) ? Period.between(this.birth,LocalDate.now()).getYears() : 0;
    return Period.between(this.birth,LocalDate.now()).getYears();
  }

  @Override
  public String toString(){
    return "Student{" + "id=" +id + ", name="+name + '\'' + ", birth= "+birth+ ", email=" +email +'\'' + '}';
  }

}
