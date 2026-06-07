package com.akash.portfolio.repository;

import com.akash.portfolio.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository  extends JpaRepository<Project,Long> {
}
