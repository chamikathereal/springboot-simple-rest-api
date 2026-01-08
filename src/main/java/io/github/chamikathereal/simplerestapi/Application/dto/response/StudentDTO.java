package io.github.chamikathereal.simplerestapi.Application.dto.response;

import lombok.Data;

@Data
public class StudentDTO {
    private Integer id;
    private String name;
    private Integer grade;
}
