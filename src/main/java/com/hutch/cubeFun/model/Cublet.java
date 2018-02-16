package com.hutch.cubeFun.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
public class Cublet {
    private int id;
    private Integer value;
}
