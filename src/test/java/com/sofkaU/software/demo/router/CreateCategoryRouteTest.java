/*
package com.sofkaU.software.demo.router;

import com.sofkaU.software.demo.collections.Category;
import com.sofkaU.software.demo.collections.ToDo;
import com.sofkaU.software.demo.dto.CategoryDTO;
import com.sofkaU.software.demo.mapper.ModeMap;
import com.sofkaU.software.demo.repository.ICategoryRepository;
import com.sofkaU.software.demo.usecases.CreateCategoryUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {CreateCategoryRoute.class, CreateCategoryUseCase.class, ModeMap.class})
class CreateCategoryRouteTest {

    @MockBean
    private ICategoryRepository categoryRepo;

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private ModeMap mapper;

    @Test
    Mono<CategoryDTO> TestCreateCategory(){
        Category category = new Category();
        category.setId("3");
        category.setTitle("Work");
        category.setMessage("Copy-paste code");
        List<ToDo> toDoList = new ArrayList<>();
        category.setToDos(toDoList);

        Mockito.when(categoryRepo.save())

    }

}
*/
