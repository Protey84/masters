package com.example.protey.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "job_type")
public class JobType {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String jobName;

    public JobType() {
    }

    public JobType(String jobName) {
        this.jobName = jobName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String name) {
        this.jobName = name;
    }

    @Override
    public String toString() {
        return jobName;
    }
}
