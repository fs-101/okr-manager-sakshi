package com.xebia.okr.model;

import javax.persistence.*;

@Entity
public class KeyResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "objective_id")
    private Objective objectiveId;
    private int confidenceScore;
    private int percentage;
    private KeyResultStatus status;

    public KeyResult(Objective objectiveId, int confidenceScore, int percentage, KeyResultStatus status) {
        this.objectiveId = objectiveId;
        this.confidenceScore = confidenceScore;
        this.percentage = percentage;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Objective getObjectiveId() {
        return objectiveId;
    }

    public void setObjectiveId(Objective objectiveId) {
        this.objectiveId = objectiveId;
    }

    public int getConfidenceScore() {
        return confidenceScore;
    }

    public void setConfidenceScore(int confidenceScore) {
        this.confidenceScore = confidenceScore;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public KeyResultStatus getStatus() {
        return status;
    }

    public void setStatus(KeyResultStatus status) {
        this.status = status;
    }

}
