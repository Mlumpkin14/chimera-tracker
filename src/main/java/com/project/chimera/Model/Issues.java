package com.project.chimera.Model;

import lombok.Data;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Issues {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String issueName;
    private Date createdAt;


    @Enumerated(value = EnumType.STRING)
    private Priority priority;
    private String description;
    @Enumerated(value = EnumType.STRING)
    private Status status;

    private String summary;
    private String problem;
    private String solution;

    @ManyToOne
    private Projects project;


}
