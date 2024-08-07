package pl.marekpedrys.homework.data.specifications;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import pl.marekpedrys.homework.data.entities.MathProblemEntity;
import pl.marekpedrys.homework.data.enums.MathProblemDepartment;
import pl.marekpedrys.homework.data.enums.MathProblemLevel;
import pl.marekpedrys.homework.data.enums.MathProblemYearOfStudy;

import java.util.ArrayList;
import java.util.List;

public class MathProblemSpecification {

    private MathProblemSpecification() {
    }

    public static Specification<MathProblemEntity> of(Long id,
                                                      MathProblemYearOfStudy yearOfStudy,
                                                      MathProblemLevel level,
                                                      MathProblemDepartment department,
                                                      Integer points,
                                                      String info,
                                                      Boolean skipArchived) {
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

            if (info != null) {
                predicateList.add(builder.like(root.get("info"), "%" + info + "%"));
            }

            if (Boolean.TRUE.equals(skipArchived)) {
                predicateList.add(builder.equal(root.get("archived"), false));
            }

            return builder.and(predicateList.toArray(new Predicate[]{}));
        };
    }

}
