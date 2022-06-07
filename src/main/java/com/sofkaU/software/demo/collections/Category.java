package com.sofkaU.software.demo.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.List;


@Document(collection = "category")
@Data
public class Category {

    @Id
    private String id;

    @NotBlank(message = "The Title field cannot be blank")
    private String title;

    @NotBlank(message = "The message field cannot be blank")
    private String message;

    private List<ToDo> toDos;




}
