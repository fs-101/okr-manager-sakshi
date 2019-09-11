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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ObjectiveRepositoryTests {

    @Autowired
    private PlanRepository planRepository;
    @Autowired
    private ObjectiveRepository objectiveRepository;


    @Test
    public  void should_create_objective_when_valid_data_is_provided()
    {
        Plan createPlan = new Plan("Plan for the quarter", new Date(), new Date());
        Plan savePlan = planRepository.save(createPlan);
        Objective createObjective = new Objective( "Objective for the quarter","Description of Objective",savePlan);
        Objective saveObjective = objectiveRepository.save(createObjective);
        assertThat(saveObjective).isNotNull();
    }
    @Test
    public  void should_read_objective_when_valid_data_is_provided()
    {
        Plan createPlan = new Plan("Plan for the quarter", new Date(), new Date());
        Plan savePlan = planRepository.save(createPlan);
        Objective createObjective = new Objective( "Objective for first quarter","Description of Objective",savePlan);
        Objective saveObjective = objectiveRepository.save(createObjective);
        Objective findObjective = objectiveRepository.findById(saveObjective.getId()).get();
        assertThat(findObjective).isNotNull();
    }
    @Test
    public void should_update_objective_when_valid_data_is_provided()
    {
        Plan createPlan = new Plan("Plan for the quarter", new Date(), new Date());
        Plan savePlan = planRepository.save(createPlan);
        Objective createObjective = new Objective( "Objective for the quarter","Description of Objective",savePlan);
        Objective updateObjective = objectiveRepository.save(createObjective);
        updateObjective.setTitle("Objective for second quarter");
        Objective updatedObjective = objectiveRepository.save(updateObjective);
        Objective findObjective = objectiveRepository.findById(updatedObjective.getId()).get();
        assertThat(findObjective.getTitle()).isEqualTo("Objective for second quarter");

    }
    @Test
    public  void should_delete_objective_when_valid_data_is_provided()
    {
        Plan createPlan = new Plan("Plan for the quarter", new Date(), new Date());
        Plan savePlan = planRepository.save(createPlan);
        Objective createObjective = new Objective( "Objective for the quarter","Description of Objective",savePlan);
        Objective saveObjective = objectiveRepository.save(createObjective);
        objectiveRepository.deleteById(saveObjective.getId());
        assertThat(objectiveRepository.findById(saveObjective.getId()).isPresent()).isFalse();
    }
}