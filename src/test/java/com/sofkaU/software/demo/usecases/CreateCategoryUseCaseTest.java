package com.sofkaU.software.demo.usecases;

import com.sofkaU.software.demo.dto.CategoryDTO;
import com.sofkaU.software.demo.dto.ToDoDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CreateCategoryUseCaseTest {

    @MockBean
    private GetAllCategoriesUseCase getAllCat;

    @Test
    @DisplayName("GetAllCategories")
    void testGetAllCategories(){
        CategoryDTO catDtoExpected = new CategoryDTO();
        catDtoExpected.setId("1");
        catDtoExpected.setTitle("Home");
        catDtoExpected.setMessage("chores");
        List<ToDoDto> toDoList = new ArrayList<>();
        toDoList.add(new ToDoDto("do ironing"));
        toDoList.add(new ToDoDto("do laundry"));
        toDoList.add(new ToDoDto("do the bed"));
        toDoList.add(new ToDoDto("do the dishes"));
        catDtoExpected.setToDoDtos(toDoList);
        CategoryDTO catDtoExp = new CategoryDTO();
        catDtoExp.setId("1");
        catDtoExp.setTitle("Work");
        catDtoExp.setMessage("duties");
        List<ToDoDto> toDoList2 = new ArrayList<>();
        toDoList2.add(new ToDoDto("Java project"));
        toDoList2.add(new ToDoDto("SpringBoot project"));
        toDoList2.add(new ToDoDto("React project"));
        toDoList2.add(new ToDoDto("TypeScript project"));

        StepVerifier
                .create(Flux.just(Mockito.when(getAllCat.getAllCategories())
                        .thenReturn(Flux.just(catDtoExpected, catDtoExp))))
                .thenConsumeWhile((x -> true))
                .verifyComplete();
    }



}