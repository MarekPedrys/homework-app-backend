package pl.marekpedrys.mathematicalproblems.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.marekpedrys.mathematicalproblems.data.enums.MathProblemDepartment;
import pl.marekpedrys.mathematicalproblems.services.StatService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class StatController {

    private final StatService statService;

    @GetMapping("/math-problems/stats")
    public String getStats(Model model) {
        List<MathProblemDepartment> usedDepartments = statService.getAllUsedMathProblemDepartments();
        Map<String, Long> countsByUsedDepartments = usedDepartments.stream()
                .collect(Collectors.groupingBy(MathProblemDepartment::getLabel, Collectors.counting()));
        Map<String, Long> countsByAllDepartments = new LinkedHashMap<>();
        for (MathProblemDepartment department : MathProblemDepartment.values()) {
            countsByAllDepartments.put(department.getLabel(), countsByUsedDepartments.getOrDefault(department.getLabel(), 0L));
        }
        model.addAttribute("labels", countsByAllDepartments.keySet());
        model.addAttribute("data", countsByAllDepartments.values());
        return "stats";
    }

}
