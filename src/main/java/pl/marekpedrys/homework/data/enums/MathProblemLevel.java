package pl.marekpedrys.homework.data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MathProblemLevel {
    BASIC("Podstawowy"),
    ADVANCED("Rozszerzony");

    private final String label;
}
