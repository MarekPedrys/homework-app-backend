package pl.marekpedrys.mathematicalproblems.data.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.marekpedrys.mathematicalproblems.data.enums.MathProblemDepartment;
import pl.marekpedrys.mathematicalproblems.data.enums.MathProblemLevel;

import java.util.Base64;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MathProblem {

    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    @NotNull
    private MathProblemDepartment department;
    @Enumerated(EnumType.STRING)
    @NotNull
    private MathProblemLevel level;
    @NotNull
    private Integer points;
    @Lob
    @NotNull
    private byte[] imageData;

    public MathProblem(MathProblemDepartment department, MathProblemLevel level, Integer points, byte[] imageData) {
        this.department = department;
        this.level = level;
        this.points = points;
        this.imageData = imageData;
    }

    public String generateBase64Image() {
        return Base64.getEncoder().encodeToString(this.getImageData());
    }

}
