package pl.marekpedrys.homework.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.marekpedrys.homework.data.entities.MathProblemEntity;
import pl.marekpedrys.homework.data.enums.MathProblemDepartment;
import pl.marekpedrys.homework.data.enums.MathProblemLevel;
import pl.marekpedrys.homework.data.enums.MathProblemYearOfStudy;
import pl.marekpedrys.homework.data.repositories.MathProblemRepository;
import pl.marekpedrys.homework.data.specifications.MathProblemSpecification;
import pl.marekpedrys.homework.web.models.MathProblemResponseForTeacher;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MathProblemService {

    private final MathProblemRepository mathProblemRepository;

    public List<MathProblemResponseForTeacher> findAllBySpecificationAndPage(Long id,
                                                                             MathProblemYearOfStudy yearOfStudy,
                                                                             MathProblemLevel level,
                                                                             MathProblemDepartment department,
                                                                             Integer points,
                                                                             String info,
                                                                             Boolean skipArchived,
                                                                             Integer pageNumber,
                                                                             Integer pageSize) {
        Specification<MathProblemEntity> specification = MathProblemSpecification.of(id, yearOfStudy, level, department,
                points, info, skipArchived);
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, "id"));
        Page<MathProblemEntity> pageOfEntities = mathProblemRepository.findAll(specification, pageRequest);
        return pageOfEntities.getContent().stream()
                .map(MathProblemResponseForTeacher::new)
                .toList();
    }

}
