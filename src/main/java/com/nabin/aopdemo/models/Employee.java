package com.nabin.aopdemo.models;

import lombok.*;

/**
 * @author Narendra
 * @version 1.0
 * @since 2023-01-16
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    private Integer id;
    private String name;
    private String address;
}
