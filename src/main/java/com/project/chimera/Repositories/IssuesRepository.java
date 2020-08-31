package com.project.chimera.Repositories;

import com.project.chimera.Model.Issues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.swing.*;


public interface IssuesRepository extends CrudRepository<Issues,Long> {
}
