package com.cdhorn.Repositories;

import com.cdhorn.Interfaces.ProjectRepository;
import com.cdhorn.Models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Project> findAll() {
        return null;
    }
}
