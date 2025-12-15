package com.example.demo.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL) // Quita los campos nulos en la respuesta JSON
public class ListResponseDTO<T> {

    private boolean success;
    private String message;
    private List<T> data;
    private long total;
    private Integer page;
    private Integer size;

    public ListResponseDTO() {}

    public ListResponseDTO(boolean success, String message, List<T> data, long total) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.total = total;
    }

    public ListResponseDTO(boolean success, String message, List<T> data, long total, Integer page, Integer size) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.total = total;
        this.page = page;
        this.size = size;
    }


}
