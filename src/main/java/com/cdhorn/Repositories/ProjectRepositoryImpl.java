package com.cdhorn.Repositories;

import com.cdhorn.Interfaces.ProjectRepository;
import com.cdhorn.Models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<Project> findAll() {
        return jdbcTemplate.query("SELECT * FROM project", new ProjectMapper());
    }

    @Override
    public void add(String title, String image, String technologies, String description, String completed, String url) {
        jdbcTemplate.update("INSERT INTO project (title, image, technologies, description, completed, url) VALUES (?, ?, ?, ?, ?, ?)", title, image, technologies, description, completed, url);
    }

    @Override
    public void delete(long id) {
        jdbcTemplate.update("DELETE FROM project WHERE id = ?", id);
    }

    private static class ProjectMapper implements RowMapper<Project> {
        @Override
        public Project mapRow(ResultSet resultSet, int i) throws SQLException {
            Project project = new Project(resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getString("image"),
                    resultSet.getString("technologies"),
                    resultSet.getString("description"),
                    resultSet.getString("completed"),
                    resultSet.getString("url"));
            return project;
        }
    }
}
