package com.foodorder.Food.Ordering.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.List;

@Data
@Embeddable
public class RestautontDto {

    private String title;

    @Column(length = 1000)
    private List<String> images;

    private String description;

    private Long id;

}
