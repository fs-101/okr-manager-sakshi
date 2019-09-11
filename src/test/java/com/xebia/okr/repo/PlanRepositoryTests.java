package com.xebia.okr.repo;

import com.xebia.okr.model.Objective;
import com.xebia.okr.model.Plan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PlanRepositoryTests {

    @Autowired
    private PlanRepository repository;

    @Test
    public  void should_create_plan_when_valid_data_is_provided()
    {
        Plan createPlan = new Plan("Plan for the quarter", new Date(), new Date());
        Plan savePlan = repository.save(createPlan);
        assertThat(savePlan).isNotNull();
    }
    @Test
    public  void should_read_plan_when_valid_data_is_provided()
    {

        Plan createPlan = new Plan("Plan for the quarter", new Date(), new Date());
        Plan savePlan = repository.save(createPlan);
        Plan findPlan= repository.findById(savePlan.getId()).get();
        assertEquals(findPlan.getId(),savePlan.getId());
        // Plan findPlan=repository.findById(createPlan.getId())
    }
    @Test
    public void should_update_plan_when_valid_data_is_provided()
    {
        Plan createPlan = new Plan("Plan for the first quarter", new Date(), new Date());
        Plan updatePlan = repository.save(createPlan);
        updatePlan.setTitle("Plan for the second quarter");
        repository.save(updatePlan);
        Plan updatedPlan= repository.findById(updatePlan.getId()).get();
        assertThat(updatedPlan.getTitle()).isEqualTo("Plan for the second quarter");
    }
    @Test
    public  void should_delete_plan_when_valid_data_is_provided()
    {
        Plan createPlan = new Plan("Plan for the first quarter", new Date(), new Date());
        Plan savePlan = repository.save(createPlan);
        repository.deleteById(savePlan.getId());
        Boolean findPlan= repository.findById(savePlan.getId()).isPresent();
        assertThat(findPlan).isFalse();
    }

}