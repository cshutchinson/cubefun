package com.hutch.cubeFun.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
public class Row {
    private int id;
    private Cublet[] column;


}
