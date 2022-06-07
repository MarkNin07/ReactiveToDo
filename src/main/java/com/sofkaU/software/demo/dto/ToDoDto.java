package com.sofkaU.software.demo.dto;

import lombok.Data;

public class ToDoDto {

    private String toDo;

    public ToDoDto(String toDo) {
        this.toDo = toDo;
    }

    public String getToDo() {
        return toDo;
    }

    public void setToDo(String toDo) {
        this.toDo = toDo;
    }
}
