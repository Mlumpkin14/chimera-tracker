package com.project.chimera.Repositories;

import com.project.chimera.Model.Projects;
import com.project.chimera.Model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface ProjectsRepository extends CrudRepository<Projects, Long> {

    Projects findByProjectName(String projectName);

}
