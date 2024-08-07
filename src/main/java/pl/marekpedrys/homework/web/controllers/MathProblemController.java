package pl.marekpedrys.homework.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.marekpedrys.homework.data.enums.MathProblemDepartment;
import pl.marekpedrys.homework.data.enums.MathProblemLevel;
import pl.marekpedrys.homework.data.enums.MathProblemYearOfStudy;
import pl.marekpedrys.homework.services.MathProblemService;
import pl.marekpedrys.homework.web.models.CreateMathProblemRequest;
import pl.marekpedrys.homework.web.models.MathProblemResponseForTeacher;

import java.util.List;

@RestController
@RequestMapping("math-problems")
@RequiredArgsConstructor
public class MathProblemController {

    private final MathProblemService mathProblemService;

    @GetMapping
    public ResponseEntity<List<MathProblemResponseForTeacher>> findAllBySpecificationAndPage(@RequestParam(required = false) Long id,
                                                                                             @RequestParam(required = false) MathProblemYearOfStudy yearOfStudy,
                                                                                             @RequestParam(required = false) MathProblemLevel level,
                                                                                             @RequestParam(required = false) MathProblemDepartment department,
                                                                                             @RequestParam(required = false) Integer points,
                                                                                             @RequestParam(required = false) String info,
                                                                                             @RequestParam(required = false) Boolean skipArchived,
                                                                                             @RequestParam(required = false, defaultValue = "0") Integer pageNumber,
                                                                                             @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return ResponseEntity.ok(mathProblemService.findAllBySpecificationAndPage(id, yearOfStudy, level, department, points, info, skipArchived, pageNumber, pageSize));
    }

    @PostMapping
    public ResponseEntity<MathProblemResponseForTeacher> createMathProblem(@RequestBody CreateMathProblemRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mathProblemService.create(request));
    }

}
