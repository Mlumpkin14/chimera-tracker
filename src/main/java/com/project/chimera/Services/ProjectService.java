package com.project.chimera.Services;

import com.project.chimera.Model.Projects;
import com.project.chimera.Services.CrudService;


public interface ProjectService extends CrudService<Projects, Long> {

    public Projects findByProjectName(String projectName);
}
