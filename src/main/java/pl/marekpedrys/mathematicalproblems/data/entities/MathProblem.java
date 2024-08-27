package pl.marekpedrys.mathematicalproblems.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.marekpedrys.mathematicalproblems.data.enums.MathProblemDepartment;
import pl.marekpedrys.mathematicalproblems.data.enums.MathProblemLevel;
import pl.marekpedrys.mathematicalproblems.data.enums.MathProblemYearOfStudy;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MathProblem {

    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    private MathProblemYearOfStudy yearOfStudy;
    @Enumerated(EnumType.STRING)
    private MathProblemLevel level;
    @Enumerated(EnumType.STRING)
    private MathProblemDepartment department;
    private Integer points;
    private String content;

    public MathProblem(MathProblemYearOfStudy yearOfStudy,
                       MathProblemLevel level,
                       MathProblemDepartment department,
                       Integer points,
                       String content) {
        this.yearOfStudy = yearOfStudy;
        this.level = level;
        this.department = department;
        this.points = points;
        this.content = content;
    }

}
