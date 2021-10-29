package com.example.protey.service;

import com.example.protey.entity.Job;
import com.example.protey.entity.Master;
import com.example.protey.entity.Task;
import com.example.protey.repo.TaskRepo;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private TaskRepo repository;

    public TaskService(TaskRepo repository) {
        this.repository = repository;
    }

    public List<Task> getAll(){
        List<Task> tasks=new ArrayList<>();
        repository.findAll().forEach(tasks::add);
        return tasks;
    }

    public Task getTaskById(int taskId){
        return repository.findById(taskId).get();
    }

    public boolean isExists(Task task){
        return repository.existsById(task.getId());
    }

    public Task save(Task task){
        return repository.save(task);
    }

    public void delete(Task task){
        repository.delete(task);
        return;
    }

    public TreeMap<LocalDate, List<Task>> getSchedule(@Nullable LocalDate startingDay, @Nullable LocalDate lastDay, Master master){
        List<Task> tasks;
        if (master==null)
            tasks=getTasksByDateBetween(startingDay, lastDay);
        else
            tasks=repository.findAllByDateBetweenAndMaster(startingDay, lastDay, master);
        Map<LocalDate, List<Task>> map=tasks.stream().collect(Collectors.groupingBy(Task::getDate));
        TreeMap<LocalDate, List<Task>> result=new TreeMap<>();
        while (startingDay.isBefore(lastDay)){
            result.put(startingDay, null);
            startingDay=startingDay.plusDays(1);
        }
        result.putAll(map);
        return result;
    }

    public TreeMap<LocalDate, List<Task>> getSchedule(@Nullable LocalDate startingDay, @Nullable LocalDate lastDay){
        return getSchedule(startingDay, lastDay, null);
    }

    public List<Task> getTasksOnWeek(){
        LocalDate now=LocalDate.now();
        TemporalField field= WeekFields.of(Locale.FRANCE).dayOfWeek();
        return getTasksByDateBetween(now.with(field,1), now.with(field, 7));
    }

    public List<Task> getTasksByDateBetween(LocalDate before, LocalDate after){
        List<Task> tasks=new ArrayList<>();
        repository.findAllByDateBetween(before, after).forEach(tasks::add);
        return tasks;
    }

    public Task addJob(int id, Job job){
        Task task=getTaskById(id);
        task.addJob(job);
        return save(task);
    }


}
