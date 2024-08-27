package pl.marekpedrys.mathematicalproblems.data.specifications;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import pl.marekpedrys.mathematicalproblems.data.entities.MathProblem;
import pl.marekpedrys.mathematicalproblems.data.enums.MathProblemDepartment;
import pl.marekpedrys.mathematicalproblems.data.enums.MathProblemLevel;
import pl.marekpedrys.mathematicalproblems.data.enums.MathProblemYearOfStudy;

import java.util.ArrayList;
import java.util.List;

public class MathProblemSpecification {

    private MathProblemSpecification() {
    }

    public static Specification<MathProblem> of(Long id,
                                                MathProblemYearOfStudy yearOfStudy,
                                                MathProblemLevel level,
                                                MathProblemDepartment department,
                                                Integer points) {
        return (root, query, builder) -> {
            List<Predicate> predicateList = new ArrayList<>();

            if (id != null) {
                predicateList.add(builder.equal(root.get("id"), id));
            }

            if (yearOfStudy != null) {
                predicateList.add(builder.equal(root.get("yearOfStudy"), yearOfStudy));
            }

            if (level != null) {
                predicateList.add(builder.equal(root.get("level"), level));
            }

            if (department != null) {
                predicateList.add(builder.equal(root.get("department"), department));
            }

            if (points != null) {
                predicateList.add(builder.equal(root.get("points"), (points)));
            }

            return builder.and(predicateList.toArray(new Predicate[]{}));
        };
    }

}
