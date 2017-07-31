package com.cdhorn.Interfaces;


import com.cdhorn.Models.Project;

import java.util.List;

public interface ProjectRepository {

    List<Project> findAll();

    void add(String title, String image, String technologies, String description, String completed, String url);

    void delete(long id);


}
