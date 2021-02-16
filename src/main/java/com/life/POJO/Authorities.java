package com.life.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Authorities {
    private String number;

    private String competence;

    private String name;

    private String token;
}