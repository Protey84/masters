package com.example.protey.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class FilterTask {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDay;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate finishDay;
    private Master master;

    public FilterTask() {
    }

    public FilterTask(LocalDate startDay, LocalDate finishDay, Master master) {
        this.startDay = startDay;
        this.finishDay = finishDay;
        this.master = master;
    }

    public FilterTask(LocalDate startDay, LocalDate finishDay) {
        this.startDay = startDay;
        this.finishDay = finishDay;
    }

    public LocalDate getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }

    public LocalDate getFinishDay() {
        return finishDay;
    }

    public void setFinishDay(LocalDate finishDay) {
        this.finishDay = finishDay;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }
}
