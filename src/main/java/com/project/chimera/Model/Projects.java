package com.project.chimera.Model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Entity
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String projectName;

    private Date createdAt;

    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    @ToString.Exclude
    private List<Issues> issues = new ArrayList<>();


    public Projects addIssue(Issues issues){
        issues.setProject(this);
        this.issues.add(issues);
        return this;
    }




}
