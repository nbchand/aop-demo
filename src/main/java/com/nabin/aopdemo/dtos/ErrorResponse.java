package com.nabin.aopdemo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Narendra
 * @version 1.0
 * @since 2023-01-16
 */
@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
    private String error;
}
