package com.patika.thirdhw.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

@EqualsAndHashCode(callSuper = true)
@Table(name = "visiting_researchers")

public class VisitingResearches extends Instructor{
    private Number hourlySalary;
}
