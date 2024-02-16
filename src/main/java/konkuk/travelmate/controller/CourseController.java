package konkuk.travelmate.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.hibernate.query.sqm.tree.SqmNode.log;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users/{userId}/courses")
public class CourseController {

    @GetMapping("/{courseId}")
    private String showCourseInfo(@PathVariable Long userId, @PathVariable Long courseId) {
        log.info("[CourseController.showCourseInfo]");
        return "unwell_deepsearch";
    }

}
