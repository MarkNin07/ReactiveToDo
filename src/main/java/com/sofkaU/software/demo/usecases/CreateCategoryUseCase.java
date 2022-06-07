package com.sofkaU.software.demo.usecases;


import com.sofkaU.software.demo.dto.CategoryDTO;
import com.sofkaU.software.demo.mapper.ModeMap;
import com.sofkaU.software.demo.repository.ICategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CreateCategoryUseCase {

    private final ICategoryRepository categoryRepo;

    private final ModeMap mapper;


    private boolean validateFields(CategoryDTO categoryDTO){
        return categoryDTO.getTitle() != null && categoryDTO.getMessage() != null;
    }

    private Mono<CategoryDTO> validateCategDto(CategoryDTO categoryDTO){
        return Mono.just(categoryDTO)
                .filter(this::validateFields)
                .switchIfEmpty(Mono.error(() -> new Throwable("Some fields are empty")));
    }

    public Mono<CategoryDTO> createCategory(CategoryDTO categoryDTO){
        return validateCategDto(categoryDTO)
                .flatMap((categoryDTO1) -> categoryRepo.save(mapper.toCategoryCollection(categoryDTO1)))
                .map(mapper::toCategoryDto);
    }



}
