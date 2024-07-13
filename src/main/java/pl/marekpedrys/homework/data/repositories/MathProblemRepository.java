package pl.marekpedrys.homework.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pl.marekpedrys.homework.data.entities.MathProblemEntity;

@Repository
public interface MathProblemRepository extends JpaRepository<MathProblemEntity, Long>, JpaSpecificationExecutor<MathProblemEntity> {
}
