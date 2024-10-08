package pl.marekpedrys.mathematicalproblems.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.marekpedrys.mathematicalproblems.data.entities.MathProblem;
import pl.marekpedrys.mathematicalproblems.data.enums.MathProblemDepartment;
import pl.marekpedrys.mathematicalproblems.data.enums.MathProblemLevel;
import pl.marekpedrys.mathematicalproblems.services.MathProblemService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequiredArgsConstructor
public class MathProblemController {

    private final MathProblemService service;

    @GetMapping("/math-problems/list")
    public String findAllBySpecificationAndPage(@RequestParam(required = false) MathProblemDepartment department,
                                                @RequestParam(required = false) MathProblemLevel level,
                                                @RequestParam(required = false) Integer points,
                                                @RequestParam(required = false, defaultValue = "0") Integer pageNumber,
                                                Model model) {
        Page<MathProblem> page = service.findAllBySpecificationAndPage(department, level, points, pageNumber);
        model.addAttribute("mathProblemListAtt", page.getContent());
        model.addAttribute("pageNumberAtt", pageNumber);
        model.addAttribute("totalPagesAtt", page.getTotalPages());
        List<Integer> pageNumbers = IntStream.rangeClosed(1, page.getTotalPages())
                .boxed()
                .collect(Collectors.toList());
        model.addAttribute("pageNumbersAtt", pageNumbers);
        model.addAttribute("levelAtt", level);
        model.addAttribute("levelListAtt", MathProblemLevel.values());
        model.addAttribute("departmentAtt", department);
        model.addAttribute("departmentListAtt", MathProblemDepartment.values());
        model.addAttribute("pointsAtt", points);
        model.addAttribute("pointsListAtt", List.of(1, 2, 3, 4, 5, 6));
        return "list";
    }

    @GetMapping("/math-problems/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(Model model) {
        model.addAttribute("newMathProblem", new MathProblem());
        model.addAttribute("levelListAtt", MathProblemLevel.values());
        model.addAttribute("departmentListAtt", MathProblemDepartment.values());
        model.addAttribute("pointsListAtt", List.of(1, 2, 3, 4, 5, 6));
        return "create";
    }

    @PostMapping("/math-problems/create")
    public String createAction(MathProblem newMathProblem, @RequestParam("image") MultipartFile file, Model model) {
        service.create(newMathProblem, file);
        return "redirect:/math-problems/list";
    }

    @GetMapping("/math-problems/{id}/delete")
    public String deleteAction(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/math-problems/list";
    }

    @GetMapping
    public String redirect() {
        return "redirect:/math-problems/list";
    }

}
