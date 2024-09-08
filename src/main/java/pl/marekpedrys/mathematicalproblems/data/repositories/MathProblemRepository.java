package pl.marekpedrys.mathematicalproblems.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.marekpedrys.mathematicalproblems.data.entities.MathProblem;
import pl.marekpedrys.mathematicalproblems.data.enums.MathProblemDepartment;

import java.util.List;

@Repository
public interface MathProblemRepository extends JpaRepository<MathProblem, Long>, JpaSpecificationExecutor<MathProblem> {
    @Query("SELECT m.department FROM  MathProblem m")
    List<MathProblemDepartment> getAllUsedMathProblemDepartments();
}
