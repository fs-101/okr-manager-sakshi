package com.xebia.okr.repo;


import com.xebia.okr.model.KeyResult;
import com.xebia.okr.model.KeyResultStatus;
import com.xebia.okr.model.Objective;
import com.xebia.okr.model.Plan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class KeyResultRepositoryTests {
    @Autowired
    private PlanRepository planRepository;
    @Autowired
    private ObjectiveRepository objectiveRepository;
    @Autowired
    private KeyResultRepository keyResultRepository;

    @Test
    public  void should_create_keyresult_when_valid_data_is_provided()
    {
        Plan createPlan = new Plan("Plan for the quarter", new Date(), new Date());
        Plan savePlan = planRepository.save(createPlan);
        Objective createObjective = new Objective( "Objective for the quarter","Description of Objective",savePlan);
        Objective saveObjective = objectiveRepository.save(createObjective);
        KeyResult createKeyResult= new KeyResult( saveObjective,60,0, KeyResultStatus.NOT_STARTED);
        KeyResult saveKeyResult = keyResultRepository.save(createKeyResult);
        assertThat(saveKeyResult).isNotNull();
    }

    @Test
    public  void should_read_keyresult_when_valid_data_is_provided()
    {
        Plan createPlan = new Plan("Plan for the quarter", new Date(), new Date());
        Plan savePlan = planRepository.save(createPlan);
        Objective createObjective = new Objective( "Objective for the quarter","Description of Objective",savePlan);
        Objective saveObjective = objectiveRepository.save(createObjective);
        KeyResult createKeyResult= new KeyResult( saveObjective,60,0, KeyResultStatus.NOT_STARTED);
        KeyResult saveKeyResult = keyResultRepository.save(createKeyResult);
        KeyResult findKeyResult=keyResultRepository.findById(saveKeyResult.getId()).get();
        assertThat(findKeyResult).isNotNull();
    }
    @Test
    public void should_update_keyresult_when_valid_data_is_provided()
    {
        Plan createPlan = new Plan("Plan for the quarter", new Date(), new Date());
        Plan savePlan = planRepository.save(createPlan);
        Objective createObjective = new Objective( "Objective for the quarter","Description of Objective",savePlan);
        Objective saveObjective = objectiveRepository.save(createObjective);
        KeyResult createKeyResult= new KeyResult( saveObjective,60,0, KeyResultStatus.NOT_STARTED);
        KeyResult updateKeyResult = keyResultRepository.save(createKeyResult);
        updateKeyResult.setPercentage(30);
        updateKeyResult.setStatus(KeyResultStatus.PARTIALLY_COMPLETED);
        KeyResult updatedKeyResult = keyResultRepository.save(updateKeyResult);
        KeyResult findKeyResult = keyResultRepository.findById(updatedKeyResult.getId()).get();
        assertThat(findKeyResult.getPercentage()).isEqualTo(30);
        assertThat(findKeyResult.getStatus()).isEqualTo(KeyResultStatus.PARTIALLY_COMPLETED);
    }

    @Test
    public  void should_delete_objective_when_valid_data_is_provided()
    {
        Plan createPlan = new Plan("Plan for the quarter", new Date(), new Date());
        Plan savePlan = planRepository.save(createPlan);
        Objective createObjective = new Objective( "Objective for the quarter","Description of Objective",savePlan);
        Objective saveObjective = objectiveRepository.save(createObjective);
        KeyResult createKeyResult= new KeyResult( saveObjective,60,0, KeyResultStatus.NOT_STARTED);
        KeyResult saveKeyResult = keyResultRepository.save(createKeyResult);
        keyResultRepository.deleteById(saveKeyResult.getId());
        assertThat(keyResultRepository.findById(saveKeyResult.getId()).isPresent()).isFalse();
    }
}

