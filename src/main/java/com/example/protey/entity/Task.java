package com.example.protey.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "master_id")
    private Master master;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    private String adress;
    private String phone;
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Job> jobs=new ArrayList<>();
    @DateTimeFormat(pattern="yyyy-MM-dd")
    LocalDate date;
    private int orderNum;

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Task() {
    }

    public Task(Master master, User user, String adress, String phone, List<Job> jobs, LocalDate date, int orderNum) {
        this.master = master;
        this.user = user;
        this.adress = adress;
        this.phone = phone;
        this.jobs = jobs;
        this.date = date;
        this.orderNum = orderNum;
    }

    public void addJob(Job job){
        jobs.add(job);
        job.setTask(this);
    }

    public void removeJob(Job job){
        jobs.remove(job);
        job.setTask(null);
    }
}
