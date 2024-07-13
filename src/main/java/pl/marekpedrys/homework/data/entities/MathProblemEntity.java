package pl.marekpedrys.homework.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.marekpedrys.homework.data.enums.MathProblemDepartment;
import pl.marekpedrys.homework.data.enums.MathProblemLevel;
import pl.marekpedrys.homework.data.enums.MathProblemYearOfStudy;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MathProblemEntity {

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
    private String solution;
    private String info;
    private Boolean archived;

    public MathProblemEntity(MathProblemYearOfStudy yearOfStudy,
                             MathProblemLevel level,
                             MathProblemDepartment department,
                             Integer points,
                             String content,
                             String solution,
                             String info,
                             Boolean archived) {
        this.yearOfStudy = yearOfStudy;
        this.level = level;
        this.department = department;
        this.points = points;
        this.content = content;
        this.solution = solution;
        this.info = info;
        this.archived = archived;
    }

}
