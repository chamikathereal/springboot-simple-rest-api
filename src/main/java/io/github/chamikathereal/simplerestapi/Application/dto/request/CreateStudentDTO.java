package io.github.chamikathereal.simplerestapi.Application.dto.request;

import lombok.Data;

@Data
public class CreateStudentDTO {
    private Integer id;
    private String name;
    private String address;
    private String email;
    private Integer grade;
}
