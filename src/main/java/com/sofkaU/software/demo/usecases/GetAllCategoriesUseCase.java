package com.sofkaU.software.demo.usecases;


import com.sofkaU.software.demo.dto.CategoryDTO;
import com.sofkaU.software.demo.mapper.ModeMap;
import com.sofkaU.software.demo.repository.ICategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetAllCategoriesUseCase {

    private final ICategoryRepository categoryRepo;

    private final ModeMap mapper;

    public Flux<CategoryDTO> getAllCategories(){
        return categoryRepo.findAll().map(mapper::toCategoryDto);
    }

}
