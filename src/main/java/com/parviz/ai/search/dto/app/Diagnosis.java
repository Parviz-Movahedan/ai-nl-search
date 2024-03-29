package com.parviz.ai.search.dto.app;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Diagnosis {
    List<String> typicalSymptoms;
    String typicalPrognosis;
}
