package com.hutch.cubeFun.model;

import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
public class CubeFunRequest {
    Slice[] slice;
}
