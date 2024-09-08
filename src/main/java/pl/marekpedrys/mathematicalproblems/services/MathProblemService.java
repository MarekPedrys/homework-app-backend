package pl.marekpedrys.mathematicalproblems.services;

import lombok.AllArgsConstructor;
import org.apache.tika.Tika;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.marekpedrys.mathematicalproblems.data.entities.MathProblem;
import pl.marekpedrys.mathematicalproblems.data.enums.MathProblemDepartment;
import pl.marekpedrys.mathematicalproblems.data.enums.MathProblemLevel;
import pl.marekpedrys.mathematicalproblems.data.repositories.MathProblemRepository;
import pl.marekpedrys.mathematicalproblems.data.specifications.MathProblemSpecification;
import pl.marekpedrys.mathematicalproblems.web.errors.ImageSavingError;
import pl.marekpedrys.mathematicalproblems.web.errors.ImageTypeError;

import java.io.IOException;


@Service
@AllArgsConstructor
public class MathProblemService {
    private final MathProblemRepository repository;
    public static final int PAGE_SIZE = 5;
    public static final String SORT_COLUMN = "id";
    public static final Sort.Direction SORT_DIRECTION = Sort.Direction.DESC;
    public static final String EXPECTED_MIME_TYPE = "image/png";

    public Page<MathProblem> findAllBySpecificationAndPage(MathProblemDepartment department,
                                                           MathProblemLevel level,
                                                           Integer points,
                                                           Integer pageNumber) {
        Specification<MathProblem> specification = MathProblemSpecification.of(department, level, points);
        PageRequest pageRequest = PageRequest.of(pageNumber, PAGE_SIZE, Sort.by(SORT_DIRECTION, SORT_COLUMN));
        return repository.findAll(specification, pageRequest);
    }

    public void create(MathProblem newMathProblem, MultipartFile file) {
        if (isFileTypeValid(file)) {
            try {
                newMathProblem.setImageData(file.getBytes());
            } catch (IOException e) {
                throw new ImageSavingError();
            }
            repository.save(newMathProblem);
        } else {
            throw new ImageTypeError();
        }
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private boolean isFileTypeValid(MultipartFile file) {
        try {
            Tika tika = new Tika();
            String fileMimeType = tika.detect(file.getInputStream());
            return fileMimeType.equals(EXPECTED_MIME_TYPE);
        } catch (IOException e) {
            throw new ImageSavingError();
        }
    }

}
