package com.xebia.okr.repo;

import com.xebia.okr.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanRepository  extends JpaRepository<Plan,Long>
{
    public List<Plan> findByTitle(String title);
}
