package com.sofkaU.software.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class CategoryDTO {

    private String id;

    private String title;

    private String message;

    private List<ToDoDto> toDoDtos;

}
