package com.sofkaU.software.demo.router;

import com.sofkaU.software.demo.collections.Category;
import com.sofkaU.software.demo.collections.ToDo;
import com.sofkaU.software.demo.dto.CategoryDTO;
import com.sofkaU.software.demo.mapper.ModeMap;
import com.sofkaU.software.demo.repository.ICategoryRepository;
import com.sofkaU.software.demo.usecases.GetAllCategoriesUseCase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {GetAllCategoriesRoute.class, GetAllCategoriesUseCase.class, ModeMap.class})
class GetAllCategoriesRouteTest {

    @MockBean
    private ICategoryRepository categoryRepo;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testGetAllCategories(){
        Category category = new Category();
        category.setId("1");
        category.setTitle("Home");
        category.setMessage("chores");
        List<ToDo> toDoList = new ArrayList<>();
        toDoList.add(new ToDo("do ironing"));
        toDoList.add(new ToDo("do laundry"));
        toDoList.add(new ToDo("do the bed"));
        toDoList.add(new ToDo("do the dishes"));
        category.setToDos(toDoList);
        Category category1 = new Category();
        category1.setId("2");
        category1.setTitle("University");
        category1.setMessage("Homeworks");
        List<ToDo> toDoList1 = new ArrayList<>();
        toDoList1.add(new ToDo("Java"));
        toDoList1.add(new ToDo("SpringBoot"));
        toDoList1.add(new ToDo("React-Redux"));
        category1.setToDos(toDoList1);

        Mockito.when(categoryRepo.findAll())
                .thenReturn(Flux.just(category, category1));

        webTestClient.get()
                .uri("/get/all/categories")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(CategoryDTO.class)
                .value(userResponse -> {
                    Assertions.assertThat(userResponse.get(0).getId()).isEqualTo(category.getId());
                });


    }



}