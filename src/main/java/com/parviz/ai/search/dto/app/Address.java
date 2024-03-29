package com.parviz.ai.search.dto.app;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String address;
    private String city;
    private String state;
    private String country;
}
