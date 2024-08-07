package pl.marekpedrys.homework.utils;

import pl.marekpedrys.homework.data.entities.MathProblemEntity;
import pl.marekpedrys.homework.web.models.CreateMathProblemRequest;
import pl.marekpedrys.homework.web.models.MathProblemResponseForTeacher;

public class MathProblemMapper {
    private MathProblemMapper() {
    }

    public static MathProblemResponseForTeacher mapToResponseForTeacher(MathProblemEntity entity) {
        return new MathProblemResponseForTeacher(
                entity.getId(),
                entity.getYearOfStudy(),
                entity.getLevel(),
                entity.getDepartment(),
                entity.getPoints(),
                entity.getContent(),
                entity.getSolution(),
                entity.getInfo(),
                entity.getArchived());
    }

    public static MathProblemEntity mapToEntity(CreateMathProblemRequest request) {
        return new MathProblemEntity(
                request.yearOfStudy(),
                request.level(),
                request.department(),
                request.points(),
                request.content(),
                request.solution(),
                request.info(),
                false);
    }

}
