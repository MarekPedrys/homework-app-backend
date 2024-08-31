package pl.marekpedrys.mathematicalproblems.services;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.marekpedrys.mathematicalproblems.data.entities.MathProblem;
import pl.marekpedrys.mathematicalproblems.data.enums.MathProblemDepartment;
import pl.marekpedrys.mathematicalproblems.data.enums.MathProblemLevel;
import pl.marekpedrys.mathematicalproblems.data.enums.MathProblemYearOfStudy;
import pl.marekpedrys.mathematicalproblems.data.repositories.MathProblemRepository;
import pl.marekpedrys.mathematicalproblems.data.specifications.MathProblemSpecification;


@Service
@AllArgsConstructor
public class MathProblemService {
    private final MathProblemRepository repository;
    public static final int PAGE_SIZE = 5;
    public static final String SORT_COLUMN = "id";
    public static final Sort.Direction SORT_DIRECTION = Sort.Direction.DESC;

    public Page<MathProblem> findAllBySpecificationAndPage(Long id,
                                                           MathProblemYearOfStudy yearOfStudy,
                                                           MathProblemLevel level,
                                                           MathProblemDepartment department,
                                                           Integer points,
                                                           Integer pageNumber) {
        Specification<MathProblem> specification = MathProblemSpecification.of(id, yearOfStudy, level, department, points);
        PageRequest pageRequest = PageRequest.of(pageNumber, PAGE_SIZE, Sort.by(SORT_DIRECTION, SORT_COLUMN));
        return repository.findAll(specification, pageRequest);
    }

    public void create(MathProblem newMathProblem) {
        repository.save(newMathProblem);
    }

}
