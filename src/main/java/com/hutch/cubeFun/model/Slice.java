package com.hutch.cubeFun.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
public class Slice {
    private int id;
    private Row[] row;
}
