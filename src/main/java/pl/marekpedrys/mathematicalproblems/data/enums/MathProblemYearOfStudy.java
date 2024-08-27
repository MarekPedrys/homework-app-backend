package pl.marekpedrys.mathematicalproblems.data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MathProblemYearOfStudy {
    SECONDARY_SCHOOL_1("1 LO"),
    SECONDARY_SCHOOL_2("2 LO"),
    SECONDARY_SCHOOL_3("3 LO"),
    SECONDARY_SCHOOL_4("4 LO");

    private final String label;
}
