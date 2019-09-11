package com.xebia.okr.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Objective
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan planId;
    private String title;
    private String label;
    @OneToMany(mappedBy = "objectiveId")
    List<KeyResult> keyResultList;

    public Objective(String title, String label, Plan plan)
    {
        this.title = title;
        this.label = label;
        this.planId= plan;
    }

    public Long getId() {
        return id;
    }

    public Plan getPlanId() {
        return planId;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLabels() {
        return label;
    }

    public void setLabels(String labels) {
        this.label = labels;
    }

    public List<KeyResult> getKeyResultList() {
        return keyResultList;
    }

    public void setKeyResultList(List<KeyResult> keyResultList) {
        this.keyResultList = keyResultList;
    }


}
