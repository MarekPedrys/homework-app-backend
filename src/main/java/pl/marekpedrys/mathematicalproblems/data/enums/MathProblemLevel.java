package pl.marekpedrys.mathematicalproblems.data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MathProblemLevel {
    BASIC("podstawowy"),
    ADVANCED("rozszerzony");

    private String label;
}
