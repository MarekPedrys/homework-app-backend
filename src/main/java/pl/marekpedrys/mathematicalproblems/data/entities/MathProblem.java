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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public String generateBase64Image() {
        return Base64.getEncoder().encodeToString(this.getImageData());
    }

}
