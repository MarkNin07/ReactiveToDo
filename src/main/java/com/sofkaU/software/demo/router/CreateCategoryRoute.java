package com.sofkaU.software.demo.router;

import com.sofkaU.software.demo.dto.CategoryDTO;
import com.sofkaU.software.demo.usecases.CreateCategoryUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreateCategoryRoute {

    @Bean
    public RouterFunction<ServerResponse> createCateg (CreateCategoryUseCase createCat){
        return route(POST("create/category").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(CategoryDTO.class)
                        .flatMap(createCat::createCategory)
                        .flatMap(categoryDTO -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(createCat))
                        .onErrorResume(e -> ServerResponse.status(HttpStatus.BAD_REQUEST).build()));
    }

}
