package com.patika.thirdhw.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@SuperBuilder

@NoArgsConstructor
@Table(name = "permanents")
public class PermanentInstructor extends Instructor{
    private Number fixedSalary;
}
