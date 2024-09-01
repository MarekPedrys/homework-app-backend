package pl.marekpedrys.mathematicalproblems.data;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.marekpedrys.mathematicalproblems.data.entities.MathProblem;
import pl.marekpedrys.mathematicalproblems.data.enums.MathProblemDepartment;
import pl.marekpedrys.mathematicalproblems.data.enums.MathProblemLevel;
import pl.marekpedrys.mathematicalproblems.data.enums.MathProblemYearOfStudy;
import pl.marekpedrys.mathematicalproblems.data.repositories.MathProblemRepository;


@Component
@AllArgsConstructor
public class DbInit {

    private final MathProblemRepository mathProblemRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void initDb() {
        mathProblemRepository.save(new MathProblem(MathProblemYearOfStudy.SECONDARY_SCHOOL_1, MathProblemLevel.BASIC, MathProblemDepartment.ROWNANIA_I_NIEROWNOSCI, 1, "tresc zadania..."));
        mathProblemRepository.save(new MathProblem(MathProblemYearOfStudy.SECONDARY_SCHOOL_2, MathProblemLevel.BASIC, MathProblemDepartment.GEOMETRIA_ANALITYCZNA, 1, "tresc zadania..."));
        mathProblemRepository.save(new MathProblem(MathProblemYearOfStudy.SECONDARY_SCHOOL_3, MathProblemLevel.ADVANCED, MathProblemDepartment.CIAGI, 1, "tresc zadania..."));
        mathProblemRepository.save(new MathProblem(MathProblemYearOfStudy.SECONDARY_SCHOOL_3, MathProblemLevel.BASIC, MathProblemDepartment.TRYGONOMETRIA, 1, "tresc zadania..."));
        mathProblemRepository.save(new MathProblem(MathProblemYearOfStudy.SECONDARY_SCHOOL_4, MathProblemLevel.BASIC, MathProblemDepartment.PLANIMETRIA, 1, "tresc zadania..."));
        mathProblemRepository.save(new MathProblem(MathProblemYearOfStudy.SECONDARY_SCHOOL_3, MathProblemLevel.ADVANCED, MathProblemDepartment.STEREOMETRIA, 5, "tresc zadania..."));
        mathProblemRepository.save(new MathProblem(MathProblemYearOfStudy.SECONDARY_SCHOOL_3, MathProblemLevel.BASIC, MathProblemDepartment.RACHUNEK_PRAWDOPODOBIENSTWA_I_STATYSTYKA, 1, "tresc zadania..."));
        mathProblemRepository.save(new MathProblem(MathProblemYearOfStudy.SECONDARY_SCHOOL_3, MathProblemLevel.ADVANCED, MathProblemDepartment.FUNKCJE, 2, "tresc zadania..."));
        mathProblemRepository.save(new MathProblem(MathProblemYearOfStudy.SECONDARY_SCHOOL_4, MathProblemLevel.BASIC, MathProblemDepartment.GEOMETRIA_ANALITYCZNA, 2, "tresc zadania..."));
        mathProblemRepository.save(new MathProblem(MathProblemYearOfStudy.SECONDARY_SCHOOL_4, MathProblemLevel.ADVANCED, MathProblemDepartment.FUNKCJE, 1, "tresc zadania..."));
        mathProblemRepository.save(new MathProblem(MathProblemYearOfStudy.SECONDARY_SCHOOL_2, MathProblemLevel.ADVANCED, MathProblemDepartment.LICZBY_RZECZYWISTE, 3, "tresc zadania..."));
        mathProblemRepository.save(new MathProblem(MathProblemYearOfStudy.SECONDARY_SCHOOL_1, MathProblemLevel.ADVANCED, MathProblemDepartment.CIAGI, 4, "tresc zadania..."));
    }

}
