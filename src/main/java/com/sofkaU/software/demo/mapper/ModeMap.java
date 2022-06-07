package com.sofkaU.software.demo.mapper;


import com.sofkaU.software.demo.collections.Category;
import com.sofkaU.software.demo.collections.ToDo;
import com.sofkaU.software.demo.dto.CategoryDTO;
import com.sofkaU.software.demo.dto.ToDoDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

@Component
@EnableWebFlux
@RequiredArgsConstructor
public class ModeMap {

    private final ModelMapper mapper = new ModelMapper();


    public CategoryDTO toCategoryDto(Category cat){
        return mapper.map(cat, CategoryDTO.class);
    }

    public Category toCategoryCollection(CategoryDTO catDto){
        return mapper.map(catDto, Category.class);
    }

    public ToDoDto toToDoDto (ToDo todo){
        return mapper.map(todo, ToDoDto.class);
    }

    public ToDo toToDoCollection (ToDoDto toDoDto){
        return mapper.map(toDoDto, ToDo.class);
    }



}
