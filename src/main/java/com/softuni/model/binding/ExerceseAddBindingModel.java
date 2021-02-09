package com.softuni.model.binding;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class ExerceseAddBindingModel {
    private String name;
    private LocalDateTime startedOn;
    private LocalDateTime dueDate;

    public ExerceseAddBindingModel() {
    }

    @Size(min = 2, message = "Name must be minimum two characters!")
    public String getName() {
        return name;
    }

    public ExerceseAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @PastOrPresent(message = "The date cannot be in future!")
    public LocalDateTime getStartedOn() {
        return startedOn; 
    }

    public ExerceseAddBindingModel setStartedOn(LocalDateTime startedOn) {
        this.startedOn = startedOn;
        return this;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent(message = "the date cannot be in the past!")
    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public ExerceseAddBindingModel setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
        return this;
    }
}
