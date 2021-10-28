package com.example.protey.entity;

import javax.persistence.*;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "job_id")
    private JobType jobType;
    private int quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    private Task task;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Job() {
    }

    public Job(Integer id, JobType jobType, int quantity, Task task) {
        this.id = id;
        this.jobType = jobType;
        this.quantity = quantity;
        this.task = task;
    }

    @Override
    public String toString() {
        return jobType +" "+ quantity;
    }
}
