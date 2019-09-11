package com.xebia.okr.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Plan
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    private String title;
    private Date startOn;
    private Date endOn;
    @OneToMany( mappedBy = "planId")
    private List<Objective> objectiveList;

    public Plan(String title, Date startOn, Date endOn) {
        this.title = title;
        this.startOn = startOn;
        this.endOn = endOn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartOn() {
        return startOn;
    }

    public void setStartOn(Date startOn) {
        this.startOn = startOn;
    }

    public Date getEndOn() {
        return endOn;
    }

    public void setEndOn(Date endOn) {
        this.endOn = endOn;
    }

    public List<Objective> getObjectiveList() {
        return objectiveList;
    }

    public void setObjectiveList(List<Objective> objectiveList) {
        this.objectiveList = objectiveList;
    }

    public Long getId() {
        return id;
    }
}
