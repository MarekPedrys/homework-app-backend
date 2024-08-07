package pl.marekpedrys.homework.web.models;

import pl.marekpedrys.homework.data.enums.MathProblemDepartment;
import pl.marekpedrys.homework.data.enums.MathProblemLevel;
import pl.marekpedrys.homework.data.enums.MathProblemYearOfStudy;

public record MathProblemResponseForTeacher(Long id,
                                            MathProblemYearOfStudy yearOfStudy,
                                            MathProblemLevel level,
                                            MathProblemDepartment department,
                                            Integer points,
                                            String content,
                                            String solution,
                                            String info,
                                            Boolean archived) {
}
