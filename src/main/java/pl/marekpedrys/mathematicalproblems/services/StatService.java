package pl.marekpedrys.mathematicalproblems.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.marekpedrys.mathematicalproblems.data.enums.MathProblemDepartment;
import pl.marekpedrys.mathematicalproblems.data.repositories.MathProblemRepository;

import java.util.List;


@Service
@AllArgsConstructor
public class StatService {
    private final MathProblemRepository repository;

    public List<MathProblemDepartment> getAllUsedMathProblemDepartments() {
        return repository.getAllUsedMathProblemDepartments();
    }

}
