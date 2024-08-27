package pl.marekpedrys.mathematicalproblems.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.marekpedrys.mathematicalproblems.data.entities.MathProblem;

@Repository
public interface MathProblemRepository extends JpaRepository<MathProblem, Long> {
}
