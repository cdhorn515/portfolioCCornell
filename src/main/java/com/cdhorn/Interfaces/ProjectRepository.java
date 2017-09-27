package com.cdhorn.Interfaces;


import com.cdhorn.Models.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository  extends CrudRepository<Project, Long> {
    Iterable<Project> findAllByViewableIsTrue();

}
