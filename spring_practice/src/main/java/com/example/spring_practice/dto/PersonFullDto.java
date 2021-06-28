package com.example.spring_practice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class PersonFullDto {

    private Long id;

    private String userName;

    private String activityName;
}
