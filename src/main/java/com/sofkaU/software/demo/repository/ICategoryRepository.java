package com.sofkaU.software.demo.repository;

import com.sofkaU.software.demo.collections.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ICategoryRepository extends ReactiveMongoRepository<Category, String> {
}
