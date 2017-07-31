package com.cdhorn.Interfaces;


import com.cdhorn.Models.Project;

import java.util.List;

public interface ProjectRepository {

    List<Project> findAll();
}
