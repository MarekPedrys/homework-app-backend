package pl.marekpedrys.homework.data;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.marekpedrys.homework.data.entities.MathProblemEntity;
import pl.marekpedrys.homework.data.enums.MathProblemDepartment;
import pl.marekpedrys.homework.data.enums.MathProblemLevel;
import pl.marekpedrys.homework.data.enums.MathProblemYearOfStudy;
import pl.marekpedrys.homework.data.repositories.MathProblemRepository;


@Component
@AllArgsConstructor
public class DbInit {

    private final MathProblemRepository mathProblemRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void initDb() {
        mathProblemRepository.save(new MathProblemEntity(MathProblemYearOfStudy.SECONDARY_SCHOOL_1, MathProblemLevel.BASIC, MathProblemDepartment.FUNKCJE, 3, "tresc zadania...", "rozwiazanie...", "info...", false));
        mathProblemRepository.save(new MathProblemEntity(MathProblemYearOfStudy.SECONDARY_SCHOOL_2, MathProblemLevel.BASIC, MathProblemDepartment.PLANIMETRIA, 3, "tresc zadania...", "rozwiazanie...", "info...", true));
        mathProblemRepository.save(new MathProblemEntity(MathProblemYearOfStudy.SECONDARY_SCHOOL_3, MathProblemLevel.ADVANCED, MathProblemDepartment.CIAGI, 3, "tresc zadania...", "rozwiazanie...", "info...", false));
        mathProblemRepository.save(new MathProblemEntity(MathProblemYearOfStudy.SECONDARY_SCHOOL_3, MathProblemLevel.ADVANCED, MathProblemDepartment.GEOMETRIA_ANALITYCZNA, 3, "tresc zadania...", "rozwiazanie...", "info...", false));
        mathProblemRepository.save(new MathProblemEntity(MathProblemYearOfStudy.SECONDARY_SCHOOL_4, MathProblemLevel.ADVANCED, MathProblemDepartment.LICZBY_RZECZYWISTE, 3, "tresc zadania...", "rozwiazanie...", "info...", false));
        mathProblemRepository.save(new MathProblemEntity(MathProblemYearOfStudy.SECONDARY_SCHOOL_3, MathProblemLevel.ADVANCED, MathProblemDepartment.FUNKCJE, 3, "tresc zadania...", "rozwiazanie...", "info...", false));
        mathProblemRepository.save(new MathProblemEntity(MathProblemYearOfStudy.SECONDARY_SCHOOL_3, MathProblemLevel.BASIC, MathProblemDepartment.FUNKCJE, 3, "tresc zadania...", "rozwiazanie...", "info...", false));
        mathProblemRepository.save(new MathProblemEntity(MathProblemYearOfStudy.SECONDARY_SCHOOL_3, MathProblemLevel.ADVANCED, MathProblemDepartment.FUNKCJE, 3, "tresc zadania...", "rozwiazanie...", "info...", false));
        mathProblemRepository.save(new MathProblemEntity(MathProblemYearOfStudy.SECONDARY_SCHOOL_4, MathProblemLevel.BASIC, MathProblemDepartment.RACHUNEK_PRAWDOPODOBIENSTWA_I_STATYSTYKA, 2, "tresc zadania...", "rozwiazanie...", "info...", false));
        mathProblemRepository.save(new MathProblemEntity(MathProblemYearOfStudy.SECONDARY_SCHOOL_4, MathProblemLevel.ADVANCED, MathProblemDepartment.RACHUNEK_PRAWDOPODOBIENSTWA_I_STATYSTYKA, 5, "tresc zadania...", "rozwiazanie...", "info...", false));
    }

}
